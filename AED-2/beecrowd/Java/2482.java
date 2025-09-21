// 2482 - Noel's labels

import java.util.Scanner;

public class Main
{
    // classes
    static class Natal{
        String pais, traducao;
    }
    static class Pessoa{
        String nome, idioma;
    }
    
	public static void main(String[] args) {
	    Scanner teclado = new Scanner(System.in);
	    
	    // Ler traducoes
	    int t = teclado.nextInt();
	    teclado.nextLine(); // buffer
	    Natal[] natal = new Natal[t];
	    
	    for(int i = 0; i < t; i++){
	        natal[i] = new Natal();
	        natal[i].pais = teclado.nextLine();
	        natal[i].traducao = teclado.nextLine();
	    }
	    
	    // ler criancas
	    int c = teclado.nextInt();
	    teclado.nextLine(); // buffer
	    Pessoa[] pessoa = new Pessoa[c];
		
		for(int i = 0; i < c; i++){
	        pessoa[i] = new Pessoa();
	        pessoa[i].nome = teclado.nextLine();
	        pessoa[i].idioma = teclado.nextLine();
	    }
	    
	    // compara e encontra igualdade
	    for(int i = 0; i < c; i++){
	        System.out.println(pessoa[i].nome);
	        
	        for(int j = 0; j < t; j++){
	            if(pessoa[i].idioma.equals(natal[j].pais)){
	                System.out.println(natal[j].traducao);
	            }
	        }
	    }
	    teclado.close();
	}
}
