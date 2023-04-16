package individuo;

// Importando bibliotecas que usaremos
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

// Essa classe herda tudo da classe Pessoa e adiciona uma data de nascimento
public class Cliente extends Pessoa{

	// Declaração de variável
	private LocalDate dataDeNascimento;
	
	// Construtor padrão
	public Cliente(String nome, String cpf, String email, String cep, String telefone, LocalDate dataDeNascimento) {
		super(nome, cpf, email, cep, telefone);
		this.dataDeNascimento = dataDeNascimento;
	}
	
	// Construtor para uso de métodos
	public Cliente() {
		
	}
	
	@Override // // Reescreve o mostrarDados da classe mãe
	public void mostrarDados() {
		System.out.println(	"Nome -------- " + nome +
							"CEP --------- " + cep +
							"CPF --------- " + cpf +
							"Telefone ---- " + telefone +
							"Nascimento -- " + dataDeNascimento);
	}
	
	public void testeCadastro(List<Cliente> clientela, Scanner input, String cpf) {
		boolean taNoClientela = false;
		
		for(Cliente c1 : clientela) {

			if(cpf.equals(c1.getCpf())) { // quando for comparar string tem que usar essa função equals.
				taNoClientela = true;
			}
		}
		
		if(taNoClientela == false) {
			System.out.print("Digite o nome completo: ");
			input.nextLine();
			String nome = input.nextLine();
			
			int aux = 0; // pra executar o while enquanto não for respondida a pergunta
			System.out.println("Ao efetuar o cadastro na loja, os descontos são maiores!");
			while(aux == 0) {
				System.out.print("Deseja criar um cadastro? [S/N] ");
				
				char op = input.next().charAt(0);
				
				if(op == 'N' || op == 'n' || op == 'S' || op == 's') {  // cadastrar ou não
					aux = 1;
					
					if(op == 'S' || op == 's') {  // fazer o cadastro 
						
						System.out.print("Digite o email: ");
						String email = input.next();
						
						System.out.print("Digite o cep: ");
						String cep = input.next();
						
						System.out.print("Digite o telefone: ");
						String telefone = input.next();
						
						System.out.print("Digite o dia de nascimento: ");
						int dia = input.nextInt();
						
						System.out.print("Digite o mês de nascimento: ");
						int mes = input.nextInt();
						
						System.out.print("Digite o ano de nascimento: ");
						int ano = input.nextInt();
						
						clientela.add(new Cliente(nome, cpf, email, cep, telefone, LocalDate.of(ano, mes, dia)));
					}
					
					if(op == 'N' || op == 'n') { // não fazer o cadastro, mas de qualquer jeito armazena dados fantasmas " "  juntamente ao cpf do cliente no clientela
						System.out.println("Ok.");
						clientela.add(new Cliente(nome, cpf, "", "", "", LocalDate.of(1900, 12, 31)));
					}
					
				} else {
					System.out.println("Opção inválida.");
				}
			}
		}
	}
	
	
	// Testa se no dia da compra é aniversário do cliente
	public boolean testeAniversario() {
		LocalDate hoje = LocalDate.now();
		return (hoje.getMonth() == dataDeNascimento.getMonth() && hoje.getDayOfMonth() == dataDeNascimento.getDayOfMonth());	
		// TRUE = é aniversário - FALSE = não é aniversário
	}
	
	// Get e Set
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public void criar(List<Cliente> clientela) {
		// TODO Auto-generated method stub
		
	}
}

