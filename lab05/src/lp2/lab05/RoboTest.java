package lp2.lab05;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoboTest {
	
	private Robo robozinho;
	private Sala salinha;
	
	@Before
	public void criaSituacoes() throws Exception
	{
		salinha = new Sala(3,3);
		robozinho = new Robo(salinha,10);
	}
	
	@Test
	public void testaInicializaRobo() 
	{
		try {
			new Robo(salinha,-2);
			Assert.fail("Esperada uma excessão");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem Errada", 
					"Não se pode criar um robô com energia menor ou igual a zero",
					e.getMessage());
		}
		try {
			new Robo(salinha,0);
			Assert.fail("Esperada uma excessão");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem Errada", 
					"Não se pode criar um robô com energia menor ou igual a zero",
					e.getMessage());
		}
		try {
			new Robo(salinha,0);
			Assert.fail("Esperada uma excessão");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem Errada", 
					"Não se pode criar um robô com energia menor ou igual a zero",
					e.getMessage());
		}
		try {
			new Robo(null,10);
			Assert.fail("Esperada uma excessão");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem Errada", 
					"Por favor, determine uma sala pra o robô",
					e.getMessage());
		}
		
		for (int i = 0; i < salinha.lugares[0].length; i++) 
		{
			for (int j = 0; j < salinha.lugares[1].length; j++) 
			{
				salinha.inserirObstaculo(i, j);
			}
		}
		try {
			new Robo(salinha,10);
			Assert.fail("Esperada uma excessão");
		} catch (Exception e) {
			Assert.assertEquals(
					"Mensagem Errada", 
					"A sala tem de estar vazia, ou conter lugares vazios",
					e.getMessage());
		}
	}
	
	@Test
	public void testaPosicaoRobo() throws Exception
	{
		Assert.assertTrue(robozinho.getPosicaoRobo().equals("[0, 0]"));
		Assert.assertFalse(salinha.isPosicaoLivre(0, 0));
	}
	
	@Test 
	public void testaAdicionaObstaculo() throws Exception
	{
		salinha.inserirObstaculo(0, 0);
		Robo robozao = new Robo(salinha,4);
		Assert.assertTrue(robozao.getPosicaoRobo().equals("[0, 1]"));
	}
	
	@Test
	public void testaAndaRobo()
	{
		assertFalse(robozinho.andaTras());
		assertFalse(robozinho.andaCima());
		assertTrue(robozinho.getEnergia() == 10);
		assertTrue(robozinho.getNumPassos() == 0);
		assertTrue(robozinho.andaBaixo());
		assertTrue(robozinho.getPosicaoRobo().equals("[1, 0]"));
		assertTrue(robozinho.andaFrente());
		assertTrue(robozinho.getPosicaoRobo().equals("[1, 1]"));
		assertTrue(robozinho.andaCima());
		assertTrue(robozinho.getPosicaoRobo().equals("[0, 1]"));
		assertTrue(robozinho.andaTras());
		assertTrue(robozinho.getPosicaoRobo().equals("[0, 0]"));
	}
	
	@Test
	public void testaAndaComObstaculos()
	{
		salinha.inserirObstaculo(1,0);
		salinha.inserirObstaculo(0, 2);
		assertFalse(robozinho.andaBaixo());
		assertTrue(robozinho.getEnergia() == 10);
		assertTrue(robozinho.getNumPassos() == 0);
		assertTrue(robozinho.andaFrente());
		assertTrue(robozinho.getPosicaoRobo().equals("[0, 1]"));
		assertTrue(robozinho.getEnergia() == 9 && robozinho.getNumPassos() == 1);
		robozinho.andaFrente();
		assertTrue(robozinho.getEnergia() == 9 && robozinho.getNumPassos() == 1);
		robozinho.andaBaixo();
		assertTrue(robozinho.getEnergia() == 8 && robozinho.getNumPassos() == 2);
		//ao inserir um obstaculo em (1,0) e impossivel que o robo se encaixe nessa posicao
		
	}
	
}
