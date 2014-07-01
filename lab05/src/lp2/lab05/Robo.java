package lp2.lab05;

public class Robo 
{
	
	private Sala sala;
	public static char ROBO;
	private int energia;
	private int[] posicaoRobo;

	public Robo(Sala sala, int energia)
	{
		this.sala = sala;
		Robo.ROBO = 'P';
		this.energia = 10;
		posicaoInicialRobo();
		
	}

	public void posicaoInicialRobo()
	{
		int i=0,j=0;
		
		if(sala.isVazia())
		{
			sala.lugares[0][0] = ROBO;
			sala.vazia++;
		}
		if(!(sala.isVazia()) && sala.lugares[0][0] == Sala.OCUPADO)
		{
			while(true)
			{
				if(sala.lugares[i][j] == Sala.OCUPADO)
				{
					i++;
					if(i == (sala.getNum_linhas() - 1))
					{
						j++;
						if(j == (sala.getNum_colunas()-1))
						{
							break;
						}
					}
				}
				else if(sala.lugares[i][j] == Sala.LIVRE)
				{
					sala.lugares[i][j] = ROBO;
				}
			}
		}
	}
	
	public int[] getPosicaoRobo()
	{
		posicaoRobo = new int[2]; 
		int i,j;
		for(i=0;i<sala.getNum_linhas();i++)
		{
			for(j=0;j<sala.getNum_colunas();j++)
			{
				if(sala.lugares[i][j] == ROBO)
				{
					posicaoRobo[0] = i;
					posicaoRobo[1] = j;
					return posicaoRobo;
				}
			}
		}
		return null;
	}
	public void andaFrente()
	{
		
	}
}
