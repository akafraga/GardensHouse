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
	
	// Cria o banco de dados com o nome dos clientes que já compraram
	//public void criarClientes(List<Cliente> clientela) {
	//	clientela.add(new Cliente("Jose Ephigenio", "23535962072", "JoseEphigenio@gmail.com", "28093120", "(21) 46792-4820", LocalDate.of(1960, 12, 31)));
	//	clientela.add(new Cliente("Diego Alves Pinto", "59197370002", "DiegoAlvesPinto@teleworm.us", "28020160", "(21) 47324-2374", LocalDate.of(1971, 8, 27)));
	//	clientela.add(new Cliente("Joao Barbosa Gomes", "27382195007", "JoaoBarbosaGomes@jourrapide.com", "28027092", "(21) 58270-7156", LocalDate.of(1960, 7, 20)));
	//	clientela.add(new Cliente("Júlio Almeida Melo", "92289539007", "JulioAlmeidaMelo@dayrep.com", "28083372", "(21) 32062-2497", LocalDate.of(1958, 6, 14)));
	//	clientela.add(new Cliente("Victor Barros Martins", "02964865078", "VictorBarrosMartins@jourrapide.com", "28057345", "(21) 22560-6616", LocalDate.of(2000, 2, 27)));
		//clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		//clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		//clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		//clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		//clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		//clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		//clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
	//}
	
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

