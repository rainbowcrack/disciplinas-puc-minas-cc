import java.util.Scanner;
// atividade do módulo 03 - exercício 01 por Izabel Oliveira da Paz Chaves (1º período de C.C)
// copiar e colar o exemplo 04 da operação fatorial e analisar a sintaxe
public class C03EX01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        System.out.print("Informe um número: ");
        long numero = teclado.nextLong();
        long fatorial = 1L;
        // pequena modificação na indentação no loop 
        for(long contador = 2; contador <= numero; contador++){
            fatorial = fatorial * contador;
        }
        System.out.println("Fatorial = " + fatorial);
        teclado.close();

    }
}
