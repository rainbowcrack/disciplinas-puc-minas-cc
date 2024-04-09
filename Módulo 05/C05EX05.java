import java.util.Scanner;
public class C05EX01 {
    public static void main(String[] args) {
        // declaracao de variaveis
        int x;
        double fx;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para a expressao f(x) = x^3 + 4x + 10, informe o valor de x: ");
        x = teclado.nextInt();
        fx = Math.pow(x,3) + (7*x) + 10;
        System.out.print("F(x) = " + fx);
        teclado.close();

    }

}
