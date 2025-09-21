import java.util.Scanner;

// atividade do modulo 05 - exercicio 08 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para achar o raio a partir da area do setor circular
public class C05EX08 {
    public static void main(String[] args) {
        // declarar variaveis e atribuicao
        double s, raio, angulo;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para achar o Raio a partir da Area do Setor Circular (S), informe o \nvalor do S: ");
        s = teclado.nextDouble();
        System.out.print("Valor do Angulo: ");
        angulo = teclado.nextDouble();
        // operacao e output
        raio = Math.sqrt((360 * s) / (angulo * 3.1416));
        System.out.print("\nValor do Raio: " + raio);
        teclado.close();
    }
}
