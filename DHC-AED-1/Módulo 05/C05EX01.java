import java.util.Scanner;
// atividade do modulo 05 - exercicio 01 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa de funcao de 3 grau quando o 2 termo eh zero, x dado pelo user
public class C05EX01 {
    public static void main(String[] args) {
        // declaracao de variaveis
        double x, fx;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para a expressao f(x) = x^3 + 4x + 10, informe o valor de x: ");
        x = teclado.nextDouble();
        // operacao e ouput
        // mudar x*x*x por Math.pow() no INTELIJI
        fx = Math.pow(x,3) + (4 * x) + 10;
        System.out.printf("F(x) = %1.0f" + fx);
        teclado.close();
    }
}
