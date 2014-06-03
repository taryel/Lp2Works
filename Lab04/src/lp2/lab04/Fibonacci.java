/*
 * Pedro Alcantara
 * Mat.: 113210435
 */
package lp2.lab04;

/**
 * Construtor de uma Sequencia Fibonacci
 * 
 * @author Pedro
 *
 */
public class Fibonacci {
	private int n;
	private int nextFibo;
	private int prevFibo;
	private String valoresFibo;
	
	/**
	 * Cria uma sequencia Fibonacci.
	 * 
	 * @param n O numero inicial da sequencia.
	 */
	public Fibonacci (int n) {
		this.n = n;
		nextFibo = 0;
		prevFibo = 0;
		valoresFibo = "";
	}
	
	/**
	 * Reinicia a sequencia Fibonacci. O primeiro numero passa a ser o numero atual da sequencia.
	 * 
	 * @return O primeiro numero da sequencia Fibonacci.
	 */
	public int primeiroFibo() {
		return n + n-1;
	}
	
	/**
	 * Calcula o n-esimo numero da sequencia Fibonacci. "termo" representa a posicao do termo na sequencia.
	 * 
	 * @param termo O n-esimo termo a ser calculado.
	 * 
	 * @return O n-esimo termo calculado, ou o primeiro termo, caso "termo" == 1.
	 */
	public int termoFibo(int termo) {
		for (int i = 1; i <= termo; i++) { 
			if (i == 1) {
				nextFibo = 1; 
				prevFibo = 0;
				
			} else { 
				nextFibo += prevFibo; 
				prevFibo = nextFibo - prevFibo; 
			} 
		}
		return nextFibo;
	}
	
	/**
	 * Gera os "n" primeiros termos (1 .. n) da sequencia Fbinacci em uma String. O ultimo termo gerado passa a ser o termo atual da sequencia.
	 * 
	 * @param termos A quantidade de termos a ser gerada.
	 * 
	 * @return a string (formato: [termo1, termo2, ..., termon] representando os termos gerados.
	 */
	public java.lang.String geraTermosFibo(int termos) {
		for (int i = 1; i <= termos; i++) { 
			if (i == 1) {
				nextFibo = 1; 
				prevFibo = 0;
				valoresFibo += nextFibo + " ";
				
			} else { 
				nextFibo += prevFibo; 
				prevFibo = nextFibo - prevFibo;
				valoresFibo += nextFibo + " ";
			}
			
		}
		return valoresFibo;
	} 
}
