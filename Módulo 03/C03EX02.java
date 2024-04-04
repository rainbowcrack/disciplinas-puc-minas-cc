import java.util.Scanner;
public class C03EX02 {
    // função: Calcula a média de 3 números inteiros
    // atividade do módulo 03 - exercício 02 por Izabel Oliveira da Paz Chaves (1º período de C.C)
    public static void main(String[] args) {
        long n1, n2, n3, soma;
        double media;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe um número: ");
        n1 = teclado.nextLong();
        System.out.print("Informe outro número: ");
        n2 = teclado.nextLong();
        System.out.print("Informe mais um número: "); 
        n3 = teclado.nextLong();
        soma = n1 + n2 + n3;
        media = soma / 3.0;
        System.out.println("Média = " + media);
        teclado.close(); 
    }
}
