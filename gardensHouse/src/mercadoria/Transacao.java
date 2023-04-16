package mercadoria;

import java.time.LocalDate;
import java.util.List;


public class Transacao {

	private String cpfCliente;
    private String idFuncionario;
    private String idVenda;
    private String metodo;
    private LocalDate dataDaCompra;
    private List<Item> carrinho;
    private double total;

    
    public Transacao(String cpfCliente, String idFuncionario, LocalDate dataDaCompra, List<Item> carrinho, double total, String metodo) {
        this.cpfCliente = cpfCliente;
        this.idFuncionario = idFuncionario;
        this.dataDaCompra = dataDaCompra;
        this.carrinho = carrinho;
        this.total = total;
        this.metodo = metodo;
    }
    
    // getters e setters

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public LocalDate getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(LocalDate dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public List<Item> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Item> carrinho) {
        this.carrinho = carrinho;
    }

	public String getIdCompra() {
		return idVenda;
	}

	public void setIdCompra(String idVenda) {
		this.idVenda = idVenda;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}


	
}
