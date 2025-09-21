package TP01;
/*********************************************
* TP01Q09                                    *
* VERIFICACAO DE ANAGRAMA (JAVA) - ITERATIVO *
**********************************************/
import java.util.Scanner;

public class TP01Q09{

    // metodo para verificar se eh um anagrama
    public static boolean ehAnagrama(String nome1, String nome2){
        // converte manualmente as letras maiusculas para minusculas
        nome1 = converterParaMinusculo(nome1);
        nome2 = converterParaMinusculo(nome2);

        boolean temAnagrama = false;

        // comparacao de string1 com string2 para ver se eh anagrama
        if(nome1.length() == nome2.length()){
            for(int i = 0; i < nome1.length(); i++){
                char caractere1 = nome1.charAt(i);

                for(int j = 0; j < nome2.length(); j++){
                    if(caractere1 == nome2.charAt(j)){
                        temAnagrama = true;
                    }
                }
            }
        }
        return temAnagrama;
    }

    // metodo para converter uma string em minusculo
    public static String converterParaMinusculo(String texto){
        String c = "";  

        for(int i = 0; i < texto.length(); i++){
            char charAtual = texto.charAt(i);
            // verifica se a letra eh maiscula
            if(charAtual >= 'A' && charAtual <= 'Z'){
                charAtual = (char)(charAtual + 32);  // subtrai a diferenca em ASCII
            }
            c += charAtual;  // a letra sera acumulada para virar string
        }

        return c; 
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nome1, nome2;

        nome1 = teclado.next();
        teclado.next(); // pula o tracado
        nome2 = teclado.next();

        // condicao de parada com FLAG "FIM"
        while(!(nome1.length() == 3 && nome1.charAt(0) == 'F' && nome1.charAt(1) == 'I' && nome1.charAt(2) == 'M')){
            System.out.println(ehAnagrama(nome1, nome2) ? "SIM" : "NÃO");

            nome1 = teclado.next();
            teclado.next();
            nome2 = teclado.next();
        }
        teclado.close();
    }
}
