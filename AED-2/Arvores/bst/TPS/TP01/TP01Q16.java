package TP01;
/********************************
* TP01Q16                       *
* PALINDROMO (JAVA) - RECURSIVO *
********************************/

import java.util.Scanner;

public class TP01Q16{

	public static boolean palindromoRecursivo(String nome, int i, int j) {
        // caso base, se ja percorreu toda a string
        if (i >= j) {
            return true;
        }
        // se for diferente nao eh palindromo
        if (nome.charAt(i) != nome.charAt(j)) {
            return false;
        }
        // chamada recursiva para percorrer
        return palindromoRecursivo(nome, i + 1, j - 1);
    }

	 // funcao para passar os parametros para a funcao recursiva
	 public static boolean palindromoIndireto(String nome) {
        return palindromoRecursivo(nome, 0, nome.length() - 1);
    }

	// funcao principal lembra int main()
	public static void main(String[] args){
		
		String nome;

		// cria o objeto teclado da classe Scanner, chamando um construtor com new
		Scanner teclado = new Scanner(System.in);
		nome = teclado.nextLine();

		// chama a funcao e usa um operador ternario
		while(!nome.equals("FIM")){
			System.out.println(palindromoIndireto(nome)? "SIM" : "NAO");

			nome = teclado.nextLine();
		}
		teclado.close();
	}
}
