package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import individuo.Cliente;
import individuo.Funcionario;
import mercadoria.Produto;
import mercadoria.Transacao;
import mercadoria.Historico;
import mercadoria.Item;

public class Main {

	public static void main(String[] args) {
		
		
		List<Produto> estoqueDaLoja = new ArrayList<Produto>(); // estoque da loja
		List<Funcionario> colaboradores = new ArrayList<Funcionario>(); // banco de dados com os funcionários
		List<Item> carrinhoDeCompras = new ArrayList<Item>(); // carrinho de compras atual
		List<Cliente> clientela = new ArrayList<Cliente>(); // banco de dados com os clientes que já compraram
		
		
		Produto armazem = new Produto();
		Funcionario empregado = new Funcionario();
		Item kart = new Item();
		Cliente fregues = new Cliente();
		Scanner input = new Scanner(System.in);
		Historico loja = new Historico();

		
		armazem.criar(estoqueDaLoja);
		fregues.criar(clientela);
		empregado.criar(colaboradores);
		
		
		int op = 0;
        while (op != 6) {
        	System.out.print("|##---- Bem vindo a Garden's House ----##|\n");
			System.out.print("|----------------------------------------|\n");
			System.out.print("| Selecione uma operação:                |\n");
			System.out.print("| Opção 1 - Adicionar ao Carrinho        |\n");
			System.out.print("| Opção 2 - Remover do Carrinho          |\n");
			System.out.print("| Opção 3 - Mostrar o Carrinho           |\n");
			System.out.print("| Opção 4 - Finalizar o Carrinho         |\n");
			System.out.print("| Opção 5 - Menu Avançado                |\n");
			System.out.print("| Opção 6 - Sair                         |\n");
			System.out.print("|----------------------------------------|\n");

			System.out.print("-> Opção escolhida: ");
            op = input.nextInt();
            System.out.println("\n");
            switch (op) {
                case 1:
                	kart.adicionar(estoqueDaLoja, carrinhoDeCompras, input);
                	break;
                	
                case 2:
                	kart.remover(carrinhoDeCompras, input);
                	break;
                    
                case 3:
                	kart.mostrar(carrinhoDeCompras, input);
                	break;
                	
                case 4:
                	kart.finalizar(carrinhoDeCompras, clientela, fregues, loja, input);
                	break;
                
                case 5: // menuAvançado - exibirVendas, mostrarClientela, mostrarEstoque
                	
                	menuAvancado(loja, input);
                	break;
                
                case 6:
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.print("\n\n");
        }
	}
	
	
	public static void menuAvancado(Historico loja, Scanner input) {
		int op = 0;
		System.out.println();
		while (op != 7) {
			System.out.print("|##-- Menu avançado da Garden's House --##|\n");
			System.out.print("|-----------------------------------------|\n");
			System.out.print("| Selecione uma operação:                 |\n");
			System.out.print("| Opção 1 - Ver o Estoque de produtos     |\n");
			System.out.print("| Opção 2 - Adicionar produto do Estoque  |\n");
			System.out.print("| Opção 3 - Remover produto do Estoque    |\n");
			System.out.print("| Opção 4 - Ver histórico de vendas       |\n");
			System.out.print("| Opção 5 - Ver lista de clientes         |\n");
			System.out.print("| Opção 6 - Ver lista de funcionários     |\n");
			System.out.print("| Opção 7 - Sair                          |\n");
			System.out.print("|-----------------------------------------|\n");
			
			System.out.print("-> Opção escolhida: ");
            op = input.nextInt();
			
			switch (op) {
				case 1: // ver estoque
					System.out.println("Não está funcionando ainda.");
					break;
				
				case 2: // adicionar produto ao estoque
					System.out.println("Não está funcionando ainda.");
					break;
				
				case 3: // remover produto do estoque
					System.out.println("Não está funcionando ainda.");
					break;
					
				case 4: // ver o historico de vendas
					for (Transacao t : loja.getHistoricoDeVendas()) {
			            System.out.println("CPF do cliente: " + t.getCpfCliente());
			            System.out.println("ID do funcionário: " + t.getIdFuncionario());
			            System.out.println("Data da compra: " + t.getDataDaCompra());
			            System.out.println("Carrinho de compras:");
			            double total = 0;
			            for (Item i : t.getCarrinho()) {
			                //System.out.println("- " + i.getNome() + " - R$" + i.getPreco());
			                System.out.printf("- %s - R$ %.2f\n", i.getNome(), i.getPreco());
			                total = total + i.getPreco();
			            }
			            if(total == t.getTotal()) {
			            	//System.out.println("Total da compra: R$" + t.getTotal());
			            	System.out.printf("Total da compra: R$ %.2f\n", t.getTotal());
			            } else {
			            	//System.out.println("Total da compra com desconto: R$" + t.getTotal());
			            	System.out.printf("Total da compra com desconto: R$ %.2f\n", t.getTotal());
			            }
			            System.out.println();
			        }
					break;
			
				case 5: // ver a lista de clientes da loja
					System.out.println("Não está funcionando ainda.");
					break;
					
				case 6: // ver a lista de funcionarios
					System.out.println("Não está funcionando ainda.");
					break;
					
				case 7:
					System.out.println("Saindo...");
					break;
					
				default:
					System.out.println("Opção inválida.");
                    break;
			}
		}
	}

}