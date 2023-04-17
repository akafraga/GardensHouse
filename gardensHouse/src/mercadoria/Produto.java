package mercadoria;

// Importando bibliotecas que usaremos
import java.util.List;
import java.util.Scanner;

// A classe que vai abrigar todos os produtos que existem na loja
public class Produto {
	
	// Declaração de variável
	private String nome, descricao, tipo;
	private double preco;
	private int id;
		
		
	// Construtor padrão
	public Produto(String tipo, String nome, String descricao, double preco) {
		this.tipo = tipo;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
		
	// Construtor para uso de métodos
	public Produto() {
		
	}
	
	// Mostra os produtos em estoque
	public void mostrar(List<Produto> estoque) {
		setarIdProduto(estoque);
		if(estoque.isEmpty() == false) {
			System.out.println();
			System.out.println("|-----------------------------------------|");
			System.out.println("|##--             Estoque             --##|");
			System.out.println("|-----------------------------------------|");
			String aux = null;
			for (Produto e : estoque) {
	        	
				if(e.getTipo().equals(aux)) {
					
				} else {
					System.out.printf("\n>>> %s", e.getTipo());
					System.out.println();
				}
				
	        	
	        	
				System.out.printf("| %d - %s -- %s --- %.2f", e.getId(), e.getNome(), e.getDescricao(), e.getPreco());
				System.out.println();
				
				aux = e.getTipo();
			}
		} else {
			System.out.println(">>> Produto vazio.");
		}
	}	
	
	// Adiciona um produto ao estoque
	public void adicionar(List<Produto> estoque, Scanner input) { // não ta feita ainda.
		System.out.println("|----------------------------------------|");
		System.out.println("|##-- Função p Adicionar ao Estoque  --##|");
		System.out.println("|----------------------------------------|");
		input.nextLine();
		
	   	System.out.print("-> Digite o nome do produto: ");
		String nome = input.nextLine();
		System.out.println(">>> Tipos: Instrumento, Acessório e CD/Vinil");
		System.out.print("-> Digite o tipo do produto: ");
		String tipo = input.nextLine();
		System.out.print("-> Digite uma descrição do produto: ");
		String descricao = input.nextLine();
		System.out.print("-> Digite o preço do produto: ");
		double preco = input.nextDouble();
		estoque.add(new Produto(tipo, nome, descricao, preco));
		setarIdProduto(estoque);
	}
	
	// Remove um produto do estoque
	public void remover(List<Produto> estoque, Scanner input) { // prototipo dela, mas não ta feita ainda.
		mostrar(estoque);
		System.out.print("-> Digite o código: ");
		int id = input.nextInt();
		for (Produto e : estoque) {
			if (e.getId() == id) {
				estoque.remove(id - 1);
				System.out.println(">>> Item removido do estoque!\n\n");
			}
		}
		//setarIdProduto(estoque);
	}
	
	// Exclui o estoque
	public void excluir(List<Produto> estoque) {
		estoque.clear();
	}	
	
	// Cria o estoque
	public void criar(List<Produto> estoque) {
		estoque.add(new Produto("Instrumento", "Guitarra Les Paul", "Cor: Cherry Sunburst, Ano: 2015", 6999.99));
		estoque.add(new Produto("Instrumento", "Guitarra Fender Stratocaster", "Cor: Preto, Ano: 2020", 5499.99));
		estoque.add(new Produto("Instrumento", "Baixo Fender Precision", "Cor: Natural, Ano: 2018", 4499.99));
		estoque.add(new Produto("Instrumento", "Violão Taylor Grand Auditorium", "Cor: Natural, Ano: 2019", 5999.99));
		estoque.add(new Produto("Instrumento", "Bateria Ludwig Classic Maple", "Cor: White Marine Pearl, Ano: 2021", 8999.99));
		estoque.add(new Produto("Instrumento", "Teclado Korg Kronos", "Modelo: 88 Teclas, Ano: 2022", 12999.99));
		estoque.add(new Produto("Instrumento", "Saxofone Yamaha YAS-62", "Modelo: Alto, Ano: 2020", 6499.99));
		estoque.add(new Produto("Instrumento", "Trompete Bach Stradivarius", "Modelo: Sib, Ano: 2019", 5499.99));
		estoque.add(new Produto("Instrumento", "Acordeon Scandalli Super VI", "Modelo: 120 baixos, Ano: 2017", 8999.99));
		estoque.add(new Produto("Instrumento", "Piano de Cauda Steinway & Sons", "Modelo: D-274, Ano: 2021", 199999.99));
		estoque.add(new Produto("Instrumento", "Guitarra Les Paul", "Cor: Sunburst, Ano: 2019", 7999.99));
        estoque.add(new Produto("Instrumento", "Baixo Fender Precision", "Cor: Azul, Ano: 2020", 6999.99));
        estoque.add(new Produto("Instrumento", "Bateria Acústica Gretsch Catalina Maple", "Cor: Vermelha, Configuração: 5 peças", 6999.99));
        estoque.add(new Produto("Instrumento", "Teclado Roland JUNO-DS61", "Cor: Preto, Número de teclas: 61", 5999.99));
        estoque.add(new Produto("Instrumento", "Violão Takamine GD93CE-NAT", "Cor: Natural, Elétrico: Sim", 2999.99));
        estoque.add(new Produto("Instrumento", "Bateria Eletrônica Roland TD-17KVX", "Cor: Preto, Número de pads: 5", 14999.99));
        estoque.add(new Produto("Instrumento", "Saxofone Tenor Yanagisawa T-WO2", "Cor: Prata, Material: Bronze", 12999.99));
        estoque.add(new Produto("Instrumento", "Acordeon Roland FR-4x", "Cor: Preto, Baixos: 120", 9799.99));
        estoque.add(new Produto("Instrumento", "Violoncelo Michael VCM-401 4/4", "Cor: Natural, Material: Maple", 1999.99));
        estoque.add(new Produto("Instrumento", "Bateria Eletrônica Alesis Turbo Mesh Kit", "Cor: Preto, Número de pads: 7", 4199.99));
		
		estoque.add(new Produto("Acessório de instrumento", "Cabo para guitarra Fender", "Modelo: Performance Series, 3 metros", 299.99));
		estoque.add(new Produto("Acessório de instrumento", "Pedal de efeito Boss RC-30", "Looper Station, 2 pistas estéreo", 799.99));
		estoque.add(new Produto("Acessório de instrumento", "Correia para guitarra Ernie Ball", "Modelo: Polypro, Cor: Preta", 69.99));
		estoque.add(new Produto("Acessório de instrumento", "Capa para guitarra Fender", "Modelo: Deluxe Molded, Cor: Preta", 399.99));
		estoque.add(new Produto("Acessório de instrumento", "Afinador digital Korg", "Modelo: CA-2, Cromático", 89.99));
		estoque.add(new Produto("Acessório de instrumento", "Pedal de Wah-Wah Dunlop Cry Baby", "Modelo: GCB95, Cor: Preto", 499.99));
		estoque.add(new Produto("Acessório de instrumento", "Palhetas para guitarra Dunlop", "Modelo: Tortex, Espessura: 0.73mm, Pacote com 12 unidades", 39.99));
		estoque.add(new Produto("Acessório de instrumento", "Encordoamento D'Addario EXL110", "Para: Guitarra, Espessura: .010-.046", 49.99));
        estoque.add(new Produto("Acessório de instrumento", "Encordoamento Ernie Ball 2221", "Para: Guitarra, Espessura: .010-.046", 44.99));
        estoque.add(new Produto("Acessório de instrumento", "Palheta Dunlop Tortex 0.73 mm", "Material: Tortex, Pacote com 12 unidades", 29.99));
        estoque.add(new Produto("Acessório de instrumento", "Palheta Fender Classic Celluloid 351", "Material: Celulóide, Espessura: Média, Pacote com 12 unidades", 19.99));
        estoque.add(new Produto("Acessório de instrumento", "Correia Basso Premium em Couro", "Material: Couro, Cor: Marrom", 119.99));
        estoque.add(new Produto("Acessório de instrumento", "Correia Ibox em Nylon", "Material: Nylon, Cor: Preto", 34.99));
        estoque.add(new Produto("Acessório de instrumento", "Cabo P10-P10 3m", "Cabo para guitarra com ponta P10", 59.99));
        estoque.add(new Produto("Acessório de instrumento", "Encordoamento para baixo", "Encordoamento para baixo de 4 cordas", 79.99));
        
        estoque.add(new Produto("CD/Vinil", "AC/DC - Back in Black", "CD Remasterizado do álbum de 1980", 29.99));
        estoque.add(new Produto("CD/Vinil", "Guns N' Roses - Appetite for Destruction", "CD Remasterizado do álbum de 1987", 39.99));
        estoque.add(new Produto("CD/Vinil", "Metallica - Master of Puppets", "CD Remasterizado do álbum de 1986", 49.99));
        estoque.add(new Produto("CD/Vinil", "Pink Floyd - The Wall", "LP duplo do álbum de 1979", 99.99));
        estoque.add(new Produto("CD/Vinil", "Led Zeppelin - IV", "LP do álbum de 1971", 89.99));
        estoque.add(new Produto("CD/Vinil", "The Who - Who's Next", "LP do álbum de 1971", 79.99));
        estoque.add(new Produto("CD/Vinil", "Jimi Hendrix - Are You Experienced", "LP do álbum de 1967", 69.99));
        estoque.add(new Produto("CD/Vinil", "The Rolling Stones - Sticky Fingers", "LP do álbum de 1971", 89.99));
        estoque.add(new Produto("CD/Vinil", "Black Sabbath - Paranoid", "LP do álbum de 1970", 79.99));
        estoque.add(new Produto("CD/Vinil", "Deep Purple - Machine Head", "LP do álbum de 1972", 89.99));
        estoque.add(new Produto("CD/Vinil", "Queen - A Night at the Opera", "LP do álbum de 1975", 99.99));
        estoque.add(new Produto("CD/Vinil", "Van Halen - 1984", "LP do álbum de 1984", 69.99));
        estoque.add(new Produto("CD/Vinil", "Rush - Moving Pictures", "LP do álbum de 1981", 79.99));
        estoque.add(new Produto("CD/Vinil", "Scorpions - Blackout", "LP do álbum de 1982", 59.99));
        estoque.add(new Produto("CD/Vinil", "Iron Maiden - The Number of the Beast", "LP do álbum de 1982", 89.99));

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
