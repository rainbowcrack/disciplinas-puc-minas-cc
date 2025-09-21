package TP01;
/*************************************
* TP01Q08                            *
* SOMA DE DIGITOS (JAVA) - RECURSIVO *
*************************************/

import java.util.Scanner;

public class TP01Q08{

	// funcao que soma numeros recursivamente
	public static int somaRecursiva(int num){
	
		// caso base
		if(num == 0){
		
			return 0;
		}else{
		
			return (num % 10) + somaRecursiva(num / 10);

			/* pega o num pelo mod
        		pula para o proximo na divisao por 10
       			 a recursao sera um acumulador
        		*/
		}
	}

    public static int converterString(String entrada){
        int resultado = 0;
        for(int i = 0; i < entrada.length(); i++){

			// armazena o conteudo dos char pelo index
            char caractere = entrada.charAt(i);

			/* incrementa os int multiplicando por 10, pulando
			caractere - '0' eh uma conversao de ASCII */
            resultado = resultado * 10 + (caractere - '0');
        }
        return resultado;   
    }
	public static void main(String[] args){

		Scanner teclado = new Scanner(System.in);

        String entrada = teclado.nextLine();

		while(!(entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M')){
		
			// converte e chama a funcao
            int num = converterString(entrada);
			System.out.println(somaRecursiva(num));

            entrada = teclado.nextLine();
		}
	}
}
