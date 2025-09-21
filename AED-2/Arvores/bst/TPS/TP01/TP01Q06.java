package TP01;
/************************
* TP01Q06               *
* IS (JAVA) - ITERATIVO *
************************/
import java.util.Scanner;

public class TP01Q06{

    // metodo para verificar se tem SOMENTE vogais
    public static boolean temVogal(String nome) {
        String vogais = "aeiouAEIOU";

	// comparacao de vetores
        for (int i = 0; i < nome.length(); i++) {
            char valor1 = nome.charAt(i);
            boolean ehVogal = false;

            for (int j = 0; j < vogais.length(); j++) {
                if (valor1 == vogais.charAt(j)) {
                    ehVogal = true;
                    break;
                }
            }

            if (!ehVogal) return false; // se nao for vogal eh falso
        }

        return nome.length() > 0;
    }

    // metodo para verificar se tem SOMENTE consoantes
    public static boolean temConsoante(String nome) {
        for (int i = 0; i < nome.length(); i++) {
            char caractere = nome.charAt(i);

            if ((caractere >= 'a' && caractere <= 'z') || (caractere >= 'A' && caractere <= 'Z')) {
                if (temVogal("" + caractere)) return false; // se for vogal, nao eh so consoante
            } else {
                return false;
            }
        }

        return nome.length() > 0;
    }

    // metodo para verificar se tem SOMENTE numeros inteiros
    public static boolean numeroInteiro(String nome) {
        if (nome.length() == 0) return false;

        for (int i = 0; i < nome.length(); i++) {
            char caractere = nome.charAt(i);
		
            if (caractere < '0' || caractere > '9') return false; // se nao for um numero
        }

        return true;
    }

    // metodo para verificar se tem SOMENTE um numero float
    public static boolean numeroReal(String nome) {
        if (nome.length() == 0) return false;

        boolean temPonto = false, temNumero = false;

        for (int i = 0; i < nome.length(); i++) {
            char caractere = nome.charAt(i);

	    // confere se eh um numero
            if (caractere >= '0' && caractere <= '9') {
                temNumero = true;
		    
            } else if (caractere == '.') { // float so pode ter 1 ponto
                if (temPonto) return false; 
                temPonto = true;
		    
            } else {
                return false; // se for outro caso, retorna invalido
            }
        }

        return temNumero && temPonto; // dve numero e um ponto
    }

	public static void main(String[] args){
	
		Scanner teclado = new Scanner(System.in);

		String nome;

		nome = teclado.nextLine();

		// condicao de para com flag "FIM"
		while(!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){
		
			// chamar funcoes
			System.out.print(temVogal(nome)? "SIM " : "NAO ");
			System.out.print(temConsoante(nome)? "SIM " : "NAO ");
			System.out.print(numeroInteiro(nome)? "SIM " : "NAO ");
			System.out.println(numeroReal(nome)? "SIM" : "NAO");

			nome = teclado.nextLine();
		}

		teclado.close();
	}
}
