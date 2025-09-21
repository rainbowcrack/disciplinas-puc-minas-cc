import java.util.Scanner;

// atividade do modulo 05 - exercicio 09 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para calcular a media 
public class C05EX09 {
    public static void main(String[] args) {
        // declarar variaveis e atribuicao
        double nota1, nota2, nota3, media;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para a media ponderada com os pesos 2, 3, 5, respectivamente. Insira,\nNota 1: ");
        nota1 = teclado.nextDouble();
        System.out.print("Nota 2: ");
        nota2 = teclado.nextDouble();
        System.out.print("Nota 3: ");
        nota3 = teclado.nextDouble();
        // operacao e output
        media = (nota1 * 2 + nota2 * 3 + nota3 * 5) / 10;
        System.out.print("\nA media ponderada é " + media);
        teclado.close();
    }
}
