package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {
	
	@Rule
	public ErrorCollector error = new ErrorCollector();

	@Test
	public void testeLocacao() {
		// cenario
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);

		// acao
		Locacao locacao = service.alugarFilme(usuario, filme);

		// verificacao
		//(1�-valor esperado, 2� Valor recebido)
		error.checkThat(locacao.getValor() ,is(equalTo(5.0)));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
		
		/*
		 * Existem diversas formas de lidar com testes, algumas pessoas defendem que cada assert dever� estar em uma classe diferente, j� que quando colocamos todos em uma s�, como agora, 
		 * � apenas sinalizado o 1� erro, caso tenham outros, s� ser�o mostrado ap�s a sua corre��o e assim sucessivamente. S� que ao utilizar essa estrat�gias, sser�o geradas diversas classes para cada teste.
		 * Aqui iremos utilizar a classe ErrorCollector, que ir� sinalizar todos os erros de uma s� vez e ir� tamb�m informar aonde est�o esses erros, para que assim possamos verificar v�rios erros dentro da mesma classe.
		 * Cada estrat�gia possui seus pr�s e contras, devendo ser analizado caso a caso.
		 * */
	}

}