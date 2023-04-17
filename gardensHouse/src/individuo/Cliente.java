package individuo;

// Importando bibliotecas que usaremos
import java.time.LocalDate;

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
		System.out.println("|-----------------------------------------|");
		System.out.println("| Nome: " + this.getNome());
	    System.out.println("| CPF: " + this.getCpf());
	    System.out.println("| Data de nascimento: " + this.getDataDeNascimento().getDayOfMonth() + "/" + this.getDataDeNascimento().getMonthValue() + "/" + this.getDataDeNascimento().getYear());
	    System.out.println("| Email: " + this.getEmail());
	    System.out.println("| Endereço: " + this.getCep());
	    System.out.println("| Telefone: " + this.getTelefone());
	    System.out.println("|-----------------------------------------|\n");
	}
	
	
	// Get e Set
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}

