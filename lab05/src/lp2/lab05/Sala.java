/*
 * Pedro Alcântara
 * Mat.: 113210435 
 */

package lp2.lab05;


import java.util.Arrays;

/**
 * Cria uma sala na qual um Robo pode caminhar
 * 
 * @author Pedro
 *
 */
public class Sala {
	public char[][] lugares;
	public static char LIVRE;
	public static char OCUPADO;
	private int num_linhas;
	private int num_colunas;
	private int i,j;
	int vazia=0;
	
	/**
	 * Cria uma Sala
	 * 
	 * @param num_linhas
	 * 			Quantidade de linhas que a sala terá
	 * @param num_colunas
	 * 			Quantidade de colunas que a sala terá
	 * @throws Exception
	 * 			Lança uma excessão caso o numero de linhas ou o 
	 * numero de colunas seja menor ou igual a zero
	 */
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
	
	/**
	 * Inicia uma sala de acordo com o numero de linhas e colunas
	 * 
	 * @param linhas
	 * 			Numero de linhas que a sala deve ter
	 * @param colunas
	 * 			Numero de colunas que a sala deve ter
	 */
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
	
	/**
	 * Recupera o numero de linhas da sala
	 * 
	 * @return
	 * 		Numero de linhas atual da sala
	 */
	public int getNumPosicoesHorizontais()
	{
		return num_linhas;
	}
	
	/**
	 * Recupera o numero de colunas da sala
	 * 
	 * @return
	 * 		Numero de colunas atual da sala
	 */
	public int getNumPosicoesVerticais()
	{
		return num_colunas;
	}
	
	/**
	 * Determina se a sala tem ou nao obstaculos
	 * 
	 * @return
	 * 		true se a sala estiver sem obstaculos
	 * 		false se a sala conter obstaculos
	 */
	public boolean isVazia()
	{
		if(vazia != 0)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Insere um obstaculo em um determinado ponto da sala
	 * 
	 * @param linhaObstaculo
	 * 			Em qual linha o obstaculo deve ser colocado
	 * @param colunaObstaculo
	 * 			Em qual coluna o obstaculo deve ser colocado
	 * @return
	 * 			true se o obstaculo for colocado com sucesso
	 * 			false se houver algum ponto invalido e o obstaulo nao for colocado com sucesso
	 */
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
	
	/**
	 * Determina se a posicao esta livre ou nao na sala
	 * 
	 * @param linhaValida
	 * 			Linha na qual se quer saber se a posicao e valida
	 * @param colunaValida
	 * 			Coluna na qual se que sabr se a posicao e valida
	 * @return
	 * 			true se a posicao dada e valida
	 * 			false se a posica dada nao for valida
	 */
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
	
	/**
	 * Determina se a posicao dada contem um obstaculo ou nao
	 * 
	 * @param linhaLivre
	 * 			Linha a qual se quer determinar se a posicao esta livre
	 * @param colunaLivre
	 * 			Coluna a qual se quer determinar se a posicao esta livre
	 * @return
	 * 			true se a posicao dada estiver livre
	 * 			false se a posicao dada contiver um obstaculo
	 * @throws Exception
	 * 			Lança uma excessao caso a posicao dada foi inexitente
	 */
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
	
	/**
	 * Determina se uma certa posicao vai estar livre ou nao
	 * 
	 * @param linhaPosicao
	 * 			Linha da posicao que se deseja determinar se esta livre ou ocupada 
	 * @param colunaPosicao
	 * 			Coluna da posicao que se deseja determinar se esta livre ou ocupada
	 * @param statusPosicao
	 * 			Caractere que determina se a posicao estara livre ou ocupada
	 * @return
	 * 			true caso o caractere seja adicionado com sucesso
	 * 			false caso os parametros passados tenham sido invalidos
	 */
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
	
	/**
	 * Recupera o numero de linhas da sala
	 * 
	 * @return
	 * 			O numero de linhas da sala
	 */
	public int getNum_linhas() {
		return num_linhas;
	}
	
	/**
	 * Recupera o numero de colunas da sala
	 * 
	 * @return
	 * 			O numero de colunas da sala
	 */
	public int getNum_colunas() {
		return num_colunas;
	}

}
