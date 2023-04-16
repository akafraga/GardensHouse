package mercadoria;

import java.util.ArrayList;
import java.util.List;

public class Historico {
	private List<Transacao> historicoDeVendas;

    public Historico() {
        this.historicoDeVendas = new ArrayList<Transacao>();
    }

    public void realizarVendas(Transacao vendas) {
        this.historicoDeVendas.add(vendas);
    }

    // get e set

    public List<Transacao> getHistoricoDeVendas() {
        return historicoDeVendas;
    }

    public void setHistoricoDeVendas(List<Transacao> historicoDeVendas) {
        this.historicoDeVendas = historicoDeVendas;
    }
}
