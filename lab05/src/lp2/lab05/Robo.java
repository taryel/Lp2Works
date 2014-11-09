/*
 * Pedro Alcântara
 * Mat.: 113210435
 */

package lp2.lab05;

import java.util.Arrays;

/**
 * Cria um Robo que utiliza uma sala como campo.
 * 
 * @author Pedro
 *
 */
public class Robo 
{
	private Sala sala;
	public static char ROBO;
	private int energia;
	private int numPassos;
	private int[] posicaoRobo = new int[2];
	private boolean haPosicaoLivre = true;
	
	/**
	 * Constroi um robo
	 * 
	 * @param sala
	 * 				Sala na qual o robo vai se movimentar
	 * @param energia
	 * 				Quantidade de energia que o robo pode utilizar durante a
	 * movimentação
	 * @throws Exception
	 * 				Excessão lançada quando o robo é criado com uma sala do tipo null,
	 * quando a energia dada e negativa ou quando nao ha posicao livre na sala 
	 */
	public Robo(Sala sala, int energia) throws Exception
	{
		if(energia <= 0)
		{
			throw new Exception("Não se pode criar um robô com energia menor ou igual a zero");
		}
		if(sala == null)
		{
			throw new Exception("Por favor, determine uma sala pra o robô");
		}
		if(!haPosicaoLivre)
		{
			throw new Exception("A sala tem de estar vazia, ou conter lugares vazios");
		}
		
		
		this.sala = sala;
		Robo.ROBO = 'P';
		this.energia = energia;
		this.numPassos = 0;
		posicaoInicialRobo();
		
	}
	/**
	 * Determina a posicao no qual o robo sera colocado na sala caso hajam obstaculos
	 * 
	 * @throws Exception
	 * 				Lança uma excessao caso nao haja espacos vagos na sala
	 */
	public void posicaoInicialRobo() throws Exception
	{
		int i=0,j=0;
		if(sala.isVazia())
		{
			sala.lugares[0][0] = ROBO;
			sala.vazia++;
		}
		while(!(sala.isVazia()) && sala.lugares[i][j] == Sala.OCUPADO)
		{
			j += 1;
			if(j == sala.getNum_colunas() - 1)
			{
				i++;
			}
			if(sala.lugares[i][j] == Sala.LIVRE)
			{
				sala.lugares[i][j] = ROBO;
				break;
			}
			if(sala.lugares[i][j] == sala.lugares[sala.getNum_linhas()-1][sala.getNum_colunas()-1])
			{
				haPosicaoLivre = false;
				throw new Exception("A sala tem de estar vazia, ou conter lugares vazios");
			}
		}
	}
	
	/**
	 * Recupera a posicao atual do Robo na sala
	 * 
	 * @return
	 * 		A posicao atual do Robo na sala
	 */
	public String getPosicaoRobo()
	{
		int i,j;
		for(i=0;i<sala.getNum_linhas();i++)
		{
			for(j=0;j<sala.getNum_colunas();j++)
			{
				if(sala.lugares[i][j] == ROBO)
				{
					posicaoRobo[0] = i;
					posicaoRobo[1] = j;
					
					return Arrays.toString(posicaoRobo);
				}
			}
		}
		return null;
	}
	
	/**
	 * Metodo utilizado para determinar a posicao do robo na sala
	 */
	private void setPosicaoRobo()
	{
		sala.lugares[posicaoRobo[0]][posicaoRobo[1]] = ROBO;
	}
	
	/**
	 * Metodo utilizado para esvaziar o lugar do qual o robo se moveu
	 */
	private void esvaziaLugar()
	{
		sala.lugares[posicaoRobo[0]][posicaoRobo[1]] = Sala.LIVRE;
	}
	
