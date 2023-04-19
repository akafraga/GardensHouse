package mercadoria;

import java.time.LocalDate;
import java.util.ArrayList;
// Importando bibliotecas que usaremos
import java.util.List;
import java.util.Scanner;

import individuo.Cliente;
import pagamento.Pagamento;

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
	public void mostrar(List<Item> carrinho, Scanner input) {
		if(carrinho.isEmpty() == false) {
			System.out.println("|----------------------------------------|");
			System.out.println("|          Carrinho de Compras           |");
			System.out.println("|----------------------------------------|");
			int cont = 0;
			double total = 0;
			
			for (Item c : carrinho) {
				cont++;
	        	c.setId(cont);
	        }
			
			for (Item c : carrinho) {
	        	System.out.printf("| %d - %s - qtd: %d - preço: R$%.2f", c.getId(), c.getNome(), c.getQtd(), (c.getPreco()*c.getQtd()));
	        	System.out.println();
	        	total = total + c.getPreco()*c.getQtd();
	        }
			
			int aviso = 0;
			double desconto = 0;
			if(total >= 1200) {
				desconto = desconto + 0.05;
				if(total >= 2500) {
					desconto = desconto + 0.05;
					if(total >= 5000) {
						desconto = desconto + 0.05;
					}
				}
				aviso = 1;
			}
			
			total = total * (1 - desconto);
			
			if(total < 10000) {
				if(desconto < 0.1) {
					if(aviso == 0) {
						System.out.println("|----------------------------------------|");
						System.out.printf( "| Total:                       R$%.2f |", total);
						System.out.println();
					} else {
						System.out.println("|----------------------------------------|");
						System.out.printf( "| Total com %.0f%% de desconto:    R$%.2f |", desconto*100, total);
						System.out.println();
					}
				} else {
					System.out.println("|----------------------------------------|");
					System.out.printf( "| Total com %.0f%% de desconto:   R$%.2f |", desconto*100, total);
					System.out.println();
				}
			} else {
				System.out.println("|----------------------------------------|");
				System.out.printf( "| Total com %.0f%% de desconto: R$%.2f  |", desconto*100, total);
				System.out.println();
			}
			
		} else {
		System.out.println(">>> Carrinho vazio.");
		}
		
	}

	// Adiciona um item ao carrinho de compras
	public void adicionar(List<Produto> estoque, List<Item> carrinho, Scanner input) {
		System.out.println("|----------------------------------------|");
		System.out.println("|##-- Função p Adicionar ao Carrinho --##|");
		System.out.println("|----------------------------------------|");
	   	System.out.print("-> Digite o código do produto: ");
	   	
		int id = input.nextInt();
		
		System.out.print("-> Digite a sua quantidade: ");
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
				System.out.println(">>> Item adicionado ao carrinho!");
			}
		}		
	}

	// Remove um item do carrinho de compras
	public void remover(List<Item> carrinho, Scanner input) {
		if(carrinho.isEmpty() == false) {
			
			
			int cont = setarIdItem(carrinho);
			id = 0;
			
			while(id == 0) { // enquanto id for maior ou menor que o contador que é 
				System.out.println("|##--- Função p Remover do Carrinho ---##|");
				System.out.println("|----------------------------------------|");
				System.out.println("| ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ |");
				
				mostrar(carrinho, input); // a quantidade de itens no carrinho, vai rodar
				
				System.out.println();
				System.out.print("-> Digite o id: ");
				id = input.nextInt();
				
				if(id > cont || id < 1 || id == 0) { // um aviso caso o id digitado não seja de nenhum item do carrinho
					System.out.println(">>> Não existe esse id. Tente novamente."); // <- o aviso
					System.out.println("\n|----------------------------------------|");
					
					id = 0;
				}
			}	
			
			System.out.print("-> Digite o quantidade: ");
			qtd = input.nextInt();
			for(Item c : carrinho) { // foreachzin padrão
				if(c.getId() == id) { // se o id do item for o mesmo que o id digitado no console, ele roda
					if(c.getQtd() <= qtd) { // se a qtd do item for menor ou igual a qtd digitada no console, ele entra aqui
						carrinho.remove(id - 1);
						System.out.println(">>> Item removido do carrinho.");
						break;
					} else { //caso a qtd do item no carrinho seja maior que a qtd digitada no console, ele entra aqui 
						c.setQtd(c.getQtd()-qtd);
						System.out.println(">>> Quantidade de itens reduzida no carrinho.");
					}
				}
			}	
		} else {
			System.out.println("Carrinho vazio.");
		}
	}

	// Finaliza o carrinho de compras
	public void finalizar(List<Item> carrinho, List<Cliente> clientela, Cliente fregues, Historico loja, Scanner input ) {
		if(carrinho.isEmpty() == false) {
			System.out.println("|----------------------------------------|");
			System.out.println("|##-- Função p Finalizar ao Carrinho --##|");
			mostrar(carrinho, input);
			int aux = 0; // pra executar o while enquanto não for respondida a pergunta
			int dia = 0, mes = 0;  
			LocalDate hoje = LocalDate.now();
			
			while(aux == 0) {
				System.out.println();
				System.out.print("-> Deseja finalizar o carrinho? [S/N] ");
				char op = input.next().charAt(0);
				
				if(op == 'N' || op == 'n' || op == 'S' || op == 's') {  // VOLTAR AO MENU ou FINALIZAR O CARRINHO
					
					
					if(op == 'S' || op == 's') {  // DE FATO FINALIZAR O CARRINHO 
						
						System.out.print("-> Digite o ID do funcionário: ");
						String idFuncionario = input.next();
						
						System.out.print("-> Digite o cpf do cliente: ");
						String cpf = input.next();
						
						int aux1 = 0; // pra executar o while enquanto não for respondida a pergunta
						
						boolean taNoClientela = false;
						
						for(Cliente c : clientela) {

							if(cpf.equals(c.getCpf())) { // quando for comparar string tem que usar essa função equals.
								taNoClientela = true;
							}
						}
						
						if(taNoClientela == false) {
							System.out.print("-> Digite o nome: ");
							input.nextLine();
							String nome = input.nextLine();
							
							
							System.out.println(">>> Ao efetuar o cadastro na loja, os descontos são maiores!");
							while(aux1 == 0) {
								
								System.out.print("-> Deseja criar um cadastro? [S/N] ");
								
								char op1 = input.next().charAt(0);
								
								if(op1 == 'N' || op1 == 'n' || op1 == 'S' || op1 == 's') {  // cadastrar ou não
									aux1 = 1;
									
									if(op1 == 'S' || op1 == 's') {  // fazer o cadastro 
										
										System.out.print("-> Digite o email: ");
										String email = input.next();
										
										System.out.print("-> Digite o cep: ");
										String cep = input.next();
										
										System.out.print("-> Digite o telefone: ");
										String telefone = input.next();
										
										System.out.print("-> Digite o ano de nascimento: ");
										int ano = input.nextInt();
										
										System.out.print("-> Digite o mês de nascimento: ");
										mes = input.nextInt();
										
										System.out.print("-> Digite o dia de nascimento: ");
										dia = input.nextInt();
										
										
										
										
										
										
										clientela.add(new Cliente(nome, cpf, email, cep, telefone, LocalDate.of(ano, mes, dia)));
										
										System.out.println(">>> Cliente cadastrado!");
										
									}
									
									if(op1 == 'N' || op1 == 'n') { // não fazer o cadastro, mas de qualquer jeito armazena dados fantasmas " "  juntamente ao cpf do cliente no clientela
										//System.out.println("Ok.");
										
										clientela.add(new Cliente(nome, cpf, "", "", "", LocalDate.of(1900, 12, 31)));
									}
									
								} else {
									System.out.println(">>> Opção inválida.");
								}
							}
						}
						
						
						List<Item> carrinhoClone = new ArrayList<Item>();
						double total = 0;
						for(Item cc : carrinho) { // clonando o carrinho atual, para podermos zerar no final do processo de finalizar
							carrinhoClone.add(cc);
							total = total + cc.getPreco()*cc.getQtd();
						}
						
						double desconto = 1;
						if(dia == hoje.getDayOfMonth() && mes == hoje.getMonthValue()) {
							desconto = desconto - 0.05;
						}
						
						if(total >= 1200) {
							desconto = desconto - 0.05;
							if(total >= 2500) {
								desconto = desconto - 0.05;
								if(total >= 5000) {
									desconto = desconto - 0.05;
								}
							}
						}
						
						total = total * desconto;
						//System.out.printf("%.2f", total);
						
						
						Pagamento tipoDePagamento = new Pagamento();
						tipoDePagamento.metodoPagamento(total, input);

						
						loja.realizarVendas(new Transacao(cpf, idFuncionario, LocalDate.now(), carrinhoClone, total));

						carrinho.clear();
					}
					if(op == 'N' || op == 'n') {
						System.out.println(">>> Voltando ao menu...");
					}
					aux = 1;
				} else {
					System.out.println(">>> Opção inválida.");
				}
			}
		} else {
			System.out.println(">>> Carrinho vazio.");
		}
	}
	
	// Seta id do Item no carrinho de compras
	private int setarIdItem(List<Item> carrinho) {
		int cont = 0;
		
		for (Item c : carrinho) {
			cont++;
			c.setId(cont); // settando o id de cada um dos produtos de forma manual, 100% atualizada igual bomba patch
		}	
		return cont; // retorna quantos produtos tem no estoque
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
