/*Aluno: Pedro Alcântara*/

package lp2.prova1;


import java.util.*;

public class MeuJogoDaVelha {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int coordX = 0;
		int coordY = 0;
		char jogadorAtual = JogoDaVelha.VAZIO;
		boolean temVencedor = false;
		
		
		System.out.println("JOGO DA VELHA 3x3");
		JogoDaVelha ojogo = new JogoDaVelha();
		ojogo.iniciaTabuleiro();
		
		while(ojogo.temProximaJogada()){
			mostraTabuleiro(ojogo.getTabuleiro());
			jogadorAtual = ojogo.getJogada(); //O ou X
			System.out.println("\nJogador: " + "\'" + jogadorAtual + "\'");
			System.out.println("Insira as coordenadas");
			System.out.print("Linha: ");
			coordX = sc.nextInt();
			System.out.print("Coluna: ");
			coordY = sc.nextInt();
			ojogo.joga(coordX, coordY);
			if(ojogo.verificaVencedor() != JogoDaVelha.VAZIO){ //VAZIO ou O ou X
				System.out.println("\nJogador: " + "\'" + jogadorAtual + "\'" + " VENCEU");
				mostraTabuleiro(ojogo.getTabuleiro());
				temVencedor = true;
				break;
			}
		}
		if(!temVencedor){
			System.out.println("JOGO EMPATADO!");
		}
	sc.close();			
	}
	private static void mostraTabuleiro(char[][] tabuleiro){
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				if(j == tabuleiro[i].length - 1)
					System.out.print(tabuleiro[i][j]);
				else
					System.out.print(tabuleiro[i][j]+"|");
			}
			if(i<tabuleiro.length-1)
            {
            	System.out.print("\n------\n");
            }			
		}
	}
}
