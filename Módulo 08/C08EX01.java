import java.util.Scanner;
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
                System.out.println("Raio invalido, insira outro.");
                break;
            }
        }
        teclado.close();
    }
}
