import java.util.Scanner;
// atividade do modulo 06 - exercicio 03 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// salario = 240 + comissao
public class C05EX01 {
    public static void main(String[] args){
        // definir variaveis e atribuir
        double vendas, comissao;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para calcular o seu salario,\nInsira o valor mensal das vendas: R$");
        vendas = teclado.nextDouble();
        // condicional
        comissao = 0.1 * vendas;
        if (vendas <= 1000)
            System.out.print("Salario = R$240,00 ");

        if (vendas >= 1000 && vendas <= 10000)
            System.out.print("Salario = " + vendas + comissao);

        else
            System.out.print("Salario =  " + vendas + 1000);
        teclado.close();

    }
}
