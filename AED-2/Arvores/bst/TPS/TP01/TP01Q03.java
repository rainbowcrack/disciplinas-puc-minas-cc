package TP01;
/************************************
* TP01Q03                           *
* CIFRA DE CESAR (JAVA) - ITERATIVO *
*************************************/

import java.util.Scanner;

// cifra de cesar com chave 3
public class TP01Q03{

        public static String cifraCesar(String nome, int chave){

                // declara variaveis
                char caractere;
                String resultado = "";

                // percorre o vetor String pegando char por char
                for(int i = 0; i < nome.length(); i++){

                        caractere = nome.charAt(i);

                        /*  base = Character.isUpperCase(caractere)? 'A' : 'a';
                        operacao circular e conversao para a chave
                        caractere = (char)((caractere - base + chave) % 26 + base); */
                        
                        // tabela ASCII, condicao de charset
                        if(caractere < 128){
                                caractere = (char)((caractere + chave));
                        } 

                        // cria um vetor de char (String) por acumulador
                        resultado += caractere;
                }

                return resultado;
        }

        public static void main(String[] args){

                Scanner teclado = new Scanner(System.in);

                String nome;

                // valor fixo, pode ser variavel
                int chave = 3;

                nome = teclado.nextLine();

                // while(!nome.equals("FIM"))
                // chama a funcao iterativa
                while(!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) != 'F')){
                    System.out.println(cifraCesar(nome, chave));
                    
                    nome = teclado.nextLine();
                }

                teclado.close();
        }
}
