import java.util.Scanner;

// atividade do modulo 05 - exercicio 06 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para a distancia do ponto P e uma reta R - geometria analitica
public class C05EX06 {
    public static void main(String[] args) {
        // declaracao de variaveis e atribuicao
        double a, b, c, x, y, r, distancia;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para o problema entre a distancia do ponto P e da reta R,\nValor de A: ");
        a = teclado.nextDouble();
        System.out.print("Valor de B: ");
        b = teclado.nextDouble();
        System.out.print("Valor de C: ");
        c = teclado.nextDouble();
        System.out.print("Valor de X: ");
        x = teclado.nextDouble();
        System.out.print("Valor de Y: ");
        y = teclado.nextDouble();
        // operacao e output
        r = a * x + b * y + c;
        distancia = r / Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.print("\nDistancia: " + distancia);
        teclado.close();
    }
}
