import java.util.Scanner;

// atividade do modulo 05 - exercicio 05 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para conversao de temperatura
public class C05EX05 {
    public static void main(String[] args) {
        // declarar variaveis e atribuicao
        double celsius, kelvin, fahrenheit;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe o valor da temperatura em Celsius: ");
        celsius = teclado.nextDouble();
        // operacao e output
        kelvin = celsius + 273;
        fahrenheit = (9 * celsius + 160) / 5;
        System.out.print(
                "\nCelsius: " + celsius + "C" + "\nKelvin: " + kelvin + "K" + "\nFahrenheit: " + fahrenheit + "F");
        teclado.close();
    }
}
