import java.util.Scanner;

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
