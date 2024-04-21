import java.util.Scanner;
// atividade do modulo 06 - exercicio 16 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para saber o resultado final do aluno
public class C06EX16 {
    public static void main(String[] args) {
        // input, variaveis e biblioteca
        int falta, idade, pesof = 0, pesoi = 0;
        double media, nota1, nota2, nota3, soma = 0, trabalho;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para calcular a nota final,\nInforme a quantidade de faltas: ");
        falta = teclado.nextInt();
        System.out.print("E a idade do aluno: ");
        idade = teclado.nextInt();
        System.out.print("A nota da 1 prova: ");
        nota1 = teclado.nextDouble();
        System.out.print("A nota da 2 prova: ");
        nota2 = teclado.nextDouble();
        System.out.print("A nota da 3 prova: ");
        nota3 = teclado.nextDouble();
        System.out.print("E a nota do trabalho: ");
        trabalho = teclado.nextDouble();
        // condicional para falta
        if (falta <= 5)
            pesof = 3;
        else if (falta > 5 && falta <= 10)
            pesof = 2;
        else if (falta > 10)
            pesof = 1;
        // condicional para idade
        if (idade <= 17)
            pesoi = 1;
        else if (idade > 17 && idade <= 50)
            pesoi = 2;
        else if (idade > 50)
            pesoi = 3;
        // condicional para duas maiores notas
        if ((nota1 >= nota2 && nota2 > nota3) || (nota2 >= nota1 && nota1 > nota3))
            soma = nota1 + nota2;
        else if ((nota3 >= nota1 && nota1 > nota2) || (nota1 >= nota3 && nota3 > nota1))
            soma = nota3 + nota1;
        else if ((nota3 >= nota2 && nota2 > nota1) || (nota2 >= nota3 && nota3 > nota2))
            soma = nota3 + nota1;
        // operacao para media
        media = ((soma * pesof) + (trabalho * pesoi)) / 2;
        // condicional para o resultado final
        if (media <= 50)
            System.out.print("\nResultado = Reprovado.");
        else if (media > 50 && media <= 70)
            System.out.print("\nResultado = Regular.");
        else if (media > 70 && media <= 80)
            System.out.print("\nResultado = Bom.");
        else if (media > 80 && media <= 90)
            System.out.print("\nResultado = Muito Bom.");
        else if (media > 90)
            System.out.print("\nResultado = Excelente.");
        teclado.close();
    }
}
