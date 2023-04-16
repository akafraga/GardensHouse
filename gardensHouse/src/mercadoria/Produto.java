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
	public Produto(String nome, String descricao, double preco) {
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
		estoque.add(new Produto("Guitarra", "Stratocaster vermelha", 1200));
		estoque.add(new Produto("Bateria", "Bateria com 4 pratos e 2 pedais",  3500));
		estoque.add(new Produto("Teclado", "Clássico elétrico preto",  1500));
		estoque.add(new Produto("Piano", "De calda preto", 1200));
		estoque.add(new Produto("Amplificador", "Meteoro 100w",  3500));
		estoque.add(new Produto("Banco bateria", "Simples 3 alturas",  1500));
		estoque.add(new Produto("Monitores de Audio", "EDIFIER", 1200));
		estoque.add(new Produto("Microfone Condensador", "Behringer",  3500));
		estoque.add(new Produto("Baixo", "Jazz Bazz Fender",  1500));
		estoque.add(new Produto( "Guitarra 7 Cordas", "Ibanez 7 cordas preta", 1200));
		estoque.add(new Produto( "Vionlino", "Arco de madeira e 4 cordas",  3500));
		estoque.add(new Produto("Baixolão", "4 Cordas acústico",  1500));  
		setarIdProduto(estoque);
	}
	
	private void setarIdProduto(List<Produto> estoque) {
		int cont = 0;
		for (Produto p : estoque) {
			cont++;
			p.setId(cont); // settando o id de cada um dos produtos de forma manual, 100% atualizada igual bomba patch
		}		
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
