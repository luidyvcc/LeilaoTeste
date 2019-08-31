package br.fib.testes;

import br.fib.testes.leilao.Avaliador;
import br.fib.testes.modelos.Lance;
import br.fib.testes.modelos.Leilao;
import br.fib.testes.modelos.Usuario;

public class TesteDoAvaliador {

	   public static void main(String[] args) {

	       Usuario joao = new Usuario("Joao");
	       Usuario jose = new Usuario("José");
	       Usuario maria = new Usuario("Maria");
	       Leilao leilao = new Leilao("Playstation 3 Novo");

	       leilao.propoe(new Lance(joao, 300.0));
	       leilao.propoe(new Lance(jose, 400.0));
	       leilao.propoe(new Lance(maria, 250.0));

	       Avaliador leiloeiro = new Avaliador();

	       leiloeiro.avalia(leilao);

	       System.out.println(leiloeiro.getMaiorLance()); // imprime 400.0
	       
	       System.out.println(leiloeiro.getMenorLance()); // imprime 250.0
	       
	       // comparando a saida com o esperado
	       System.out.println(400 == leiloeiro.getMaiorLance());
	       System.out.println(250 == leiloeiro.getMenorLance());

	   }
	}
