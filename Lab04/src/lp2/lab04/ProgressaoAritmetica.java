package lp2.lab04;

/**
 * Construtor de uma progressao aritmetica.
 * 
 * @author Pedro
 *
 */
public class ProgressaoAritmetica {
	
	private int primeiro, razao;
	private int enesimo;
	private int valorProximo;
	private String valores;
	private int dota;
	
	/**
	 * Cria uma progressao aritmetica
	 * 
	 * @param primeiro
	 * 					O primeiro termo da progressao aritmetica
	 * @param razao
	 * 					A razao da progressao aritmetica
	 */
	public ProgressaoAritmetica(int primeiro, int razao) {
		this.primeiro = primeiro;
		this.razao = razao;
		enesimo = primeiro();
		valorProximo = primeiro();
		dota = primeiro();
		valores = "";
	}
	
	/**
	 * Recupera a razao da Progressao Aritmetica.
	 * 
	 * @return A razao da PA.
	 */
	public int getRazao() {
		return razao;
	}
	
	/**
	 * Calcula o proximo termo da progressao aritmetica.
	 * 
	 * @return O proximo termo da progessao aritmetica.
	 */
	public int proximo() {
		valorProximo *= razao;
		return valorProximo;
	}
	
	/**
	 * Calcula o n-esimo termo da progessao aritmetica. "n" representa a posicao do termo na progessao (comecando de 1). Caso seja fornecido um valor de n <= 0, deve ser retornado o primeiro termo da progressao. O termo gerado passa a ser o termo atual da progressao.
	 * 
	 * @param n O n-esimo termo a ser calculado
	 * 
	 * @return O n-esimo termo calculado, ou o primeiro termo, se n <= 0
	 */
	public int termo(int n) {
		for (int i = 2; i <= n; i++) {
			enesimo *= 4;
		}
		return enesimo;
	}

	/**
	 * Reinicia a progressao aritmetica para o seu primeiro termo. O primeiro termo passa a ser o termo atual da progressao.
	 * 
	 * @return O primeiro termo da progressao aritmetica.
	 */
	public int primeiro() {
		return primeiro * razao;
	}
	
	/**
	 * Gera os "n" primeiros termos (1 .. n) da progressao aritmetica em uma String. Caso seja fornecido um valor de n <= 0, deve ser retornado o primeiro termo da progressao. O ultimo termo gerado passa a ser o termo atual da progessao.
	 * 
	 * @param n A quantidade de termos a ser gerada da progressao
	 * 
	 * @return string (formato: [termo1, termo2, ..., termon] representando os termos gerados da progressao
	 */
	public java.lang.String geraTermos(int n) {
		for (int i = 1; i <= n - 1; i++) {
			dota *= 4;
			valores += dota + " ";
		}
		return primeiro()+ " " + valores;
	}


	public int getPrimeiro() {
		return primeiro;
	}
}