	/**
	 * Move o robo em uma casa para a direita dentro da sala
	 * 
	 * @return
	 * 		true se o robo pode se mover
	 * 		false se o robo nao pode se mover
	 */
	public boolean andaFrente()
	{
		if(posicaoRobo[1] == (sala.getNum_colunas() - 1) || sala.lugares[posicaoRobo[0]][(posicaoRobo[1]+1)] == Sala.OCUPADO )
		{
			return false;
		}
		if(energia == 0)
		{
			return false;
		}
		esvaziaLugar();
		posicaoRobo[1] += 1;
		setPosicaoRobo();
		numPassos ++;
		energia -= 1;
		return true;
	}
	
	/**
	 * Move o robo em uma casa para a esquerda dentro da sala
	 * 
	 * @return
	 * 		true se o robo pode se mover
	 * 		false se o robo nao pode se mover
	 */
	public boolean andaTras() 
	{
		if(posicaoRobo[1] == 0 || sala.lugares[posicaoRobo[0]][(posicaoRobo[1]-1)] == Sala.OCUPADO)
		{
			return false;
		}
		if(energia == 0)
		{
			return false;
		}
		esvaziaLugar();
		posicaoRobo[1] -= 1;
		setPosicaoRobo();
		numPassos ++;
		energia -= 1;
		return true;
	}
	
	/**
	 * Move o robo uma casa acima na sala
	 * 
	 * @return
	 * 		true se o robo pode se mover
	 * 		false se o robo nao pode se mover
	 */
	public boolean andaCima()
	{
		if(posicaoRobo[0] == 0 || sala.lugares[(posicaoRobo[0]-1)][(posicaoRobo[1])] == Sala.OCUPADO)
		{
			return false;
		}
		if(energia == 0)
		{
			return false;
		}
		esvaziaLugar();
		posicaoRobo[0] -= 1;
		setPosicaoRobo();
		numPassos ++;
		energia -= 1;
		return true;
	}
	
	/**
	 * Move o robo uma casa abaixo na sala
	 * 
	 * @return
	 *  	true se o robo pode se mover
	 * 		false se o robo nao pode se mover
	 */
	public boolean andaBaixo()
	{
		if(posicaoRobo[0] == (sala.getNum_linhas() - 1) || sala.lugares[(posicaoRobo[0]+1)][(posicaoRobo[1])] == Sala.OCUPADO)
		{
			return false;
		}
		if(energia == 0)
		{
			return false;
		}
		esvaziaLugar();
		posicaoRobo[0] += 1;
		setPosicaoRobo();
		numPassos ++;
		energia -= 1;
		return true;
	}
	
	/**
	 * Recupera a energia atual do robo
	 * 
	 * @return
	 * 		A energia atual do robo
	 */
	public int getEnergia() 
	{
		return energia;
	}
	
	/**
	 * Recupera o Numero de Passos dados pelo robo
	 * 
	 * @return
	 * 		A quantidade de passos dados pelo robo
	 */
	public int getNumPassos() 
	{
		return numPassos;
	}
	
	@Override
	public String toString() 
	{
		return "Robo [sala=" + sala + ", energia=" + energia + ", numPassos="
				+ numPassos + ", posicaoRobo=" + Arrays.toString(posicaoRobo)
				+ ", haPosicaoLivre=" + haPosicaoLivre + ", getPosicaoRobo()="
				+ getPosicaoRobo() + ", getPosicaoRobo0()=" + ", andaFrente()=" + andaFrente() + ", andaTras()="
				+ andaTras() + ", andaCima()=" + andaCima() + ", andaBaixo()="
				+ andaBaixo() + ", getEnergia()=" + getEnergia()
				+ ", getNumPassos()=" + getNumPassos() + "]";
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Robo other = (Robo) obj;
		if (energia != other.energia)
			return false;
		if (haPosicaoLivre != other.haPosicaoLivre)
			return false;
		if (numPassos != other.numPassos)
			return false;
		if (!Arrays.equals(posicaoRobo, other.posicaoRobo))
			return false;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		return true;
	}
}
