import java.util.Scanner;
// atividade do modulo 05 - exercicio 12 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para transformacoes de unidades temporais 
public class C05EX12 {
    public static void main(String[] args) {
        // declarar variaveis e atribuir
        int seg, hrs, min, seg1;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe a duracao do evento em segundos: ");
        seg = teclado.nextInt();
        // operacao e output
        hrs = seg / 3600;
        min = (seg - (hrs * 3600)) / 60; // converter unidades para segundo
        seg1 = seg - ((hrs * 3600) + (min * 60)); // converter unidades para segundo
        System.out.print("\nHoras: " + hrs + "\nMinutos: " + min + "\nSegundos: " + seg1);
        teclado.close();
    }
}
