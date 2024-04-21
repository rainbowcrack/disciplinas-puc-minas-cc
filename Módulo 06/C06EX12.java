import java.util.Scanner;
// atividade do modulo 06 - exercicio 12 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para calcular o custo das bolas produzidas ate a Copa
public class C06EX12 {
    public static void main(String[] args) {
        // input e chamar biblioteca
        int bolas, defeito, meses;
        double p_papelao, aluguel, caixas, custo;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para saber o custo total,\nInforme quantas bolas produzidas: ");
        bolas = teclado.nextInt();
        System.out.print("Dessas produzidas, informe quantas estao com defeito: ");
        defeito = teclado.nextInt();
        System.out.print("O preco unitario da caixa de papelao: R$");
        p_papelao = teclado.nextDouble();
        System.out.print("Valor mensal do aluguel: R$");
        aluguel = teclado.nextDouble();
        System.out.print("A quantidade de meses ate a Copa: ");
        meses = teclado.nextInt();
        // output e operacao
        bolas = bolas - defeito;
        aluguel = aluguel * meses;
        caixas = bolas;
        p_papelao = p_papelao * caixas;
        custo = aluguel + p_papelao;
        System.out.printf("Custo total = R$%1.2f", custo);
        teclado.close();
    }
}
