import java.util.Scanner;

// atividade do modulo 06 - exercicio 02 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para imprimir o valor da multa a partir da emissao de poluentes
public class C06EX02 {
    public static void main(String[] args){
        // declarar variaveis e atribuir
        double poluente, multa;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para o calculo do valor da multa,\nIndique a quantidade de poluentes emitidos [mg/(t*m^2)]: ");
        poluente = teclado.nextDouble();
        // operacao e condicional
        multa = poluente * 500;
        if (poluente <= 1500)
            System.out.print("Poluente = " + poluente + "\nMulta = R$0" );

        if (poluente > 1500 && poluente <= 3500)
            System.out.print("Poluente = " + poluente + "\nMulta = R$3000,00");

        if (poluente > 3500)
            System.out.printf("Poluente = " + poluente + "\nMulta = %.2f", multa);
        teclado.close();
    }
}
