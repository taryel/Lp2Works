/* Aluno: Pedro Alcantara */

package lp2.lab03;

import java.util.*;

public class JogoDaVelhaModularizado 
{
	public static void main(String args[])
	{
		char tabuleiro[][] = new char[3][3];
		final char O='O';
		final char X='X';
	    int jogada=0,j=0,i;
	    Scanner sc = new Scanner(System.in);


	    for(i=0;i<3;i++)
	        for(j=0;j<3;j++)
	            tabuleiro[i][j]=' ';

	    while(jogada<=9)
	    {
	        System.out.print("  JOGO DA VELHA \n");
	        
	        criaTabuleiro(i,tabuleiro);
	        
	        coordenadas(jogada,i,j,tabuleiro,sc,X,O);
	        jogada++;
	        
	        if((tabuleiro[0][0]==O && tabuleiro[0][1]==O && tabuleiro[0][2]==O)||
	           (tabuleiro[1][0]==O && tabuleiro[1][1]==O && tabuleiro[1][2]==O)||
	           (tabuleiro[2][0]==O && tabuleiro[2][1]==O && tabuleiro[2][2]==O)||
	           (tabuleiro[0][0]==O && tabuleiro[1][0]==O && tabuleiro[2][0]==O)||
	           (tabuleiro[0][1]==O && tabuleiro[1][1]==O && tabuleiro[2][1]==O)||
	           (tabuleiro[0][2]==O && tabuleiro[1][2]==O && tabuleiro[2][2]==O)||
	           (tabuleiro[0][0]==O && tabuleiro[1][1]==O && tabuleiro[2][2]==O)||
	           (tabuleiro[0][2]==O && tabuleiro[1][1]==O && tabuleiro[2][0]==O))
	        {
	        	criaTabuleiro(i,tabuleiro);
	        	
	           	System.out.print("\nJogador 1, VOCE VENCEU!!!");
	            break;
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
	        	criaTabuleiro(i,tabuleiro);
	        	
	        	System.out.print("\nJogador 2, VOCE VENCEU!!!");
	            break;
	        }

	        if(jogada==9)
	        {
	        	criaTabuleiro(i,tabuleiro);
	        	
	        	System.out.print("\nPARTIDA EMPATADA");
	            break;
	        }

	    }
	    sc.close(); //fecha o objeto Scanner
	}

	//inicio da modularizacao
	private static void criaTabuleiro (int i, char tabuleiro[][]) 
	{
        for(i=0;i<3;i++)
        {
        	System.out.print(tabuleiro[i][0]+"|"+tabuleiro[i][1]+"|"+tabuleiro[i][2]);
            if(i<3-1)
            {
            	System.out.print("\n------\n");
            }
        }
	}
	private static void coordenadas (int jogada,int i, int j, char tabuleiro[][], Scanner sc, char X, char O) 
	{
		System.out.println("\nINSIRA AS COORDENADAS");
        if((jogada%2)==1)System.out.print("PLAYER 2\nLINHA: ");
        else System.out.print("PLAYER 1\nLINHA: ");
        
        i = sc.nextInt();
        while (i <= 0)
        {
        	System.out.println("por favor digite 1, 2 ou 3");
        	i = sc.nextInt();
        }
        System.out.print("COLUNA: ");
        j = sc.nextInt();
        while(j <= 0)
        {
        	System.out.println("por favor digite 1, 2 ou 3");
        	j = sc.nextInt();
        }
        
        if(tabuleiro[i-1][j-1]==' ')
        {
            if((jogada%2)==1)tabuleiro[i-1][j-1]=X;
            else tabuleiro[i-1][j-1]=O;
            System.out.println(jogada);
        }
	}
	
}
