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
		double valorCliente = 0, troco = 0;
		

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
		switch (metodo) {
			
		// 1 = Dinheiro
			case 1:
				dinheiro(valorCliente, total, troco, input);
				break;
				
			// 2 = Pix
			case 2:
				pix(valorCliente, total, input, random);
				break;
				
			// 3 = Cartao de Debito
			case 3:
				debito(valorCliente, total, input);
				break;
					
			// 4 = Cartao de Credito
			case 4:	
				credito(valorCliente, total, input);
				break;
		}
		return metodo;
	}

	@Override
	public void dinheiro(double valorCliente, double total, double troco, Scanner input) {
		System.out.printf("\n>>> Valor da Compra: %.2f\n", total);
		System.out.print("-> Digite quanto recebeu do cliente: ");
		valorCliente = input.nextDouble();
		troco = valorCliente - total;
		
		if(troco == 0 ) {
			System.out.println(">>> Obrigado por comprar conosco!");
		} else if (troco > 0) {
			System.out.printf(">>>Troco: R$%.2f\n", troco);
			System.out.println(">>> Obrigado por comprar conosco!");
		}	

	}

	@Override
	public void pix(double valorCliente, double total, Scanner input, Random random) {
		System.out.printf("\n>>> Valor da Compra: %.2f\n", total);
		System.out.print("-> Digite quanto recebeu do cliente: ");
		valorCliente = input.nextDouble();
		double conta = valorCliente - total;
			
		System.out.print("A chave aleatória pix é: ");
		int codigoPix = random.nextInt();
		System.out.println(codigoPix);
			
		if(conta == 0 ) {
			System.out.println(">>> Obrigado por comprar conosco!");
		} 
	
	}

	@Override
	public void debito(double valorCliente, double total, Scanner input) {

		System.out.printf("\n>>> Valor da Compra: %.2f\n", total);
		System.out.print("-> Digite quanto recebeu do cliente: ");
		valorCliente = input.nextDouble();
		double conta = valorCliente - total;
		
		if(conta == 0 ) {
			System.out.println(">>> Obrigado por comprar conosco!");
		}
	}

	@Override
	public void credito(double valorCliente, double total, Scanner input) {
		System.out.printf("\n>>> Valor da Compra: %.2f\n", total);
		System.out.print("-> Digite quanto recebeu do cliente: ");
		valorCliente = input.nextDouble();
		double conta = valorCliente - total;
			
		if(conta == 0 ) {
			System.out.println(">>> Obrigado por comprar conosco!");
		}
	}

	
}