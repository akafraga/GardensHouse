package mercadoria;

import java.time.LocalDate;
// Importando bibliotecas que usaremos
import java.util.List;
import java.util.Scanner;

import individuo.Cliente;
import individuo.Funcionario;

/*
 * Essa classe é a classe Produto mas mais
 * refinada pois não precisamos de todas as
 * variáveis que existem na classe Produto.
 */
public class Item{
	
	
	// Declaração de variável
	private String nome;
	private double preco;
	private int qtd, id;
	private LocalDate dataDaCompra;
	
	
	// Construtor padrão
	public Item(String nome, double preco, int qtd) {
		this.nome = nome;
		this.preco = preco;
		this.qtd = qtd;

	}
	
	// Construtor para uso de métodos
	public Item() {
		
	}
	
	// Mostra o carrinho de compras
	public void mostrar(List<Item> carrinho) {
		if(carrinho.isEmpty() == false) {
			int cont = 0;
			for (Item c : carrinho) {
				cont++;
	        	c.setId(cont);
	        }
			for (Item c : carrinho) {
	        	System.out.println(c.getId() + " - "+ c.getNome() + " - qtd: " + c.getQtd() + " --- Preço: " + c.getPreco()*c.getQtd()); 
	        }
		} 
		System.out.println("Item vazio.");
	}

	// Adiciona um item ao carrinho de compras
	public void adicionar(List<Produto> estoque, List<Item> carrinho) {
		Scanner input = new Scanner(System.in);
	   	System.out.print("\nDigite o código: ");
		int id = input.nextInt();
		System.out.print("Digite a quantidade: ");
		int qtd = input.nextInt();
		for (Produto e : estoque) {
			if (e.getId() == id) {
				int aux = 0; // int auxiliar pra ajudar no controle do que precisa declarar na lista
				if(carrinho.isEmpty() == false) { // se não está vazio, entra nesse if
					for(Item c : carrinho) { // foreach - percorre a lista carrinho
						if (c.getNome() == e.getNome()) {  // se o nome do item for igual ao nome do produto, entra nesse if
							c.setQtd(c.getQtd()+qtd); // atualiza a qtd do item que já tem na lista.
							aux = 1;
						}
					}
					if(aux == 0) {
						carrinho.add(new Item(e.getNome(), e.getPreco(), qtd));
					}
				} else {
					carrinho.add(new Item(e.getNome(), e.getPreco(), qtd));
				}
				System.out.println("Item adicionado ao carrinho!");
			}
		}		
		input.close();
		System.out.println("\n\n");
	}

	// Remove um item do carrinho de compras
	public void remover(List<Item> carrinho) {
		if(carrinho.isEmpty() == false) {
			Scanner input = new Scanner(System.in);
			int cont = 0;
			int id = 0;
			int qtd = 0;
			for (Item c : carrinho) {
				cont++;
				c.setId(cont); // settando o id de cada um dos produtos de forma manual, 100% atualizada igual bomba patch
			}	
			while(id > cont || id < cont) { // enquanto id for maior ou menor que o contador que é 
				mostrar(carrinho); // a quantidade de itens no carrinho, vai rodar
				System.out.print("\nDigite o id: ");
				id = input.nextInt();
				if(id > cont || id < cont) { // um aviso caso o id digitado não seja de nenhum item do carrinho
					System.out.println("\nNão existe esse id. Tente novamente."); // <- o aviso
				}
			}	
			System.out.print("Digite o quantidade: ");
			qtd = input.nextInt();
			for(Item c : carrinho) { // foreachzin padrão
				if(c.getId() == id) { // se o id do item for o mesmo que o id digitado no console, ele roda
					if(c.getQtd() <= qtd) { // se a qtd do item for menor ou igual a qtd digitada no console, ele entra aqui
						carrinho.remove(id - 1);
						System.out.println("Item removido do carrinho.");
						break;
					} else { //caso a qtd do item no carrinho seja maior que a qtd digitada no console, ele entra aqui 
						c.setQtd(c.getQtd()-qtd);
						System.out.println("Quantidade de itens reduzida no carrinho.");
					}
				}
			}	
			input.close();
		} else {
			System.out.println("Item vazio.");
		}
		
		System.out.println("\n\n");
		
	}

	// Exclui o carrinho de compras ao finalizar
	public void excluir(List<Item> carrinho) {
		carrinho.clear(); // função de limpar o carrinho, mt útil
	}

	// Finaliza o carrinho de compras
	public void finalizar(List<Funcionario> colaboradores, List<Item> carrinho,  List<Cliente> clientela, List<Vendas> historicoDeVendas, Cliente fregues ) {
		
		if(carrinho.isEmpty() == false) {
			Scanner input = new Scanner(System.in);
			mostrar(carrinho);
			int aux = 0; // pra executar o while enquanto não for respondida a pergunta
			while(aux == 0) {
				System.out.print("Deseja finalizar o carrinho? [S/N] ");
				char op1 = input.next().charAt(0);
				
				if(op1 == 'N' || op1 == 'n' || op1 == 'S' || op1 == 's') {  // VOLTAR AO MENU ou FINALIZAR O CARRINHO
					
					
					if(op1 == 'S' || op1 == 's') {  // DE FATO FINALIZAR O CARRINHO 
						
						System.out.print("Digite o cpf do cliente: ");
						String cpf = input.next();
						
						boolean taNoClientela = false;
						for(Cliente c1 : clientela) {
							if(cpf == c1.getCpf()) {
								taNoClientela = true;
							}
						}
						if(taNoClientela == false) {
							System.out.print("Digite o nome completo: ");
							String nome = input.next();
							
							System.out.print("Digite o email: ");
							String email = input.next();
							
							System.out.print("Digite o cep: ");
							String cep = input.next();
							
							System.out.print("Digite o telefone: ");
							String telefone = input.next();
							
							System.out.print("Digite o dia: ");
							int dia = input.nextInt();
							
							System.out.print("Digite o mês: ");
							int mes = input.nextInt();
							
							System.out.print("Digite o ano: ");
							int ano = input.nextInt();
							
							clientela.add(new Cliente(nome, cpf, email, cep, telefone, LocalDate.of(ano, mes, dia)));
						}

						
						

						
						
						double total = 0;
						for (Item c : carrinho) {
							total = total + (c.getPreco() * c.getQtd());
						}
						double desconto = 0;
						
						if(total >= 2100) { // se valor gasto na loja for maior que 2100, cliente recebe 10% de desconto
							desconto = 0.05;
						}
						
						
						
						//if(.testeAniversario() == true) {
							//desconto = desconto + 0.05;
						//}
						
						total = total - total * desconto;
						System.out.println("Total a ser pago: " + total);
						//historicoDeVendas.add(new Venda());
						excluir(carrinho);
					}
					if(op1 == 'N' || op1 == 'n') {
						System.out.println("Voltando ao menu...");
					}
					aux = 1;
				} else {
					System.out.println("Opção inválida.");
				}
			}
			input.close();
		} else {
			System.out.println("Item vazio.");
		}
		System.out.println("\n\n");
	}
	
	
	// Get e Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDataDaCompra(LocalDate dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}
	
	public LocalDate getDataDaCompra() {
		return dataDaCompra;
	}

}
