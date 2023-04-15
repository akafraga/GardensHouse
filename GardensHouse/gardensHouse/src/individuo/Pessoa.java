package individuo;



public abstract class Pessoa {
	
	// Declaração de variável
	protected String nome, cpf, email, cep, telefone;
	
	// Construtor padrão
	public Pessoa(String nome, String cpf, String email, String cep, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cep = cep;
		this.telefone = telefone;
	}
	
	// Construtor para fins de uso de métodos
	public Pessoa() {
		
	}
	
	// Método comum entre as classes que herdam
	public abstract void mostrarDados();

	// Get e Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
