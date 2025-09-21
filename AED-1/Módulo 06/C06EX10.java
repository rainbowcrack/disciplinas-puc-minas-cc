import java.util.Scanner;
// atividade do modulo 06 - exercicio 10 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para o valor o valor resgatado, o rendimento e o imposto
public class C06EX10 {
    public static void main(String[] args){
        // declarar e atribuir variaveis
        double capital, taxa_dia, valor, rendimento, imposto;
        int dias;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para calcular o valor resgatado,\nInforme o Numero de dias: ");
        dias = teclado.nextInt();
        System.out.print("Informe o Capital Aplicado: R$");
        capital = teclado.nextDouble();
        System.out.print("Informe a taxa diaria: %");
        taxa_dia = teclado.nextDouble();
        // operacao
        taxa_dia = taxa_dia/100; // taxa diaria convertida para porcentagem
        rendimento = capital * taxa_dia * dias; // calculo do rendimento
        imposto = 0.15 * rendimento; // calculo do imposto de renda
        valor = capital + rendimento - imposto - 10; // calculo do valor resgatado
        // output
        System.out.printf("\nValor resgatado: R$%1.2f", valor);
        System.out.printf("\nRendimento: R$%1.2f", rendimento);
        System.out.printf("\nImposto de renda: R$%1.2f", imposto);
        teclado.close();
    }
}
