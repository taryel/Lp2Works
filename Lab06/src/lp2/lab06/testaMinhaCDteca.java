package lp2.lab06;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class testaMinhaCDteca {
	private List<CD> CDs;
	private MinhaCDteca CdTeca1;
	private CD Cd;
	
	@Before
	public void criaCdTeca() throws Exception
	{
		Cd = new CD("antonio", "lalaia", "e laia", 12);
		CdTeca1 = new MinhaCDteca(CDs);
	}
	
	@Test
	public void testaAdicionaCD() 
	{
		CdTeca1.adicionaCD(Cd);
		assertTrue(CdTeca1.getMinhaCDtecaSize() == 1);
		try
		{
			Cd = new CD("filipi", "elalalie","lalala", 11);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		CdTeca1.adicionaCD(Cd);
		assertTrue(CdTeca1.getMinhaCDtecaSize() == 2);
	}
	
	@Test
	public void testaAdicionaCDs()
	{
		
	}

}
