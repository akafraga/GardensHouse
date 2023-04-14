package mercadoria;

// Importando bibliotecas que usaremos
import java.util.List;
import java.util.Scanner;

// A classe que vai abrigar todos os produtos que existem na loja
public class Produto {
	
	// Declaração de variável
	private String nome, descricao;
	private double preco;
	private int id;
		
		
	// Construtor padrão
	public Produto(int id, String nome, String descricao, double preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
		
	// Construtor para uso de métodos
	public Produto() {
		
	}
	
	// Mostra os produtos em estoque
	public void mostrar(List<Produto> estoque) {
		if(estoque.isEmpty() == false) {
			for (Produto e : estoque) {
	        	System.out.println(e.getId() + " - Produto: " + e.getNome() + " --- Descrição: " + e.getDescricao() + " --- Preço: " + e.getPreco());
	        }
		} else {
			System.out.println("Produto vazio.");
		}
	}	
	
	// Adiciona um produto ao estoque
	public void adicionar(List<Produto> estoque) { // não ta feita ainda.
		
	}
	
	// Remove um produto do estoque
	public void remover(List<Produto> estoque, Scanner input) { // prototipo dela, mas não ta feita ainda.
		System.out.print("\nDigite o código: ");
		int id = input.nextInt();
		for (Produto e : estoque) {
			if (e.getId() == id) {
				estoque.remove(id - 1);
				System.out.println("Item removido do estoque!\n\n");
			}
		}
	}
	
	// Exclui o estoque
	public void excluir(List<Produto> estoque) {
		estoque.clear();
	}	
	
	// Cria o estoque
	public void criar(List<Produto> estoque) {
		estoque.add(new Produto(1, "Guitarra", "Stratocaster vermelha", 1200));
		estoque.add(new Produto(2, "Bateria", "Bateria com 4 pratos e 2 pedais",  3500));
		estoque.add(new Produto(3, "Teclado", "Clássico elétrico preto",  1500));
		estoque.add(new Produto(4, "Piano", "De calda preto", 1200));
		estoque.add(new Produto(5, "Amplificador", "Meteoro 100w",  3500));
		estoque.add(new Produto(6, "Banco bateria", "Simples 3 alturas",  1500));
		estoque.add(new Produto(7, "Monitores de Audio", "EDIFIER", 1200));
		estoque.add(new Produto(8, "Microfone Condensador", "Behringer",  3500));
		estoque.add(new Produto(9, "Baixo", "Jazz Bazz Fender",  1500));
		estoque.add(new Produto(10, "Guitarra 7 Cordas", "Ibanez 7 cordas preta", 1200));
		estoque.add(new Produto(11, "Vionlino", "Arco de madeira e 4 cordas",  3500));
		estoque.add(new Produto(12, "Baixolão", "4 Cordas acústico",  1500));  
	}

	// Get e Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
}
