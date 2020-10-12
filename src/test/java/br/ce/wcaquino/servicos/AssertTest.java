package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;

public class AssertTest {

	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);

		//� poss�vel colocar uma string antes da compara��o para sinalziar melhor o erro,.
		Assert.assertEquals("Erro de compara��o",1, 2);// compara um valor com outro, num/string
		Assert.assertEquals(0.51234, 0.512, 0.001);// passar um 3� par de casas de compara��o para validar
		Assert.assertEquals(Math.PI, 3.14, 0.01); // exemplo

		int i = 5;// Para o Assert int != Integer
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);//converter
		Assert.assertEquals(i, i2.intValue());// podemos usar a negativa do m�todo "NotEquals"

		// Assert.assertEquals("bola","Bola" ); << Nesses casos utilizar o m�todo da propria Classe String
		Assert.assertTrue("bola".equalsIgnoreCase("Bola")); // exemplo
		Assert.assertTrue("bola".startsWith("bo"));
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		// Inst�ncias diferentes, para passar no teste, devemos implementar o m�todo equals na classe Usuario
		Assert.assertEquals(u1, u2);
		/*O m�todo assertEquals busca o m�todo Equals da classe, mas se n�o achar, ele ir� buscar na classe
		 * pai, que se n�o definida ser� Object, onde � feita a compara��o a n�vel de inst�ncias*/
		
		//Assert.assertSame(u1, u2);
		// Compara 2 objetos a n�vel de inst�ncia mesmo com m�todo equals.
		
		
		
	}

}
