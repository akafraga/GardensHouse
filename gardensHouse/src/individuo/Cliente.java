package individuo;

// Importando bibliotecas que usaremos
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import mercadoria.Vendas;


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
			if(cpf == c1.getCpf()) {
				taNoClientela = true;
			}
		}
		
		System.out.print("Digite o nome completo: ");
		String nome = input.next();
		
		if(taNoClientela == false) {
			int aux = 0; // pra executar o while enquanto não for respondida a pergunta
			System.out.println("Ao efetuar o cadastro na loja, os desconstos são maiores!");
			while(aux == 0) {
				System.out.println("Deseja criar um cadastro? [S/N] ");
				
				char op = input.next().charAt(0);
				
				if(op == 'N' || op == 'n' || op == 'S' || op == 's') {  // cadastrar ou não
					
					
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
					aux = 1;
				} else {
					System.out.println("Opção inválida.");
				}
			}
		}
	}
	
	/*
	// Cria o banco de dados com o nome dos clientes que já compraram
	public void criarClientes(List<Cliente> clientela) {
		clientela.add(new Cliente("Jose Ephigenio", "23535962072", "JoseEphigenio@gmail.com", "28093120", "(21) 46792-4820", LocalDate.of(1960, 12, 31)));
		clientela.add(new Cliente("Diego Alves Pinto", "59197370002", "DiegoAlvesPinto@teleworm.us", "28020160", "(21) 47324-2374", LocalDate.of(1971, 8, 27)));
		clientela.add(new Cliente("Joao Barbosa Gomes", "27382195007", "JoaoBarbosaGomes@jourrapide.com", "28027092", "(21) 58270-7156", LocalDate.of(1960, 7, 20)));
		clientela.add(new Cliente("Júlio Almeida Melo", "92289539007", "JulioAlmeidaMelo@dayrep.com", "28083372", "(21) 32062-2497", LocalDate.of(1958, 6, 14)));
		clientela.add(new Cliente("Victor Barros Martins", "02964865078", "VictorBarrosMartins@jourrapide.com", "28057345", "(21) 22560-6616", LocalDate.of(2000, 2, 27)));
		clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
		clientela.add(new Cliente("", "", "", "", "", LocalDate.of(0, 0, 0)));
	}
	*/
	
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

