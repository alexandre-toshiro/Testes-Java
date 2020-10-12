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
		//(1º-valor esperado, 2º Valor recebido)
		error.checkThat(locacao.getValor() ,is(equalTo(5.0)));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
		
		/*
		 * Existem diversas formas de lidar com testes, algumas pessoas defendem que cada assert deverá estar em uma classe diferente, já que quando colocamos todos em uma só, como agora, 
		 * é apenas sinalizado o 1º erro, caso tenham outros, só serão mostrado após a sua correção e assim sucessivamente. Só que ao utilizar essa estratégias, sserão geradas diversas classes para cada teste.
		 * Aqui iremos utilizar a classe ErrorCollector, que irá sinalizar todos os erros de uma só vez e irá também informar aonde estão esses erros, para que assim possamos verificar vários erros dentro da mesma classe.
		 * Cada estratégia possui seus prós e contras, devendo ser analizado caso a caso.
		 * */
	}

}