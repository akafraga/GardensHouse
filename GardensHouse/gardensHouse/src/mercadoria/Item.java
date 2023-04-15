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
	public void mostrar(List<Item> carrinho, List<Vendas> historicoDeVendas, Scanner input) {
		if(carrinho.isEmpty() == false || historicoDeVendas.isEmpty() == false) {
			int cont = 0;
			double total = 0;
			
			for (Item c : carrinho) {
				cont++;
	        	c.setId(cont);
	        }
			
			for (Item c : carrinho) {
	        	System.out.println(c.getId() + " - "+ c.getNome() + " - qtd: " + c.getQtd() + " --- Preço: " + c.getPreco()*c.getQtd()); 
	        	total = total + c.getPreco()*c.getQtd();
	        }
			
			System.out.println("--------------------------------------");
			System.out.println("Total:                          " + total);
		} else {
		System.out.println("Carrinho vazio.");
		}
	}

	// Adiciona um item ao carrinho de compras
	public void adicionar(List<Produto> estoque, List<Item> carrinho, List<Vendas> historicoDeVendas, Scanner input) {
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
	}

	// Remove um item do carrinho de compras
	public void remover(List<Item> carrinho, List<Vendas> historicoDeVendas, Scanner input) {
		if(carrinho.isEmpty() == false) {
			int cont = 0;
			int id = 0;
			int qtd = 0;
			
			for (Item c : carrinho) {
				cont++;
				c.setId(cont); // settando o id de cada um dos produtos de forma manual, 100% atualizada igual bomba patch
			}	

			
			while(id == 0) { // enquanto id for maior ou menor que o contador que é 
				mostrar(carrinho, historicoDeVendas, input); // a quantidade de itens no carrinho, vai rodar
				System.out.print("\nDigite o id: ");
				id = input.nextInt();
				if(id > cont || id < 1 || id == 0) { // um aviso caso o id digitado não seja de nenhum item do carrinho
					System.out.println("Não existe esse id. Tente novamente."); // <- o aviso
					id = 0;
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
		} else {
			System.out.println("Carrinho vazio.");
		}
	}

	// Exclui o carrinho de compras ao finalizar
	public void excluir(List<Item> carrinho) {
		carrinho.clear(); // função de limpar o carrinho, mt útil
	}

	// Finaliza o carrinho de compras
	public void finalizar(List<Funcionario> colaboradores, List<Item> carrinho,  List<Cliente> clientela, List<Vendas> historicoDeVendas, Cliente fregues, Scanner input ) {
		
		if(carrinho.isEmpty() == false) {
			mostrar(carrinho, historicoDeVendas, input);
			int aux = 0; // pra executar o while enquanto não for respondida a pergunta
			while(aux == 0) {
				System.out.print("Deseja finalizar o carrinho? [S/N] ");
				char op = input.next().charAt(0);
				
				if(op == 'N' || op == 'n' || op == 'S' || op == 's') {  // VOLTAR AO MENU ou FINALIZAR O CARRINHO
					
					
					if(op == 'S' || op == 's') {  // DE FATO FINALIZAR O CARRINHO 
						System.out.print("Digit o ID do funcionário: ");
						String idFuncionario = input.next();
						System.out.print("Digite o cpf do cliente: ");
						String cpf = input.next();
						
						
						fregues.testeCadastro(clientela, input, cpf);
						
						
						historicoDeVendas.add(new Vendas(cpf, idFuncionario, LocalDate.now(), carrinho));
						
						
						excluir(carrinho);
					}
					if(op == 'N' || op == 'n') {
						System.out.println("Voltando ao menu...");
					}
					aux = 1;
				} else {
					System.out.println("Opção inválida.");
				}
			}
		} else {
			System.out.println("Carrinho vazio.");
		}
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
