import java.util.Scanner;
// atividade do modulo 07 - exercicio 02 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para calcular a nota conceito do aluno
public class C07EX02 {
    public static void main(String[] args) {
        // variaveis, input e variaveis
        double nota1, nota2, nota3, media;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para saber a nota conceito,\nInforme a nota da prova 1: ");
        nota1 = teclado.nextDouble();
        System.out.print("A nota da prova 2: ");
        nota2 = teclado.nextDouble();
        System.out.print("E a nota da prova 3: ");
        nota3 = teclado.nextDouble();
        // condicional para numeros entre 0 e 10
        if ((nota1 >= 0 && nota1 <= 10) && (nota2 >= 0 && nota1 <= 10) && (nota3 >= 0 && nota3 <= 10)) {
            media = (nota1 + nota2 + nota3) / 3;
            // swith dentro da condicional
            switch ((int) media) {
                case 9: case 10: // conceito para media 9 ou 10
                    System.out.print("\nConceito A.");
                    break;
                case 8: // conceito para media 8
                    System.out.print("\nConceito B.");
                    break;
                case 7: // conceito para media 7
                    System.out.print("\nConceito C.");
                    break;
                case 5: case 6: // conceito para media 5 ou 6
                    System.out.print("\nConceito D.");
                    break;
                case 1: case 2: case 3: case 4: // conceito para media 1, 2, 3 ou 4
                    System.out.print("\nConceito E.");
                    break;
                default:
                    System.out.print("\nErro!"); // mensagem de erro
                    break;               
            }
        } else {
            System.out.print("\nInsira as notas em um intervalo de 0 ate 10."); // condicao para o usuario escolher notas entre 0 e 10
        }
        teclado.close();
    }
}
