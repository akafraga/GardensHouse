package individuo;

// Importando uma biblioteca
import java.util.List;

// Essa classe herda tudo da classe Pessoa e adiciona um ID
public class Funcionario extends Pessoa {

	// Declaração de variável
	private String id;
	
	// Construtor padrão
	public Funcionario(String id, String nome, String cpf, String email, String endereco, String telefone) {
		super(nome, cpf, email, endereco, telefone);
		this.id = id;
	}
	
	// Construtor para fins de uso de métodos
	public Funcionario() {
		
	}
	
	@Override // Reescreve o mostrarDados da classe mãe
	public void mostrarDados() {
		System.out.println(	"ID Funcionário -- " + id +
							"Nome -------- " + nome +
							"Telefone ---- " + telefone);
	}
	
	// Cria o banco de dados com o nome dos funcionários
	public void criarFuncionarios(List<Funcionario> colaboradores) {        
        colaboradores.add(new Funcionario("0", "Gabriel Silveira", "11111111111", "", "", ""));
        colaboradores.add(new Funcionario("1", "Gabriel Fraga", "11111111112", "", "", ""));
        colaboradores.add(new Funcionario("2", "Livia Pessanha", "11111111113", "", "", ""));
        colaboradores.add(new Funcionario("3", "Maria Antonia", "11111111114", "", "", ""));
        colaboradores.add(new Funcionario("4", "Luan Saramago", "11111111115", "", "", ""));
	}
	
	// Get e Set
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void criar(List<Funcionario> colaboradores) {
		// TODO Auto-generated method stub
		
	}
}
