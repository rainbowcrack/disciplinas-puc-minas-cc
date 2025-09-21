import java.util.Scanner;

// atividade do modulo 06 - exercicio 03 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para calcular o salario a partir de: salario = 240 + comissao
public class C06EX03 {
    public static void main(String[] args) {
        // definir variaveis e atribuir
        double vendas;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para calcular o seu salario,\nInsira o valor mensal das vendas: R$");
        vendas = teclado.nextDouble();
        // condicional
        if (vendas <= 1000)
            System.out.print("Salario = R$240,00 "); // valor fixo

        else if (vendas >= 1000 && vendas <= 10000)
            System.out.printf("Salario = R$%1.2f", (240 + vendas * 0.1)); // valor variavel e formatado

        else
            System.out.print("Salario = R$1240,00"); // valor fixo
        teclado.close();

    }
}
