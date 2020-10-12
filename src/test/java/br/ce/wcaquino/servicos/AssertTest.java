package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {

	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);

		//É possível colocar uma string antes da comparação para sinalziar melhor o erro,.
		Assert.assertEquals("Erro de comparação",1, 2);// compara um valor com outro, num/string
		Assert.assertEquals(0.51234, 0.512, 0.001);// passar um 3º par de casas de comparação para validar
		Assert.assertEquals(Math.PI, 3.14, 0.01); // exemplo

		int i = 5;// Para o Assert int != Integer
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);//converter
		Assert.assertEquals(i, i2.intValue());// podemos usar a negativa do método "NotEquals"

		// Assert.assertEquals("bola","Bola" ); << Nesses casos utilizar o método da propria Classe String
		Assert.assertTrue("bola".equalsIgnoreCase("Bola")); // exemplo
		Assert.assertTrue("bola".startsWith("bo"));
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		// Instâncias diferentes, para passar no teste, devemos implementar o método equals na classe Usuario
		Assert.assertEquals(u1, u2);
		/*O método assertEquals busca o método Equals da classe, mas se não achar, ele irá buscar na classe
		 * pai, que se não definida será Object, onde é feita a comparação a nível de instâncias*/
		
		//Assert.assertSame(u1, u2);
		// Compara 2 objetos a nível de instância mesmo com método equals.
		
		
		
	}

}
