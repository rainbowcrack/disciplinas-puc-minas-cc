package TP01;
/************************
* TP01Q20               *
* IS (JAVA) - RECURSIVO *
************************/
import java.util.Scanner;

public class TP01Q20{

    // metodo recursivo para SOMENTE vogais
    public static boolean temVogal(String nome, int index) {
        if (index == nome.length()) return true; // caso base, final

        String vogais = "aeiouAEIOU";
        char valor1 = nome.charAt(index);
        boolean ehVogal = false;

        for (int j = 0; j < vogais.length(); j++) {
            if (valor1 == vogais.charAt(j)) {
                ehVogal = true;
            }
        }

        if (!ehVogal) return false; 

        return temVogal(nome, index + 1); // chama recursivamente para o proximo caractere
    }

    // metodo recursivo para SOMENTE consoantes
    public static boolean temConsoante(String nome, int index) {
        if (index == nome.length()) return true; // caso base chegou no final
        char caractere = nome.charAt(index);

        if ((caractere >= 'a' && caractere <= 'z') || (caractere >= 'A' && caractere <= 'Z')) {
            if (temVogal("" + caractere, 0)) return false; // se nao for vogal
        } else {
            return false; // se nao for letra
        }
        return temConsoante(nome, index + 1); // chama recursivamente para o proximo caractere
    }

    // metodo recursivo SOMENTE numeros inteiros
    public static boolean numeroInteiro(String nome, int index) {
        if (index == nome.length()) return true; // caso base 

        char caractere = nome.charAt(index);

        if (caractere < '0' || caractere > '9') return false; // senao for numero

        return numeroInteiro(nome, index + 1); // chama recursivamente para o proximo caractere
    }

    // metodo recursivo SOMENTE um numero real
    public static boolean numeroReal(String nome, int index, boolean temPonto, boolean temNumero) {
        if (index == nome.length()) return temNumero && temPonto; // caso base chegou no final

        char caractere = nome.charAt(index);

        if (caractere >= '0' && caractere <= '9') {
            temNumero = true;
        } else if (caractere == '.') {
            if (temPonto) return false; // se ja tiver ponto
            temPonto = true;
        } else {
            return false; // se for diferente
        }

        return numeroReal(nome, index + 1, temPonto, temNumero); // chama recursivamente para o proximo caractere
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nome;

        nome = teclado.nextLine();

        // condicao de parada com flag "FIM"
        while (!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')) {

            // chamar funcoes recursivas
            System.out.print(temVogal(nome, 0) ? "SIM " : "NAO ");
            System.out.print(temConsoante(nome, 0) ? "SIM " : "NAO ");
            System.out.print(numeroInteiro(nome, 0) ? "SIM " : "NAO ");
            System.out.println(numeroReal(nome, 0, false, false) ? "SIM" : "NAO");

            nome = teclado.nextLine();
        }

        teclado.close();
    }
}
