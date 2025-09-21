import java.util.Scanner;
// atividade do modulo 06 - exercicio 13 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para associar imprimir a duracao do evento
public class C06EX13 {
    public static void main(String[] args) {
        // variaveis, biblioteca e input
        int inicio, fim, horas, minutos, h1, m1, h2, m2;
        Scanner teclado = new Scanner(System.in);
        System.out.print("No padrao XXYY,\nDigite o horario de inicio: ");
        inicio = teclado.nextInt();  
        System.out.print("Digite o horario de fim: ");
        fim = teclado.nextInt();    
        // horas e minutos
        h1 = inicio / 100;
        m1 = inicio % 100;
        h2 = fim / 100;
        m2 = fim % 100;
        // delta variacao
        horas = h2 - h1;
        minutos = m2 - m1;
        // corrigindo casos de minutos negativos
        if (minutos < 0) {
            minutos += 60; // somar 60 e adicionar a variavel
            horas--; // subtrair das horas e adicionar na variavel
        }
        System.out.println("Duracao do evento = " + horas + " hs " + minutos + " min."); // output
        teclado.close();
    }
}
