package lp2.prova1;
import java.util.*;

public class JogoDaVelha 
{	
	private char tabuleiro[][] = new char [3][3];
	private int i,j,jogada;
	final char O = 'O';
	final char X = 'X';
	static char VAZIO;
	Random xC = new Random();
	Random yC = new Random();
	public JogoDaVelha()
	{
		JogoDaVelha.VAZIO = ' ';
	}
	
	public char verificaVencedor()
	{
		 if((tabuleiro[0][0]==O && tabuleiro[0][1]==O && tabuleiro[0][2]==O)||
		    (tabuleiro[1][0]==O && tabuleiro[1][1]==O && tabuleiro[1][2]==O)||
		    (tabuleiro[2][0]==O && tabuleiro[2][1]==O && tabuleiro[2][2]==O)||
		    (tabuleiro[0][0]==O && tabuleiro[1][0]==O && tabuleiro[2][0]==O)||
		    (tabuleiro[0][1]==O && tabuleiro[1][1]==O && tabuleiro[2][1]==O)||
		    (tabuleiro[0][2]==O && tabuleiro[1][2]==O && tabuleiro[2][2]==O)||
		    (tabuleiro[0][0]==O && tabuleiro[1][1]==O && tabuleiro[2][2]==O)||
		    (tabuleiro[0][2]==O && tabuleiro[1][1]==O && tabuleiro[2][0]==O))
		 {
			return O;
		 }
		 if((tabuleiro[0][0]==X && tabuleiro[0][1]==X && tabuleiro[0][2]==X)||
		    (tabuleiro[1][0]==X && tabuleiro[1][1]==X && tabuleiro[1][2]==X)||
		    (tabuleiro[2][0]==X && tabuleiro[2][1]==X && tabuleiro[2][2]==X)||
		    (tabuleiro[0][0]==X && tabuleiro[1][0]==X && tabuleiro[2][0]==X)||
		    (tabuleiro[0][1]==X && tabuleiro[1][1]==X && tabuleiro[2][1]==X)||
		    (tabuleiro[0][2]==X && tabuleiro[1][2]==X && tabuleiro[2][2]==X)||
		    (tabuleiro[0][0]==X && tabuleiro[1][1]==X && tabuleiro[2][2]==X)||
		    (tabuleiro[0][2]==X && tabuleiro[1][1]==X && tabuleiro[2][0]==X))
		 {
			 return X;
		 }
		 else
		 {
			 return JogoDaVelha.VAZIO;
		 }
	}
	
	public void joga(int x, int y)
	{
		jogada++;
		if(getJogada() == O)
		{
			if(tabuleiro[x-1][y-1]==JogoDaVelha.VAZIO)
			{
				tabuleiro[x-1][y-1]=getJogada();
			}
		}
		
		if (getJogada() == X)
		{
			x = xC.nextInt(3);
			y = yC.nextInt(3);
			if(tabuleiro[x-1][y-1]==JogoDaVelha.VAZIO)
			{
				tabuleiro[x-1][y-1]=getJogada();
			}
		}
	}
	
	public char getJogada()
	{		
		if(jogada%2==1)
			return X;
		else
			return O;
	}
	
	public void iniciaTabuleiro()
	{
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				tabuleiro[i][j]=JogoDaVelha.VAZIO;
			}
		}
	}
	
	public char[][] getTabuleiro()
	{
		return tabuleiro;
	}
	
	public boolean temProximaJogada()
	{
		if(jogada == 9)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
