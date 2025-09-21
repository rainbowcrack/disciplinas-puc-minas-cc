import java.util.Scanner;

// atividade do modulo 05 - exercicio 04 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa de geometria analitica
public class C05EX04 {
    public static void main(String[] args) {
        // declarar variaveis e atribuir
        Scanner teclado = new Scanner(System.in);
        double x1, x2, y1, y2, distancia;
        System.out.print("Para um problema de Geometria Analitica, informe os pontos cartesianos\nX1: ");
        x1 = teclado.nextDouble();
        System.out.print("Y1: ");
        y1 = teclado.nextDouble();
        System.out.print("X2: ");
        x2 = teclado.nextDouble();
        System.out.print("Y2: ");
        y2 = teclado.nextDouble();
        // operacao e output
        distancia = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        System.out.print("\nDistancia: " + distancia);
        teclado.close();
    }
}
