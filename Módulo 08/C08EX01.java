import java.util.Scanner;
// atividade do modulo 08 - exercicio 01 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para imprimir os valores de 10 areas de circulos, a partir dos raios, pelo loop for
public class C08EX01 {
    public static void main(String[] args) {
        // variaveis e biblioteca
        double raio, area;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para calcular a area de circulos,");
        // for para repeticao
        for (int aux = 1; aux <= 10; aux++) {
            System.out.print("\nInforme valores para o raio: ");
            raio = teclado.nextDouble();
            if (raio > 0){
                area = 3.1416 * Math.pow(raio,2);
                System.out.print("Area = " + area);
            } else {
                System.out.print("Raio invalido, insira outro."); // Sem area para valores negativos e zero 
                break;
            }
        }
        teclado.close();
    }
}
