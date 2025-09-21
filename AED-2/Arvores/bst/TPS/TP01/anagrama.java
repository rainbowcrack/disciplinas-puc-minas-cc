package TP01;
/******************************
* TP01Q09                     *
* ANAGRAMA (JAVA) - ITERATIVO *
******************************/

import java.util.Scanner;

public class anagrama{

    // metodo para verificar se eh um anagrama
    public static boolean ehAnagrama(String nome1, String nome2) {
        // converte manualmente as letras maiusculas para minusculas
        nome1 = converterParaMinusculo(nome1);
        nome2 = converterParaMinusculo(nome2);

        // verifica se os tamanhos sao diferentes
        if (nome1.length() != nome2.length()) {
            return false;
        }

        // poderia criar dois "for" ou com while
        for (int i = 0; i < nome1.length(); i++) {
            char caractere1 = nome1.charAt(i);
            boolean encontrou = false;

            int j = 0;
            while (j < nome2.length() && !encontrou) {
                if (caractere1 == nome2.charAt(j)) {
                    encontrou = true;
                }
                j++;
            }

            // return eh mais rapido e reduz o numero de comparacoes no Verde
            if (!encontrou) {
                return false;
            }
        }
        return true;
    }

    // metodo para converter uma string em minusculo
    // substitui o .tolower()
    public static String converterParaMinusculo(String texto) {
        String c = "";

        for (int i = 0; i < texto.length(); i++) {
            char charAtual = texto.charAt(i);
            // verifica se eh maiuscula e transforma
            if (charAtual >= 'A' && charAtual <= 'Z') {
                charAtual = (char) (charAtual + 32); // soma de acordo com ASCII
            }
            c += charAtual; // atua como um acumulador de char para string
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nome1 = "", nome2 = "";
        boolean lendoPrimeiroNome = true;

        // le  a linha e faz um .split() manual
        String linha = teclado.nextLine();

        // condicao de parada com FLAG "FIM"
        while (!(linha.length() == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M')) {

            nome1 = "";
            nome2 = "";
            lendoPrimeiroNome = true;

            // percorre a linha
            for (int i = 0; i < linha.length(); i++) {
                char caractere = linha.charAt(i);

                if (caractere == '-') {
                    lendoPrimeiroNome = false; // quando encontra o traço, comeca a ler o segundo nome
                } else if (caractere != ' ') { // ignora espacos
                    if (lendoPrimeiroNome) {
                        nome1 += caractere; // separa as duas entradas na linha e faz acumulador
                    } else {
                        nome2 += caractere;
                    }
                }
            }

            /* o Verde nao aceita esse tipo de leitura, da timeout
            nome1 = teclado.next();
            teclado.next();
            nome2 = teclado.next();
            */

            // operador primario chamando a funcao
            System.out.println(ehAnagrama(nome1, nome2) ? "SIM" : "NÃO");

            linha = teclado.nextLine(); // le a proxima linha
        }

        teclado.close();
    }
}
