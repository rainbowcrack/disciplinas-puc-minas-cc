import java.util.Scanner;
// atividade do modulo 09 - exercicio 01 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// problemas sobre series matematicas baseadas em modelos ja prontos e looping
public class C06EX02 {
    public static void main(String[] args){
        // declarar e atribuir variavel
        // declarar variaveis e atribuir
        double poluente, multa;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para o calculo do valor da multa,\nIndique a quantidade de poluentes emitidos [mg/(t*m^2)]: ");
        poluente = teclado.nextDouble();
        // operacao e condicional
        multa = poluente * 5000; // criar a atribuicao da multa fora da condicional
        if (poluente <= 1500)
            System.out.print("Poluente = " + poluente + "\nMulta = R$0" );

        if (poluente > 1500 && poluente <= 3500)
            System.out.print("Poluente = " + poluente + "\nMulta = R$3000,00");

        if (poluente > 3500)
            System.out.printf("Poluente = " + poluente + "\nMulta = %.2f", multa);
        teclado.close();
    }
}
