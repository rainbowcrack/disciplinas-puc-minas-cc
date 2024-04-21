import java.util.Scanner;
// atividade do modulo 06 - exercicio 12 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para calcular os custo de armazenagem e producao
public class C06EX12 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        // variaveis e biblioteca
        int bolas, defeito, meses, caixas;
        double p_papelao, aluguel, galpoes, custoTotal, custoEmbalagem, custoEstocagem;
        // input
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
        // Calculo embalagem, estocagem e total
        // Math.ceil converte o decimal para um inteiro proximo
        bolas -= defeito; // descontando as bolas com defeito na variavel bolas
        caixas = (int) Math.ceil((double) bolas / 10); // quantidade de caixas 
        custoEmbalagem = p_papelao * caixas; // custo da embalagem
        galpoes = Math.ceil((double) caixas / 850); // quantidade de galpoes 
        custoEstocagem = aluguel * galpoes * meses; // o custo de estocagem
        custoTotal = custoEmbalagem + custoEstocagem; // o custo total
        // output
        System.out.printf("\nCusto da embalagem: R$%.2f", custoEmbalagem);
        System.out.printf("\nCusto de estocagem: R$%.2f", custoEstocagem);
        System.out.printf("\nCusto total: R$%.2f", custoTotal);
        teclado.close();
    }
}
