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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	public void realizarPagamento(int scanOp, Scanner input) {
		
		Random random = new Random();


		switch (scanOp) {
		// 1 = cartao credito
		case 1:
			System.out.println("Digite os 16 números do cartão separando-os por - : \n");
			String numerosCartaoCredito = input.next();
			
			System.out.println("Digite a validade: \n");	
			String validadeCartaoCredito = input.next();
			
			System.out.println("Digite o código de segurança: \n");
			String codigoCartaoCredito = input.next();
			
			break;
		
		// 2 = cartao debito
		case 2:
			System.out.println("Digite os 16 números do cartão separando-os por - : \n");
			String numerosCartaoDebito = input.next();
			
			System.out.println("Digite a validade: \n");	
			String validadeCartaoDebito = input.next();
			
			System.out.println("Digite o código de segurança: \n");
			String codigoCartaoDebito = input.next();
			
			break;
			
		// 3 = pix
		case 3:
			System.out.println("Sua chave aleatória pix é: \n");
			int codigoPix = random.nextInt();
			System.out.println(codigoPix);
			
			break;
			
		// 4 = dinheiro	
		case 4:
			System.out.println("Digite o valor: \n" );
			double valorCompra = input.nextDouble();
			System.out.println("Digite quanto recebeu do cliente: \n");
			double valorCliente = input.nextDouble();
			double troco = valorCliente - valorCompra;
			System.out.println("Você deve dar R$" + troco + " de troco ao cliente.");
			break;
			
			
		}
	
	
	}
}