import java.util.Scanner;

// atividade do modulo 05 - exercicio extra 01 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para saber se o numero eh palindromo
public class C05EXTRA01 {
    public static void main(String[] args) {
        // declarar e atribuir variaveis
        int numero, n1, n2, n3, n4;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para saber se existe um palindromo," + "\nDigite um numero de 4 digitos: ");
        numero = teclado.nextInt();
        n1 = numero / 1000;
        n2 = numero / 100 % 10;
        n3 = numero / 10 % 10;
        n4 = numero % 10;
        // logica e output 
        // condicional aprendida no conteudo 06
        if (n1 == n4) {
            if (n2 == n3) {
                System.out.print("O numero " + numero + " e um palindromo.");
            }
            else {
                System.out.print("O numero " + numero + " nao e um palindromo.");
            }
        }
        else {
            System.out.print("O numero " + numero + " nao e um palindromo.");
        }
        teclado.close();
    }
}
