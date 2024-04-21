import java.util.Scanner;
// atividade do modulo 07 - exercicio 03 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para calcular o valor da multa sobre o imposto e atrasos de dias
public class C07EX03 {
    public static void main(String[] args) {
        // input, biblioteca e variaveis
        int dias;
        double imposto, multa;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para calcular o valor da multa,\nInforme o imposto: R$");
        imposto = teclado.nextDouble();
        System.out.print("Os dias de atraso: ");
        dias = teclado.nextInt();
        // switch
        switch (dias) {
            case 1: case 2: case 3: case 4: case 5:
                System.out.print("\nMulta = R$0");
                break;
            case 6: case 7: case 8:
                multa = 0.02 * imposto;
                System.out.print("\nMulta = R$0");
                break;
            case 9: case 10:
                multa = (0.1 + (0.005 * dias)) * imposto;
                System.out.printf("\nMulta = R$%1.2f", multa);
                break;
            default:
                multa = (1.5 * imposto) + dias;
                System.out.printf("\nMulta = R$%1.2f", multa);
                break;            
        }
        teclado.close();
    }
}
