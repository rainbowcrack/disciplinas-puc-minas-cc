import java.util.Scanner;
// atividade do modulo 07 - exercicio 01 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa com switch para casos em que o apostador pode ganhar premios
public class C07EX01 {
    public static void main(String[] args) {
        // variaveis, input e variaveis
        String nome;
        int numero;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para saber o premio,\nQual o nome do apostador: ");
        nome = teclado.nextLine();
        System.out.print("Quantos jogos o apostador ganhou: ");
        numero = teclado.nextInt();
        // switch
        switch (numero) {
            case 1: case 2: case 3: case 4: case 5: // case numero de 1 ate 5
                System.out.print("\nA pessoa " + nome + ": Nenhum premio");
                break;
            case 6: case 7: case 8: case 9: case 10: // case numero de 6 ate 10
                System.out.print("\nA pessoa " + nome + ": Ganhou outro cartao");
                break;
            case 11: // case numero 11
                System.out.print("\nA pessoa " + nome + ": Premio de R$100,00");
                break;
            case 12: // case numero 12
                System.out.print("\nA pessoa " + nome + ": Premio de R$1.000,00");
                break;
            case 13: // case numero 13
                System.out.print("\nA pessoa " + nome + ": Premio de R$50.000,00");
                break;
            default: // nenhum dos cases
                System.out.print("\nNumero invalido, digite novamente.");
                break;
        }
        teclado.close();
    }
}
