package TP01;
/************************************
* TP01Q18                           *
* CIFRA DE CESAR (JAVA) - RECURIVO  *
************************************/

import java.util.Scanner;

public class TP01Q18{

        // metodo da cifra de cesar recursiva
        public static String cifraRecursiva(String nome, int chave, int j){

                char caractere;

                // caso base que transforma o vetor concatenado de char, em String
                if(j == nome.length()){
                        return "";
                }

                caractere = nome.charAt(j);

                // evita charset na base em ASCII
                if(caractere < 128) caractere = (char)(caractere + chave);
                
                // concatena os caracteres em cadeia e soma o indice da chamada recursiva
                return caractere + cifraRecursiva(nome, chave, j + 1);
        }

        public static void main(String[] args){

                Scanner teclado = new Scanner(System.in);

                String nome;
                int chave = 3;

                nome = teclado.nextLine();

                // chamda recursiva, comeca a chamada com 0 
                while(!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){
                   System.out.println(cifraRecursiva(nome, 3, 0)); 
                   
                   nome = teclado.nextLine();
                }
                
                teclado.close();
        }
}
