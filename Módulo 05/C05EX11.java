import java.util.Scanner;
// programa para ler o numero do cheque bancario
public class C05EX11 {
   public static void main(String[] args){
       // declaracao de variaveis e atribuicao
       int cheque, n1, n2, n3;
       Scanner teclado = new Scanner(System.in);
       System.out.print("Informe o numero do cheque: ");
       cheque = teclado.nextInt();
       // ao inves de criar variaveis em java, em python eu criaria uma lista e pegava os numeros pela posicao
       n1 = cheque/1000000;
       n2 = cheque/1000%1000;
       n3 = cheque%1000;
       System.out.print("Banco: " + n1 + "\nAgencia: " + n2 + "\nSequencial: " + n3);
       teclado.close();
   }
}
