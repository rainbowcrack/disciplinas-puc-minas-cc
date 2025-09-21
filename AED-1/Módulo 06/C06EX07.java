import java.util.Scanner;
// atividade do modulo 06 - exercicio 07 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para o PL liquido a partir do salario do funcionario
public class C06EX07 {
    public static void main(String[] args) {
        // declarar e atribuir variaveis
        double salario, pl_bruto, imposto, pl_liquido;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para saber a participacao nos lucros,\nInsira o salario de um empregado: R$");
        salario = teclado.nextDouble();
        // operacao e condicional
        if (salario <= 300) {
            pl_bruto = 500 + 0.7 * salario;
            imposto = 0.25 * pl_bruto;
            pl_liquido = pl_bruto - imposto;
            System.out.printf("PL Liquido = R$%1.2f", pl_liquido);
        } else if (salario > 300 && salario <= 1000) {
            pl_bruto = 200 + 0.5 * salario;
            imposto = 0.25 * pl_bruto;
            pl_liquido = pl_bruto - imposto;
            System.out.printf("PL Liquido = R$%1.2f", pl_liquido);
        } else {
            pl_bruto = 0.3 * salario;
            imposto = 0.25 * pl_bruto;
            pl_liquido = pl_bruto - imposto;
            System.out.printf("PL Liquido = R$%1.2f", pl_liquido);
        }
        teclado.close(); // fechar o teclado fora da condicional
    }
}
