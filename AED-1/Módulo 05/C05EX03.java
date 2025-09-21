import java.util.Scanner;

// atividade do modulo 05 - exercicio 03 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa que imprime o valor do imposto de renda
public class C05EX03 {
    public static void main(String[] args) {
        // declarar variaveis e chamar a biblioteca
        double salario, dependentes, imposto, liquido;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe o valor do seu salario: R$");
        salario = teclado.nextDouble();
        System.out.print("E o numero de dependentes: ");
        dependentes = teclado.nextDouble();
        // operacao e output
        liquido = salario - (dependentes * 60);
        imposto = 0.15 * liquido;
        System.out.printf("\nSeu imposto de renda: R$%1.2f", imposto);
        teclado.close();
    }
}
