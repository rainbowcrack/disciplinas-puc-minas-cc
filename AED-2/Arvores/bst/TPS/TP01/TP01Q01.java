package TP01;
/********************************
* TP01Q01                       *
* PALINDROMO (JAVA) - ITERATIVO *
********************************/

import java.util.Scanner;

public class TP01Q01{

        // funcao para verificar palindromo
        public static boolean verificaPalindromo(String nome){

                boolean palindromo = true;
                int i = 0, j = nome.length() - 1;

                while(palindromo && i < j){

                        // seleciona o caractere da String
                        if(nome.charAt(i) != nome.charAt(j)) palindromo = false;
                        i++; j--;
                }

                return palindromo;
        }

        // funcao principal lembra int main()
        public static void main(String[] args){

                String nome;

                // cria o objeto teclado da classe Scanner, chamando um construtor com new
                Scanner teclado = new Scanner(System.in);
                nome = teclado.nextLine();

                // chama a funcao e usa um operador ternario
                // while(!nome.equals("FIM"))
                while(!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){
                        System.out.println(verificaPalindromo(nome)? "SIM" : "NAO");

                    // limpa o buffer e pula 1 linha
                        nome = teclado.nextLine();
                }
                teclado.close();
        }
}
