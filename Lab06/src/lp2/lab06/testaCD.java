package lp2.lab06;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class testaCD {
	String artista = "zezo";
	String titulo = "fuscao preto";
	String trilhaPrincipal  = "mulher de vermelho";
	int M = 9;
	CD Cd1;
	private CD cd1;
	@Before
	public void criaCD() throws Exception
	{
		cd1 = new CD(artista, titulo, trilhaPrincipal, M);
	}
	
	@Test
	public void testaCriaCD()
	{
		try
		{
			new CD("","fuscao preto","mulher de vermelho",10);
			fail("Esperava excessao pois artista nao pode ser uma string vazia");
		}
		catch (Exception e)
		{
			assertEquals("Mensagem Errada","Parametros incorretos para a criacao de um CD",e.getMessage());
		}
		
		try
		{
			new CD("zezo","","mulher de vermelho", 10);
			fail("Esperava excessao pois titulo nao pode ser uma string vazai");
		}
		catch (Exception e)
		{
			assertEquals("Mensagem Errada", "Parametros incorretos para a criacao de um CD", e.getMessage());
		}
		
		try
		{
			new CD("zezo","fuscao preto","mulher de vermelho", -1);
			fail("Esperava excessao pois a quantidade de faixas nao pode ser menor que zero");
		}
		catch (Exception e)
		{
			assertEquals("Mensagem Errada", "Parametros incorretos para a criacao de um CD", e.getMessage());
		}
		
	}
	
	@Test
	public void testaNovoCD() throws Exception
	{
		cd1.setTrilhaPrincipal("mulher de amigo meu");
		assertTrue(cd1.getTrilhaPrincipal() == "mulher de amigo meu");
		try
		{
			cd1 = new CD("antonio", "lalaia", "e laia", 12);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		cd1.setTrilhaPrincipal("a viagem");
		assertTrue(cd1.getTrilhaPrincipal() == "a viagem");
	}
	
	@Test
	public void testaCadastroFaixa()
	{
		assertTrue(cd1.cadastraFaixa("1"));
		assertTrue(cd1.cadastraFaixa("2"));
		assertTrue(cd1.cadastraFaixa("3"));
		assertTrue(cd1.cadastraFaixa("4"));
		assertTrue(cd1.cadastraFaixa("5"));
		assertTrue(cd1.cadastraFaixa("6"));
		assertTrue(cd1.cadastraFaixa("7"));
		assertTrue(cd1.cadastraFaixa("8"));
		assertTrue(cd1.cadastraFaixa("9"));
		assertFalse(cd1.cadastraFaixa("10"));
		
		try
		{
			cd1 = new CD("antonio", "lalaia", "e laia", 12);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		assertTrue(cd1.cadastraFaixa("1"));
		assertTrue(cd1.cadastraFaixa("2"));
		assertTrue(cd1.cadastraFaixa("3"));
		assertTrue(cd1.cadastraFaixa("4"));
		assertTrue(cd1.cadastraFaixa("5"));
		assertTrue(cd1.cadastraFaixa("6"));
		assertTrue(cd1.cadastraFaixa("7"));
		assertTrue(cd1.cadastraFaixa("8"));
		assertTrue(cd1.cadastraFaixa("9"));
		assertTrue(cd1.cadastraFaixa("10"));
		assertTrue(cd1.cadastraFaixa("11"));
		assertTrue(cd1.cadastraFaixa("12"));
		assertFalse(cd1.cadastraFaixa("13"));
	}

}
