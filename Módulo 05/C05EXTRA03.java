import java.util.Scanner;

// atividade do modulo 05 - exercicio extra 03 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
public class C05EXTRA03 {
    public static void main(String[] args){
        // atribuir e declarar variaveis
        int producao, perda, c_madeira, c_papelao, n_caixas, embalados;
        double p_papelao, p_madeira, frete, custo;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para o calculo do custo total,\nInforme o valor da producao: ");
        producao = teclado.nextInt();
        System.out.print("O valor da perda da producao: ");
        perda = teclado.nextInt();
        System.out.print("O preco unitario da caixa de papelao: R$");
        p_papelao = teclado.nextDouble();
        System.out.print("O preco unitario da caixa de madeira: R$");
        p_madeira = teclado.nextDouble();
        System.out.print("O valor do frete: R$");
        frete = teclado.nextDouble();
        // operacao e output
        embalados = producao - perda;
        c_madeira = ((embalados/50)/15);
        c_papelao = ((embalados/50)/15)/7;
        custo = (c_madeira * p_madeira) + (c_papelao * p_papelao) + frete;
        System.out.printf("R$%1.2f", custo);
        teclado.close();
    }
}
