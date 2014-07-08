package lp2.lab06;

import java.util.*;
/**
 * 
 * @author Pedro Alcantara
 * @version 07/07 23:01
 * 
 */
public class CD 
{
	private String artista;
	private String titulo;
	private String trilhaPrincipal;
	private int M;
	private ArrayList<String> CDTracks = new ArrayList<String>();
	
	/**
	 * Cria um CD com o nome do artista, titulo do CD, trilha principal e quantidade de faixas do disco.
	 * 
	 * @param artista
	 * 		artista do CD.
	 * @param titulo
	 * 		titulo do CD.
	 * @param trilhaPrincipal
	 * 		trilha principal do CD.
	 * @param m
	 * 		quantidade de faixas.
	 * @throws Exception    
	 * 		excecao no caso do CD ser construido de forma errada.
	 */
	public CD(String artista, String titulo, String trilhaPrincipal, int m) throws Exception
	{
		this.artista = artista;
		this.titulo = titulo;
		this.trilhaPrincipal = trilhaPrincipal;
		M = m;
		CDTracks.add(trilhaPrincipal);
		
		if(artista == "" || titulo == "" || m < 0)
		{
			throw new Exception ("Parametros incorretos para a criacao de um CD");
		}
	}
	/**
	 * Segundo contrutor.
	 * 
	 * @param titulo
	 * 		titulo do CD.
	 * @param artista
	 * 		artista do CD.
	 * @throws Exception
	 * 		excecao no caso de algum dos campos estar vazio.
	 */
	public CD(String titulo, String artista) throws Exception
	{
		this.artista = artista;
		this.titulo = titulo;
		
		if(titulo == "" || artista == "")
		{
			throw new Exception("Parametros incorretos para a criacao de um CD");
		}
	}
	
	/**
	 * retorna o artista do CD.
	 * 
	 * @return
	 * 		o nome do artista.
	 */
	public String getArtista() 
	{
		return artista;
	}
	
	/**
	 * retorna o titulo do CD.
	 * 
	 * @return
	 * 		retorna o titulo.
	 */
	public String getTitulo() 
	{
		return titulo;
	}

	/**
	 * retorna a trilha principal do CD.
	 * 
	 * @return
	 * 		a trilha principal.
	 */
	public String getTrilhaPrincipal() 
	{
		return trilhaPrincipal;
	}

	/**
	 * retorna a quantidade de faixas do CD.
	 *
	 * @return
	 * 		a quantidade de faixas.
	 */
	public int getM() 
	{
		return M;
	}
	
	/**
	 * muda o nome da trilha principal do CD.
	 * 
	 * @param novaTrilha
	 * 		nome da nova trilha.
	 * @return
	 * 		a nova trilha.
	 * @throws Exception
	 * 		excecao no caso de a trilha nao existir no CD.
	 */
	public String setTrilhaPrincipal(String novaTrilha) throws Exception
	{
		int trilha;
		for(trilha=0;trilha<=CDTracks.size();trilha++)
		{
			if(trilhaPrincipal == CDTracks.get(trilha))
			{
				trilhaPrincipal = novaTrilha;
				return trilhaPrincipal;
			}
		}
		throw new Exception("A trilha principal nao esta listada nas trilhas do CD");
	}
	
	/**
	 * retorna a i-esima faixa especifica do CD.
	 * 
	 * @param faixa
	 * 		numero da faixa a ser retornada.
	 * @return
	 * 		a faixa especificada.
	 */
	public String getFaixa(int faixa)
	{
		if(faixa<0)
		{
			return null;
		}
		else if(faixa > M)
		{
			return null;
		}
		return CDTracks.get(faixa);
	}
	
	/**
	 * cadastra uma nova faixa no CD caso o numero de faixas do CD tenha ultrapassado o numero M de faixas retorna falso.
	 * 
	 * @param nomeFaixa
	 * 			nome da faixa a ser adicionada.
	 * @return
	 * 			verdadeiro caso a faixa for adicionada com sucesso e falso caso ela nao possa ser adicionada.
	 */
	public boolean cadastraFaixa(String nomeFaixa)
	{
		if(CDTracks.size() > M)
		{
			return false;
		}
		else
		{
			CDTracks.add(nomeFaixa);
			return true;
		}
	}
	/**
	 * metodo toString da classe
	 */
	public String toString() {
		return "CD [artista=" + artista + ", titulo=" + titulo
				+ ", trilhaPrincipal=" + trilhaPrincipal + ", M=" + M
				+ ", CDTracks=" + CDTracks + ", getArtista()=" + getArtista()
				+ ", getTitulo()=" + getTitulo() + ", getTrilhaPrincipal()="
				+ getTrilhaPrincipal() + ", getM()=" + getM() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	/**
	 * metodo equals da classe
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CD other = (CD) obj;
		if (CDTracks == null) {
			if (other.CDTracks != null)
				return false;
		} else if (!CDTracks.equals(other.CDTracks))
			return false;
		if (M != other.M)
			return false;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (trilhaPrincipal == null) {
			if (other.trilhaPrincipal != null)
				return false;
		} else if (!trilhaPrincipal.equals(other.trilhaPrincipal))
			return false;
		return true;
	}
}

