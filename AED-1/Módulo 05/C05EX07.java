import java.util.Scanner;

// atividade do modulo 05 - exercicio 07 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para a calcular a funcao dada
public class C05EX07 {
    public static void main(String[] args) {
        // declarar variaveis e atribuicao
        double x, fx;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para a função da raiz da soma de (x/4 + 1)^2 com (1/5 * x),\nInforme o valor de X: ");
        x = teclado.nextDouble();
        // operacao e output
        fx = Math.sqrt((Math.pow(x / 4 + 1, 2) + x * 0.2));
        System.out.print("\nF(x) = " + fx);
        teclado.close();
    }
}
