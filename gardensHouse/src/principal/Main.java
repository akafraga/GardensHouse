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
                
                case 5:
                	exibirVendas(loja);
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
	
	
	public static void exibirVendas(Historico loja) {
		for (Transacao t : loja.getHistoricoDeVendas()) {
            System.out.println("CPF do cliente: " + t.getCpfCliente());
            System.out.println("ID do funcionário: " + t.getIdFuncionario());
            System.out.println("Data da compra: " + t.getDataDaCompra());
            System.out.println("Carrinho de compras:");
            for (Item i : t.getCarrinho()) {
                System.out.println("- " + i.getNome() + " - R$" + i.getPreco());
            }
            System.out.println("Total da compra: R$" + getTotalDaVenda(t));
            System.out.println();
        }
	}
	
    private static double getTotalDaVenda(Transacao venda) {
        List<Item> carrinho = venda.getCarrinho();
        double total = 0;
        for (Item i : carrinho) {
            total += i.getPreco();
        }
        return total;
    }

}