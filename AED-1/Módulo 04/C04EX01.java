import java.util.Scanner;
// atividade do modulo 04 - exercicio 01 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa que formata a ordem de input do nome e do sobrenome e insere idade
public class C04EX01 {
    public static void main(String[] args) {
        String nome1, nome2, nome3;
        int idade;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe o seu primeiro nome: ");
        nome1 = teclado.nextLine();
        System.out.print("O seu segundo nome: ");
        nome2 = teclado.nextLine();
        System.out.print("O seu sobrenome: ");
        nome3 = teclado.nextLine();
        System.out.print("Informe a sua idade: ");
        idade = teclado.nextInt();
        System.out.println();
        System.out.println(nome3 + ", " + nome1 + " " + nome2);
        System.out.println("Idade: " + idade + " anos.");
        teclado.close();
    }
}
