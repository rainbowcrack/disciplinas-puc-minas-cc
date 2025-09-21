package TP01;
/*****************************************
* TP01Q10                                *
*CONTAGEM DE PALAVRAS (JAVA) - ITERATIVO *
******************************************/

import java.util.Scanner;

public class TP01Q10{

        // metodo para contar palavras em uma frase
        public static int contarPalavras(String nome){
                int resultado = 0;
                char caractere;
                boolean palavra = false; // flag de contagem

                for(int i = 0; i < nome.length(); i++){

                        caractere = nome.charAt(i);

                        // condicao de Espaco em ASCII
                        if(caractere == 32){
                                palavra = false;
                        }else{

                                // operador unitario, contagem de palavras
                                if(!palavra){
                                        resultado++;
                                        palavra = true;
                                }
                        }
                }

                return resultado;
        }

        public static void main(String[] args){

                Scanner teclado = new Scanner(System.in);
                String nome;

                nome = teclado.nextLine();

                // condicao de parada com "FIM"
                while(!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){

                        // chama a funcao
                        System.out.println(contarPalavras(nome));

                        nome = teclado.nextLine();
                }

                teclado.close();
        }
}
