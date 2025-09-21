/*
* ALIEN VOWELS (2150)
*/

import java.util.Scanner;
public class 2150
{
    // funcao para comparar vogais
    public static int alien(String vogais, String frase){
        int count = 0; // contador
        // frase
        for(int i = 0; i < frase.length(); i++){
            char letra = frase.charAt(i);
            // vetor que de vogaus
            for(int j = 0; j < vogais.length(); j++){
                if(letra == vogais.charAt(j)) count++;
            }
        }
        return count; 
    }
    
	public static void main(String[] args) {
	    Scanner teclado = new Scanner(System.in);
	    // declara dois vetores
		String vogais, frase;
		
		// condicao de I/O
		while(teclado.hasNext()){
		    // leitura do vetor
		    vogais = teclado.nextLine();
		    frase = teclado.nextLine();
		    
		    System.out.println(alien(vogais, frase));
		}
		teclado.close();
	}
}
