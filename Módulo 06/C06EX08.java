import java.util.Scanner;

// atividade do modulo 06 - exercicio 08 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para calcular o peso minimo a partir da altura do user
public class C06EX08 {
    public static void main(String[] args) {
        // atribuicao e declarar variaveis
        String nome;
        double peso1, peso2, altura;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para o indicador IMC,\nInforme o seu nome: ");
        nome = teclado.nextLine();
        System.out.print("A sua altura: ");
        altura = teclado.nextDouble();
        // operacao IMC e acuracia de 5 casas decimais
        peso1 = 20.00001 * Math.pow(altura, 2); // valor minimo a partir de 20
        peso2 = 24.99999 * Math.pow(altura, 2); // valor maximo menor de 25
        System.out.print("\nA pessoa, " + nome + ", deverá ter");
        System.out.printf("\nPeso minimo = %1.2f", peso1);
        System.out.printf("\nPeso maximo = %1.2f", peso2);
        teclado.close();
    }
}
