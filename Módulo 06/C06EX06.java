import java.util.Scanner;
// atividade do modulo 06 - exercicio 06 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para resolver a funcao de 2 grau
public class C06EX06 {
    public static void main(String[] args) {
        // declaracao e atribuicao de variaveis
        double a, b, c, x1, x2, delta;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para encontrar as raizes da funcao de segundo grau,\nValor de A: ");
        a = teclado.nextInt();
        System.out.print("Valor de B: ");
        b = teclado.nextInt();
        System.out.print("Valor de C: ");
        c = teclado.nextInt();
        // operacao delta e raizes
        delta = Math.pow(b, 2) - 4 * a * c;
        x1 = (Math.sqrt(delta) - b) / (2 * a);
        x2 = (-(Math.sqrt(delta)) - b) / (2 * a);
        // condicional
        if (delta == 0) {
            System.out.print("Teremos 1 raiz = " + x1);
        } else if (delta > 0) {
            System.out.print("Teremos 2 raizes = " + x1 + " e " + x2);
        } else if (delta < 0) { // escrever para melhorar a compreensao
            System.out.print("Nao teremos raizes.");
        }
        teclado.close(); // fechar depois da condicional
    }
}
