package individuo;

// Importando uma biblioteca
import java.util.List;

// Essa classe herda tudo da classe Pessoa e adiciona um ID
public class Funcionario extends Pessoa {

	// Declaração de variável
	private int id;
	
	// Construtor padrão
	public Funcionario(int id, String nome, String cpf, String email, String cep, String telefone) {
		super(nome, cpf, email, cep, telefone);
		this.id = id;
	}
	
	// Construtor para fins de uso de métodos
	public Funcionario() {
		
	}
	
	@Override // Reescreve o mostrarDados da classe mãe
	public void mostrarDados() {
		System.out.println("|-----------------------------------------|");
		System.out.println("| ID: " + this.id);
		System.out.println("| Nome: " + this.getNome());
	    System.out.println("| CPF: " + this.getCpf());
	    System.out.println("| Email: " + this.getEmail());
	    System.out.println("| Endereço: " + this.getCep());
	    System.out.println("| Telefone: " + this.getTelefone());
	    System.out.println("|-----------------------------------------|\n");
	}
	
	// Cria o banco de dados com o nome dos funcionários
	public void criar(List<Funcionario> colaboradores) {        
        colaboradores.add(new Funcionario(0, "Gabriel Silveira", "11111111111", "", "", ""));
        colaboradores.add(new Funcionario(1, "Gabriel Fraga", "11111111112", "", "", ""));
        colaboradores.add(new Funcionario(2, "Livia Pessanha", "11111111113", "", "", ""));
        colaboradores.add(new Funcionario(3, "Maria Antonia", "11111111114", "", "", ""));
        colaboradores.add(new Funcionario(4, "Luan Saramago", "11111111115", "", "", ""));
	}
	
	// Get e Set
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}
