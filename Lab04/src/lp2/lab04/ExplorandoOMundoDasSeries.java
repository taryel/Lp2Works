/* Pedro Alcantara
 * Mat.: 113210435
 */

package lp2.lab04;

import java.util.*;

public class ExplorandoOMundoDasSeries {
	
	
	public static int opcao, primeiro, razao, primeiroFibo, termo, termofibo;
	public static final String PROMPT = "Ola usuario, voce deseja: \n 1. Criar uma progressao aritmetica?\n 2. Criar uma serie de Fibonacci?\n 3. Para ver o termo 'n' da sua PA\n 4. Para ver o termo 'n' da serie de Fibonacci\n 5. Para mostrar os 'n' primeiros termos da sua PA e da serie de Fibonacci\n 6. Para sair";
	public static final int FECHA = 6;
	public static int regulador;
	public static Scanner input = new Scanner(System.in);
	public static ProgressaoAritmetica pa;
	public static Fibonacci fibo;
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println(PROMPT);
		opcao = input.nextInt();
		
		while (opcao != FECHA) 
		{
			casoUmDois(opcao);
			casoTresQuatro(opcao);
			casoCinco(opcao);
			System.out.println(PROMPT);
			opcao = input.nextInt();
		}
		
		input.close(); // fechando o scanner
	}
	
	//caso o usuario escolha a opcao 1 ou 2 aqui sao criadas a PA ou a sequencia Fibonacci
	public static void casoUmDois(int opcao) 
	{
		switch (opcao) 
		{
		
		case 1: System.out.println("Digite o primeiro numero da Progressao:");
				primeiro = input.nextInt();
				System.out.println("Digite a razao da Progressao:");
				razao = input.nextInt();
				pa = new ProgressaoAritmetica(primeiro, razao); //criacao da PA
				regulador = 1;
				break;
				
		case 2: System.out.println("Digite o primeiro numero da sequencia Fibonacci:");
				primeiroFibo = input.nextInt();
				fibo = new Fibonacci(primeiroFibo); //criacao da sequencia Fibonacci
				regulador = 2;
				break;
		}
	}
	
	//caso o usuario selecione a opcao 3 ou 4 esse metodo eh ativado
	public static void casoTresQuatro(int opcao) 
	{
		
		switch (opcao) 
		{
		case 3: if(regulador != 1)
			{
				System.out.println("Favor criar uma Progressao primeiro");
				casoUmDois(1);
				regulador = 3;
				break;
			}	
			
			System.out.println("Favor digitar qual termo da PA:");
			termo = input.nextInt();
			System.out.println(pa.termo(termo) + "\n");//impressao do termo da pa escolhido
			break;
		case 4: if(regulador != 2)
			{
				System.out.println("Favor criar uma sequência primeiro");
				casoUmDois(2);
				regulador = 4;
				break;
			}
			System.out.println("Favor digitar o número inicial da sequência.");
			termofibo = input.nextInt();
			System.out.println(fibo.termoFibo(termofibo) + "\n");//impressao do termo escolhido na sequencia
			break;
		}
	}
	
	//comentário
	//caso o usuario selecione a opcao 5 esse metodo eh ativado
	public static void casoCinco(int opcao) {
		switch (opcao) 
		{
		case 5: if (regulador == 3 || regulador == 1) { //caso o usuario ja tenha visto algum termo da pa ou criado uma ele pode entao ver a quantidade de termos
			System.out.println("Favor digitar a quantidade de termos da Progressao que deseja ver:");
			termo = input.nextInt();
			System.out.println(pa.geraTermos(termo)+ "\n"); //imprime os n termos da PA
			break;
			}
			if (regulador == 4 || regulador == 2) { //caso o usuario ja tenha visto algum termo da sequencia ou criado uma ele por entao ver a quantidade de termos
			System.out.println("Favor digitar a quantidade de termos da Sequencia que deseja ver:");
			termofibo = input.nextInt();
			System.out.println(fibo.geraTermosFibo(termofibo) + "\n"); //imprime os n termos da sequencia
			break;
			}
			if (regulador != 3 || regulador != 4 || regulador !=1 || regulador != 2) {// caso o usuario nao tenha criado uma pa ele eh redirecionado
			System.out.println("Você precisa criar uma progressao ou uma sequencia primeiro!\n");
			casoUmDois(opcao);
			break;
			}
		
		}
	}
	
	
}