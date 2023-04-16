package individuo;

// Importando bibliotecas que usaremos
import java.time.LocalDate;
import java.util.List;

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

