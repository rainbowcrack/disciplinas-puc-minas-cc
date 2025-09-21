import java.util.Scanner;
// atividade do modulo 05 - exercicio 10 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa que imprime um numero de 5 digitos em vertical
public class C05EX10 {
   public static void main(String[] args){
       // declarar variaveis inteiras e atribuicao
       int numero, d1, d2, d3, d4, d5;
       Scanner teclado = new Scanner(System.in);
       System.out.print("Insira um numero inteiro de 5 digitos: ");
       numero = teclado.nextInt();
       // operacao e output
       d1 = numero/10000;
       d2 = numero/1000%10;
       d3 = numero/100%10;
       d4 = numero/10%10;
       d5 = numero%10;
       System.out.print("Numero na vertical:\n" + d1 + "\n" + d2 + "\n" + d3 + "\n" + d4 + "\n" + d5);
       teclado.close();
   }
}
