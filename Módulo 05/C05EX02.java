import java.util.Scanner;
// atividade do modulo 05 - exercicio 02 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa que imprime a area e o volume de uma superficie esferica dado o valor de r pelo user
public class C05EX02 {
    public static void main(String[] args) {
        double r, area, volume;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe um valor do raio para calcular o area e o volume de uma superficie esferica: ");
        r = teclado.nextDouble();
        // operacao
        area = Math.pow(r, 2) * (Math.PI) * (4);
        volume = Math.pow(r, 3) * (Math.PI) * 4 / 3;
        System.out.print("\nArea: " + area + "\nVolume: " + volume);
        teclado.close();
    }
}
