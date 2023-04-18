package pagamento;

import java.util.Scanner;
import java.util.Random;

public class Pagamento implements iPagamento{

	private String tipo;
	
	public Pagamento() {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@SuppressWarnings("unused")
	public int metodoPagamento(double total, Scanner input) {
		
		int metodo = 0;
		Random random = new Random();
		System.out.println();
		Pagamento p = new Pagamento();
		double valorCliente = 0, restante = 0, troco = 0;
		
		int aux = 0;
		while(aux == 0) {
			System.out.println();
			System.out.println("|----------------------------------------|");
			System.out.println("|##------- Métodos de Pagamento -------##|");
			System.out.println("| Opção 1 - Dinheiro                     |");
			System.out.println("| Opção 2 - Pix                          |");
			System.out.println("| Opção 3 - Cartão de Débito             |");
			System.out.println("| Opção 4 - Cartão de Crédito            |");
			System.out.println("|----------------------------------------|");
			System.out.print("-> Opção escolhida: ");
			metodo = input.nextInt();
			
			int metodo1 = metodo;
			switch (metodo) {
			
			// 1 = Dinheiro
				case 1:
					aux = dinheiro(valorCliente, total, troco, restante, input);
					break;
				
				// 2 = Pix
				case 2:
					aux = pix(valorCliente, total, restante, input, random);
					break;
				
				// 3 = Cartao de Debito
				case 3:
					aux = debito(valorCliente, total, restante, input);
					
				// 4 = Cartao de Credito
				case 4:	
					aux = credito(valorCliente, total, restante, input);
					break;
				}
		}
		return metodo;
	}

	@Override
	public int dinheiro(double valorCliente, double total, double troco, double restante, Scanner input) {
		if(restante == 0) { // primeira vez executando o loop do while
			System.out.printf("\n>>> Valor da Compra: %.2f\n", total);
			System.out.print("-> Digite quanto recebeu do cliente: ");
			valorCliente = input.nextDouble();
			troco = valorCliente - total;
			
			if(troco == 0 ) {
				System.out.println(">>> Obrigado por comprar conosco!");
				return 1;
			} else if(troco > 0) {
				System.out.printf(">>>Troco: R$%.2f\n", troco);
				System.out.println(">>> Obrigado por comprar conosco!");
				return 1;
			} else {
				restante = total - valorCliente;
				System.out.printf(">>> Faltam R$%.2f reais.\n", restante);
				return 0;
			}
			
		} else { // enésima vez executando um pagamento
			System.out.printf("\n>>> Valor que falta: %.2f\n", restante);
			System.out.print("-> Digite quanto recebeu do cliente: ");
			valorCliente = input.nextDouble();
			troco = valorCliente - restante;

			if(troco == 0) {
				System.out.println(">>> Obrigado por comprar conosco!");
				return 1;
	
			} else if(troco > 0){
				System.out.printf("Troco: R$%.2f\n", troco);
				System.out.println(">>> Obrigado por comprar conosco!");
				return 1;
			} else {
				restante = total - valorCliente;
				System.out.printf(">>> Faltam R$%.2f reais.\n", restante);
				return 0;
			}
		}
	}

	@Override
	public int pix(double valorCliente, double total, double restante, Scanner input, Random random) {
		if (restante == 0) {// primeira vez executando o loop do while
			System.out.printf("\n>>> Valor da Compra: %.2f\n", total);
			System.out.print("-> Digite quanto recebeu do cliente: ");
			valorCliente = input.nextDouble();
			double conta = valorCliente - total;
			
			System.out.print("A chave aleatória pix é: ");
			int codigoPix = random.nextInt();
			System.out.println(codigoPix);
			
			if(conta == 0 ) {
				System.out.println(">>> Obrigado por comprar conosco!");
				return 1;
			} else {
				restante = total - valorCliente;
				System.out.printf(">>> Faltam R$%.2f reais.\n", restante);
				return 0;
			}
		} else {
			System.out.printf("\n>>> Valor que falta: %.2f\n", restante);
			System.out.print("-> Digite quanto recebeu do cliente: ");
			valorCliente = input.nextDouble();
			double conta = valorCliente - restante;
			
			System.out.print("A chave aleatória pix é: ");
			int codigoPix = random.nextInt();
			System.out.println(codigoPix);
			
			if(conta == 0) {
				System.out.println(">>> Obrigado por comprar conosco!");
				return 1;
			} else {
				restante = total - valorCliente;
				System.out.printf(">>> Faltam R$%.2f reais.\n", restante);
				return 0;
			}	
		}
	}

	@Override
	public int debito(double valorCliente, double total, double restante, Scanner input) {
		if(restante == 0) {
			System.out.printf("\n>>> Valor da Compra: %.2f\n", total);
			System.out.print("-> Digite quanto recebeu do cliente: ");
			valorCliente = input.nextDouble();
			double conta = valorCliente - total;
			
			if(conta == 0 ) {
				System.out.println(">>> Obrigado por comprar conosco!");
				return 1;
			} else {
				restante = total - valorCliente;
				System.out.printf(">>> Faltam R$%.2f reais.\n", restante);
				return 0;
			}
		} else {
			System.out.printf("\n>>> Valor que falta: %.2f\n", restante);
			System.out.print("-> Digite quanto recebeu do cliente: ");
			valorCliente = input.nextDouble();
			double conta = valorCliente - restante;
			
			if(conta == 0) {
				System.out.println(">>> Obrigado por comprar conosco!");
				return 1;
			} else {
				restante = total - valorCliente;
				System.out.printf(">>> Faltam R$%.2f reais.\n", restante);
				return 0;
			}
		}
	}

	@Override
	public int credito(double valorCliente, double total, double restante, Scanner input) {
		if(restante == 0) {
			System.out.printf("\n>>> Valor da Compra: %.2f\n", total);
			System.out.print("-> Digite quanto recebeu do cliente: ");
			valorCliente = input.nextDouble();
			double conta = valorCliente - total;
			
			if(conta == 0 ) {
				System.out.println(">>> Obrigado por comprar conosco!");
				return 1;
			} else {
				restante = total - valorCliente;
				System.out.printf(">>> Faltam R$%.2f reais.\n", restante);
				return 0;
			}
		} else {
			System.out.printf("\n>>> Valor que falta: %.2f\n", restante);
			System.out.print("-> Digite quanto recebeu do cliente: ");
			valorCliente = input.nextDouble();
			double conta = valorCliente - restante;
			
			if(conta == 0) {
				System.out.println(">>> Obrigado por comprar conosco!");
				return 1;
			} else {
				restante = total - valorCliente;
				System.out.printf(">>> Faltam R$%.2f reais.\n", restante);
				return 0;
			}
		}
	}

	
}