package TP01;
import java.util.Random;
import java.util.Scanner;

public class Main{

        // metodo para trocar dois char aleaotorios em uma string
        public static String alteracaoAleatoria(String nome, char letra1, char letra2){

                // concatenar char, para virar String
                String resultado = "";

                // troca
                for(int i = 0; i < nome.length(); i++){

                        if(nome.charAt(i) == letra1){

                                resultado += letra2;
                        } else{

                                resultado += nome.charAt(i);
                        }
                }

                return resultado;

        }

        public static void main(String[] args){
            
                // objeto instanciado para pegar um char aleatorio
                Random gerador = new Random();
                gerador.setSeed(4);

                // char aleatorio, garante estrutura circular
                char letra1 = (char)('a' + (Math.abs(gerador.nextInt())%26));
                char letra2 = (char)('a' + (Math.abs(gerador.nextInt())%26));

                Scanner teclado = new Scanner(System.in);

                String nome = teclado.nextLine();

                // condicao de parada
                while(nome.charAt(0) != 'F' && nome.charAt(1) != 'I' && nome.charAt(2) != 'M'){

                        System.out.println(alteracaoAleatoria(nome, letra1, letra2));

                        nome = teclado.nextLine();
                }

        }
}
