import java.util.Scanner;
// atividade do modulo 08 - exercicio 02 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para imprimir se os 50 alunos foram aprovados ou nao com loop for
public class C08EX02 {
    public static void main(String[] args) {
        // variaveis e biblioteca
        double nota;
        int faltas;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para calcular se os alunos foram ou nao aprovados,");
        // for para repeticao
        for (int aux = 1; aux <= 50; aux++) {
            System.out.print("\nInforme a nota do aluno " + aux + ": ");
            nota = teclado.nextDouble();
            System.out.print("Quantidade de faltas: ");
            faltas = teclado.nextInt();
            if (nota >= 65 && faltas <= 16){ // condicao para a aprovacao
                System.out.print("Aluno aprovado.");
            } else {
                System.out.print("Aluno reprovado."); // condicao para reprovado
            }
        }
        teclado.close();
    }
}
