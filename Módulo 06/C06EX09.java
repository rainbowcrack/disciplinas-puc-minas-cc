import java.util.Scanner;
// atividade do modulo 06 - exercicio 09 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para calcular o peso ideal a partir da altura dos sexos
public class C06EX09 {
    public static void main(String[] args) {
        String sexo;
        double altura, peso1, peso2;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para calcular o peso ideal,\nInforme se seu sexo e F ou M: ");
        sexo = teclado.nextLine();
        System.out.print("Informe a sua altura em metros: ");
        altura = teclado.nextDouble();
        // operacao
        peso1 = 62.1 * altura - 44.7;
        peso2 = 72.7 * altura - 58;
        // condicional
        if (sexo.equals("F")) { // .equals para comparar string ao inves de ==
            System.out.printf("Peso ideal = %1.3f", peso1);
        } else if (sexo.equals("M")) {
            System.out.printf("Peso ideal = %1.3f", peso2);
        } else {
            System.out.print("Digite corretamente o sexo, seja ele F ou M.");
        }
        teclado.close(); // fechar o teclado fora da condicional
    }
}
