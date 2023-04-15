package menu;


import java.util.*;

import individuo.Cliente;
import individuo.Funcionario;
import mercadoria.Item;
import mercadoria.Produto;
import mercadoria.Vendas;


public class menuCliente {
	
	// Construtor para uso de métodos
	public menuCliente() {
	}
	
	public void menuLoja(List<Produto> estoque, List<Funcionario> colaboradores, List<Item> carrinho, 
			List<Cliente> clientela, List<Vendas> historicoDeVendas, Produto armazem, Funcionario empregado,
			Item kart, Cliente fregues, Vendas vazao, Scanner input) {
		
		armazem.criar(estoque);
		fregues.criar(clientela);
		empregado.criar(colaboradores);
		
		
		/* 
		 * um método do tipo Cliente verificando se o cliente que vai efetuar a compra está no nosso cadastro, 
		 * se não estiver tem que abrir o método adicionarCliente que vai adicioná-lo no bancoDeDados com as 
		 * informações de todos os clientes que tivemos na loja.
		 */
		
		int op = 0;
        while (op != 6) {
        	System.out.print("|##-- Bem vindo a Garden's House --##|\n");
			System.out.print("|------------------------------------|\n");
			System.out.print("| Selecione uma operação:            |\n");
			System.out.print("| Opção 1 - Adicionar ao Carrinho    |\n");
			System.out.print("| Opção 2 - Remover do Carrinho      |\n");
			System.out.print("| Opção 3 - Mostrar o Carrinho       |\n");
			System.out.print("| Opção 4 - Finalizar o Carrinho     |\n");
			System.out.print("| Opção 5 - Histórico de Vendas      |\n");
			System.out.print("| Opção 6 - Sair                     |\n");
			System.out.print("|------------------------------------|\n");

			System.out.print("Opção: ");
            op = input.nextInt();
            
            switch (op) {
                case 1:
                	kart.adicionar(estoque, carrinho, historicoDeVendas, input);
                	break;
                	
                case 2:
                	kart.remover(carrinho, historicoDeVendas, input);
                	break;
                    
                case 3:
                	kart.mostrar(carrinho, historicoDeVendas, input);
                	break;
                	
                case 4:
                	kart.finalizar(colaboradores, carrinho, clientela, historicoDeVendas, fregues, input);
                	break;
                
                case 5:
                	vazao.mostrar(historicoDeVendas, kart, input);
                	break;	
                
                case 6:
                    System.out.println("Saindo...");
                    break;
                    
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.print("\n");
        }
	}
	
}	
