package br.fib.testes.modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {
	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {
		if (lances.isEmpty() || !getUltimoLance().getUsuario().equals(lance.getUsuario())) {

			if (getLancesDoUsuario(lance) < 5)
				lances.add(lance);

		}
	}

	private int getLancesDoUsuario(Lance lance) {
		int lances = 0;
		for (Lance item : this.getLances()) {
			if (item.getUsuario() == lance.getUsuario()) {
				lances++;
			}
		}
		return lances;
	}

	private Lance getUltimoLance() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}
}
