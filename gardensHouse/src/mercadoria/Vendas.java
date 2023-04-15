package mercadoria;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Vendas {
	
	
	private String cpfCliente, idFuncionario;
	private String idVenda;
	private List<Item> carrinho;
	private LocalDate dataDaCompra;
	
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
	
	public Vendas(String cpf, String id, LocalDate dataDaCompra, List<Item> carrinho) {
		this.cpfCliente = cpf;
		this.idFuncionario = id;
		this.dataDaCompra = dataDaCompra;
		this.carrinho = carrinho;
	}
	
	
	public Vendas() {
		
	}
	
	
	
	public void mostrar(List<Vendas> historicoDeVendas, Item kart, Scanner input) {
		
		int aux = 0;
		
		if(historicoDeVendas.isEmpty() == false) {
			double total = 0;
			for (Vendas v : historicoDeVendas) {
				aux ++;
				String idDeVenda = String.format( v.dataDaCompra.toString() + aux);
		        System.out.println(idDeVenda + " - " + v.getCpfCliente() + " - " + v.getIdFuncionario() + " - " + v.getDataDaCompra());
		        
				for (Item c : v.getCarrinho()) {
		        	c.mostrar(v.getCarrinho(), historicoDeVendas, input);
		        }

				System.out.println("--------------------------------------");
				System.out.println("Total:                          " + total);
			}
		} else {
			System.out.println("Não foram efetuadas vendas ainda.");
		}		
	}
	
	//Get 

	public String getCpfCliente() {
		return cpfCliente;
	}

	public String getIdFuncionario() {
		return idFuncionario;
	}

	public String getidVenda() {
		return idVenda;
	}

	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}

	public List<Item> getCarrinho() {
		return carrinho;
	}

	public LocalDate getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(LocalDate dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}
}
