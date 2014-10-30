/**
 * Pedro Alcântara
 * Mat.: 113210435
 * 
 * PS.: apenas parte 1 enviada pois o HD do meu laptop acaba de queimar
 * e essa foi a ultima parte que eu enviei para o github.
 * Enviado do computador de um colega.
 * 
 */

package lp2.lab05;

import java.util.Arrays;

public class Sala {
	public char[][] lugares;
	public static char LIVRE;
	public static char OCUPADO;
	private int num_linhas;
	private int num_colunas;
	private int i,j;
	int vazia=0;
	
	Sala(int num_linhas, int num_colunas) throws Exception
	{
		Sala.OCUPADO = 'X';
		Sala.LIVRE = ' ';
		this.num_linhas = num_linhas;
		this.num_colunas = num_colunas;
		
		if(num_linhas <= 0 || num_colunas <= 0)
		{
			throw new Exception ("Parametros incorretos para a criacao da sala. As dimensoes da sala devem ser representadas por valores positivos maiores que zero");
		}
		
		iniciaSala(num_linhas,num_colunas);
	}
	
	public void iniciaSala(int linhas, int colunas)
	{
		lugares = new char[num_linhas][num_colunas];
		for(i=0;i<linhas;i++)
		{
			for(j=0;j<colunas;j++)
			{
				lugares[i][j] = LIVRE;
			}
		}
	}
	
	public int getNumPosicoesHorizontais()
	{
		return num_linhas;
	}
	
	public int getNumPosicoesVerticais()
	{
		return num_colunas;
	}
	
	public boolean isVazia()
	{
		if(vazia != 0)
		{
			return false;
		}
		return true;
	}
	
	public boolean inserirObstaculo(int linhaObstaculo, int colunaObstaculo)
	{
		if(linhaObstaculo < 0 || colunaObstaculo < 0)
		{
			return false;
		}
		else if(linhaObstaculo > lugares.length-1 || colunaObstaculo > lugares[0].length-1)
		{
			return false;
		}
		else
		{
			lugares[linhaObstaculo][colunaObstaculo] = OCUPADO;
			vazia++;
			return true;
		}
	}
	
	public boolean posicaoValida(int linhaValida,int colunaValida)
	{
		
		if(linhaValida < 0 || colunaValida < 0)
		{
			return false;
		}
		else if(linhaValida > num_linhas || colunaValida > num_colunas)
		{
			return false;
		}
		else if(linhaValida > lugares.length-1 || colunaValida > lugares[0].length-1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean isPosicaoLivre(int linhaLivre, int colunaLivre) throws Exception
	{
		if(linhaLivre < 0 || colunaLivre < 0)
		{
			throw new Exception ("Posicao inexistente.");
		}
		else if(linhaLivre > lugares.length-1 || colunaLivre > lugares[0].length-1)
		{
			return false;
		}
		else if(lugares[linhaLivre][colunaLivre] == LIVRE)
		{
			return true;
		}
		return false;
	}
	
	public boolean setPosicao(int linhaPosicao, int colunaPosicao, char statusPosicao)
	{
		if(linhaPosicao < 0 || colunaPosicao < 0)
		{
			return false;
		}
		else if(linhaPosicao > lugares.length-1 || colunaPosicao > lugares[0].length-1)
		{
			return false;
		}
		lugares[linhaPosicao][colunaPosicao] = statusPosicao;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		if (!Arrays.deepEquals(lugares, other.lugares))
			return false;
		if (num_colunas != other.num_colunas)
			return false;
		if (num_linhas != other.num_linhas)
			return false;
		if (vazia != other.vazia)
			return false;
		return true;
	}
	
	public int getNum_linhas() {
		return num_linhas;
	}

	public void setNum_linhas(int num_linhas) {
		this.num_linhas = num_linhas;
	}

	public int getNum_colunas() {
		return num_colunas;
	}

	public void setNum_colunas(int num_colunas) {
		this.num_colunas = num_colunas;
	}
}
