package br.fib.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.fib.testes.leilao.Avaliador;
import br.fib.testes.modelos.Lance;
import br.fib.testes.modelos.Leilao;
import br.fib.testes.modelos.Usuario;

public class AvaliadorTeste {

	@Test
	public void deveRetornarOMaiorEMenorLance() {

		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 250.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(400.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(250.0, leiloeiro.getMenorLance(), 0.00001);

	}

	@Test
	public void deveRetornarOMaiorEMenorLanceOrdemCrescente() {

		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 200.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		leilao.propoe(new Lance(maria, 500.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(500.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(200.0, leiloeiro.getMenorLance(), 0.00001);

	}

	@Test
	public void deveRetornarOMaiorEMenorLanceOrdemDecrescente() {

		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 600.0));
		leilao.propoe(new Lance(jose, 400.0));
		leilao.propoe(new Lance(maria, 300.0));
		leilao.propoe(new Lance(maria, 100.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(600.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(100.0, leiloeiro.getMenorLance(), 0.00001);

	}

	@Test
	public void deveRetornarOMaiorEMenorLanceSemOrdem() {

		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 500.0));
		leilao.propoe(new Lance(jose, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(maria, 700.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(700.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(100.0, leiloeiro.getMenorLance(), 0.00001);

	}

	@Test
	public void deveRetornarOMaiorEMenorLanceUnicoLance() {

		Usuario joao = new Usuario("Joao");
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 500.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(500.0, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(500.0, leiloeiro.getMenorLance(), 0.00001);

	}

	@Test
	public void deveEncontrarOsTresMaioresLances() {

		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 100.0));
		leilao.propoe(new Lance(maria, 200.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		List<Lance> maiores = leiloeiro.getTresMaiores();

		assertEquals(3, maiores.size());

		assertEquals(400, maiores.get(0).getValor(), 0.00001);
		assertEquals(300, maiores.get(1).getValor(), 0.00001);
		assertEquals(200, maiores.get(2).getValor(), 0.00001);

	}

}
