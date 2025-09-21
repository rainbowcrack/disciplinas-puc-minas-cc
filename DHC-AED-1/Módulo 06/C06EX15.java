import java.util.Scanner;

// atividade do modulo 06 - exercicio 15 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para calcular a TV a cabo pela cidade do user
public class C06EX15 {
    public static void main(String[] args) {
        // input e chamar biblioteca
        String cidade;
        int codigo, dias;
        double extra, conta1, conta2, conta3;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para saber a sua conta da TV a cabo,\nInforme o nome da sua cidade: ");
        cidade = teclado.nextLine();
        System.out.print("O codigo do seu pacote: ");
        codigo = teclado.nextInt();
        System.out.print("A quantida de dias de consumo dos canais: ");
        dias = teclado.nextInt();
        System.out.print("O valor de servicos extras: R$");
        extra = teclado.nextDouble();
        // operacao sem imposto sobre a cidade
        conta1 = 65 + (1.20 * dias) + extra;
        conta2 = 104 + (2.10 * dias) + extra;
        conta3 = 137 + extra;
        // condicional para cidades
        if (cidade.equals("Belo Horizonte")) {
            if (codigo == 1)
                System.out.printf("\nValor: R$%.2f", conta1);
            else if (codigo == 2)
                System.out.printf("\nValor: R$%.2f", conta2);
            else if (codigo == 3)
                System.out.printf("\nValor: R$%1.2f", conta3);
        } else if (cidade.equals("Sao paulo")) {
            if (codigo == 1)
                System.out.printf("\nValor: R$%.2f", (conta1 * 1.01)); // valor sobre o imposto da cidade
            else if (codigo == 2)
                System.out.printf("\nValor: R$%.2f", (conta2 * 1.01));
            else if (codigo == 3)
                System.out.printf("\nValor: R$%.2f", (conta3 * 1.01));
        } else if (cidade.equals("Rio de janeiro")) {
            if (codigo == 1)
                System.out.printf("\nValor: R$%.2f", (conta1 * 1.015)); // valor sobre o imposto da cidade
            else if (codigo == 2)
                System.out.printf("\nValor: R$%.2f", (conta2 * 1.015));
            else if (codigo == 3)
                System.out.printf("\nValor: R$%.2f", (conta3 * 1.015));
        } else {
            if (codigo == 1)
                System.out.printf("\nValor: R$%.2f", (conta1 * 1.02)); // valor sobre o imposto da cidade
            else if (codigo == 2)
                System.out.printf("\nValor: R$%.2f", (conta2 * 1.02));
            else if (codigo == 3)
                System.out.printf("\nValor: R$%.2f", (conta3 * 1.02));
        }
        teclado.close();
    }
}
