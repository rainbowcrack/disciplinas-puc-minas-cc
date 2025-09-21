import java.util.Scanner;
public class C03EX05 {
    public static void main(String[] args) {
        // atividade do modulo 03 - exercicio 05 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
        // programa que calcula a idade do user no ano inserido, baseado na subtracao do nascimento
        String nome;
        int anoNasc, anoAtual, idade;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        nome = teclado.nextLine();
        System.out.print("Digite o ano em que você nasceu: ");
        anoNasc = teclado.nextInt();
        System.out.print("Digite o ano em que estamos: ");
        anoAtual = teclado.nextInt();
        idade = anoAtual - anoNasc;
        System.out.println(nome+", você tem/tera "+idade+" anos em "+anoAtual);
        teclado.close();
    }
}
