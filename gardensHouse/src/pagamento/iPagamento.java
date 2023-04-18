package pagamento;

import java.util.Random;
import java.util.Scanner;

public interface iPagamento {

	int dinheiro(double valorCliente, double total, double troco, double restante, Scanner input);

	int pix(double valorCliente, double total, double restante, Scanner input, Random random);

	int debito(double valorCliente, double total, double restante, Scanner input);

	int credito(double valorCliente, double total, double restante, Scanner input);
}
