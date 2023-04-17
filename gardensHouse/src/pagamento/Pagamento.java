package pagamento;

import java.util.Scanner;
import java.util.Random;

public class Pagamento implements IPagamento{

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
		Pagamento p = new Pagamento();
		while(aux == 0) {
			System.out.println();
			System.out.println("|----------------------------------------|\n");
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
			int metodo1 = metodo;
			switch (metodo) {
			
			// 1 = Dinheiro
				case 1:
	
					if(valorCliente<total) {
						restante = total - valorCliente;
						System.out.printf("Faltam R$%.2f reais\n", restante);
						break;
					}
					
					if(troco == 0) {
						System.out.println(p.mensagem());
						
						
					} else {
						System.out.printf("Troco: R$%.2f\n", troco);
						System.out.println(p.mensagem());
					}
					aux = 1;
					break;
				
				// 2 = Pix
				case 2:

					System.out.println("A chave aleatória pix é: \n");
					int codigoPix = random.nextInt();
					System.out.println(codigoPix);
					
					if(valorCliente<total) {
						restante = total - valorCliente;
						System.out.printf("Faltam R$%.2f reais.\n", restante);
						break;
					}
					
					System.out.println(p.mensagem());
					
					aux = 1;
					break;
					
				// 3 = Cartao de Debito
				case 3:
					//System.out.print("Digite os 16 números do cartão separando-os por - :");
					//String numerosCartaoDebito = input.next();
					
					//System.out.println("Digite a senha: \n");
					//String codigoCartaoDebito = input.next();
					
					if(valorCliente<total) {
						restante = total - valorCliente;
						System.out.printf("Faltam R$%.2f reais.\n", restante);
						break;
					}

					System.out.println(p.mensagem());

					
					aux = 1;
					break;
					
				// 4 = Cartao de Credito
				case 4:
					//System.out.println("Digite os 16 números do cartão separando-os por - : \n");
					//String numerosCartaoCredito = input.next();
					
					//System.out.println("Digite a senha: \n");
					//String codigoCartaoCredito = input.next();
					
					if(valorCliente<total) {
						restante = total - valorCliente;
						System.out.printf(">>> Faltam R$%.2f reais.\n", restante);
						break;
					}
					
					System.out.println(p.mensagem());
					
					aux = 1;
					break;
				}
		}
		return metodo;
	}

	@Override
	public String mensagem() {
		return ">>> Obrigado por comprar conosco!";
	}
	
}