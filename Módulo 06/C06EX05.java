import java.util.Scanner;
// atividade do modulo 06 - exercicio 05 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para se o numero e divisivel por 5 e por 7
public class C06EX05 {
    public static void main(String[] args) {
        // declarar e atribuir variaveis
        int num, resto;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para saber se e divisivel por 5 e 7,\nInforme um numero: ");
        num = teclado.nextInt();
        // operacao
        resto = (num % 5) + (num % 7); // 0 + 0 = 0 para o resto simultaneo
        if (resto == 0)
            System.out.print(num + " e divisivel simultaneamente por 5 e 7");
        else
            System.out.print(num + " nao e divisivel simultaneamente por 5 e 7");
        teclado.close();
    }
}
