import java.util.Scanner;

// atividade do modulo 05 - exercicio extra 02 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// formula da dilatacao temporal de einstein
public class C05EXTRA02 {
    public static void main(String[] args){
        // declarar variaveis e atribuir
        double tempo, segundos, velocidade;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para calcular a dilatacao temporal," + "\nTempo em segundos: ");
        segundos = teclado.nextDouble();
        System.out.print("E o valor da velocidade em m/s: ");
        velocidade = teclado.nextDouble();
        // operacao e output
        tempo = segundos * (1/Math.sqrt(1-(Math.pow(velocidade,2) / Math.pow(300000000,2))));
        System.out.printf("T = %1.4f", tempo);
        teclado.close();
    }
}
