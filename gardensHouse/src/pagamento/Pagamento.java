package pagamento;

import java.util.Scanner;
import java.util.Random;

public class Pagamento {
	/*
	 * acredito que nessa classe pagamento devemos colocar todos os
	 * tipos de pagamento, criando métodos específicos pra cada um.
	 * 
	 * 1. Cartão		inserir dados do cartão
	 * 1.1. de Crédito	e finalizar a compra
	 * 1.2. de Débito	
	 * 2. Pix			gerar código aleatório de pix de preferência funcional
	 * 3. Dinheiro		perguntar valor pago e retornar quanto de troco temos que dar.
	 */
	
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
		int aux = 0;
		while(aux == 0) {
			System.out.println();
			System.out.println("|##------- Métodos de Pagamento -------##|");
			System.out.println("| Opção 1 - Dinheiro                     |");
			System.out.println("| Opção 2 - Pix                          |");
			System.out.println("| Opção 3 - Cartão de Débito             |");
			System.out.println("| Opção 4 - Cartão de Crédito            |");
			System.out.println("|----------------------------------------|");
			System.out.print("-> Opção escolhida: ");
			metodo = input.nextInt();
			System.out.printf("Valor da Compra: %.2f\n", total);
			System.out.print("Digite quanto recebeu do cliente: ");
			double valorCliente = input.nextDouble();
			double troco = valorCliente - total;
			double restante = 0;
			switch (metodo) {
			
			// 1 = Dinheiro
				case 1:
	
					if(valorCliente<total) {
						restante = total - valorCliente;
						System.out.printf("Faltam %.2f reais\n", restante);
						break;
					}
					if(troco == 0) {
						System.out.println("Obrigado!");
					} else {
						System.out.printf("Troco: %.2f\n", troco);
						System.out.println("Obrigado!");
					}
					aux = 1;
					break;
				
				// 2 = Pix
				case 2:
					if(valorCliente<total) {
						restante = total - valorCliente;
						System.out.printf("Faltam %.2f reais.\n", restante);
						break;
					}
					
					System.out.println("A chave aleatória pix é: \n");
					int codigoPix = random.nextInt();
					System.out.println(codigoPix);
					
					System.out.println("Obrigado!");
					aux = 1;
					break;
					
				// 3 = Cartao de Debito
				case 3:
					System.out.println("Digite os 16 números do cartão separando-os por - : \n");
					String numerosCartaoDebito = input.next();
					
					System.out.println("Digite a senha: \n");
					String codigoCartaoDebito = input.next();
					
					if(valorCliente<total) {
						restante = total - valorCliente;
						System.out.printf("Faltam %.2f reais.\n", restante);
						break;
					}
					
					System.out.println("Obrigado!");
					
					aux = 1;
					break;
					
				// 4 = Cartao de Credito
				case 4:
					System.out.println("Digite os 16 números do cartão separando-os por - : \n");
					String numerosCartaoCredito = input.next();
					
					System.out.println("Digite a senha: \n");
					String codigoCartaoCredito = input.next();
					
					if(valorCliente<total) {
						restante = total - valorCliente;
						System.out.printf("Faltam %.2f reais.\n", restante);
						break;
					}
					
					System.out.println("Obrigado!");
					
					aux = 1;
					break;
				}
		}
		return metodo;
	}
	
}