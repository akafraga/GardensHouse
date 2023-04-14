package mercadoria;


import java.util.ArrayList;
import java.util.List;


public class Vendas {
	
	
	private String cpfCliente, idFuncionario;
	private int idVenda;
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
	
	public Vendas(int idVenda, String cpf, String id, List<Item> carrinho) {
		this.idVenda = idVenda;
		this.cpfCliente = cpf;
		this.idFuncionario = id;
		this.carrinho = (Item) carrinho;
	}
	
	
	public Vendas() {
		
	}
	
	
	
	public void mostrar(List<Vendas> historicoVendas) {
		/*
		 * 	idVenda - Cliente - Funcionário - dataDaCompra
		 * 	-----------------------------------------------------------------------------------
		 * 	Item i = new Item();
		 * 	i.mostrar(carrinho);
		 */
		
		for (Vendas v : historicoVendas) {
	        	//System.out.println("Cpf cliente: " + v.getCpfCliente() + " - Id Funcionário: "+ v.getIdFuncionario() + " - Valor compra:  " + v.getPreco()*v.getQtd());
        }		
	}
	
	//Get 

	public String getCpfCliente() {
		return cpfCliente;
	}

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public int getidVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public Item getCarrinho() {
		return carrinho;
	}
}
