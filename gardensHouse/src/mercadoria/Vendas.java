package mercadoria;


import java.util.List;


public class Vendas {
	
	
	private String nome, cpfCliente, idFuncionario;
	private double preco;
	private int qtd;
	private Item carrinho;
	
	/*
	 * 	estive pensando sobre o quão útil é ter o nome, preço e quantidade no vendas.
	 * 
	 * 	acho que podemos trocar isso por um LocalDate dataDaCompra que já funcionaria.
	 * 	LocalDate dataDaCompra = new LocalDate(ANO, MÊS, DIA) <- todos eles em INT
	 * 
	 * 	ai pensei no mostrar vendas ser assim:
	 * 
	 * 	cpfCliente(ou nome do cliente) - idFuncionário(ou nome funcionário) - dataDaCompra
	 * 	-----------------------------------------------------------------------------------
	 * 	Item i = new Item();
	 * 	i.mostrar(carrinho);
	 * 	
	 */
	public Vendas(String nome, double preco, int qtd, String cpf, String id, List<Item> carrinho) {
		this.nome = nome;
		this.preco = preco;
		this.qtd = qtd;
		this.cpfCliente = cpf;
		this.idFuncionario = id;
		this.carrinho = (Item) carrinho;
	}
	
	
	public Vendas() {
		
	}
	
	
	public void criar(List<Vendas> historicoDeVendas) {
		
	}
	
	
	public void mostrar(List<Vendas> historicoVendas) {
		for (Vendas v : historicoVendas) {
	        	System.out.println("Cpf cliente: " + v.getCpfCliente() + " - Id Funcionário: "+ v.getIdFuncionario() + " - Valor compra:  " + v.getPreco()*v.getQtd());
        }		
	}
	
	//Get 
	public String getNome() {
		return nome;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}


	public String getIdFuncionario() {
		return idFuncionario;
	}

	public double getPreco() {
		return preco;
	}

	public int getQtd() {
		return qtd;
	}

	public Item getCarrinho() {
		return carrinho;
	}
}
