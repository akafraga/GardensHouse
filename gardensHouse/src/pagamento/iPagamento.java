package pagamento;

import java.util.Random;
import java.util.Scanner;

public interface iPagamento {


	void dinheiro(double valorCliente, double total, double troco, Scanner input);

	void pix(double valorCliente, double total, Scanner input, Random random);

	void debito(double valorCliente, double total, Scanner input);

	void credito(double valorCliente, double total, Scanner input);
}
