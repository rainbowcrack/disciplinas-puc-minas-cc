import java.util.Scanner;
// atividade do módulo 04 - exercício 05 por Izabel Oliveira da Paz Chaves (1º período de C.C)
// programa de funcao de 3 grau quando o 2 termo eh zero, x dado pelo user
public class C05EX01 {
    public static void main(String[] args) {
        // declaracao de variaveis
        int x, fx;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para a expressao f(x) = x^3 + 4x + 10, informe o valor de um x inteiro: ");
        x = teclado.nextInt();
        // operacao e ouput
        // mudar x*x*x por Math.pow() no INTELIJI
        fx = (x * x * x) + (4 * x) + 10;
        System.out.print("F(x) = " + fx);
        teclado.close();
    }
}
