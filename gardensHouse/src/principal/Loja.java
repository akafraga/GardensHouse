package principal;

import java.util.ArrayList;
import java.util.List;

import menu.menuCliente;
import individuo.Cliente;
import individuo.Funcionario;
import mercadoria.Produto;
import mercadoria.Item;
import mercadoria.Vendas;

public class Loja {

	public static void main(String[] args) {
		
		List<Produto> estoqueDaLoja = new ArrayList<Produto>(); // estoque da loja
		List<Funcionario> colaboradores = new ArrayList<Funcionario>(); // banco de dados com os funcionários
		List<Item> carrinhoDeCompras = new ArrayList<Item>(); // carrinho de compras atual
		List<Cliente> clientela = new ArrayList<Cliente>(); // banco de dados com os clientes que já compraram
		List<Vendas> historicoDeVendas = new ArrayList<Vendas>(); // vendas anteriores registradas
		
		Produto armazem = new Produto();
		Funcionario empregado = new Funcionario();
		Item kart = new Item();
		Cliente fregues = new Cliente();
		Vendas vazao = new Vendas();
		
		
		menuCliente mc = new menuCliente();
		mc.menuLoja(estoqueDaLoja, colaboradores, carrinhoDeCompras, clientela, historicoDeVendas, armazem, empregado, kart, fregues, vazao);
		
		
	}

}
