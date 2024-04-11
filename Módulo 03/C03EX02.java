import java.util.Scanner;
public class C03EX02 {
    // funcao: Calcula a media de 3 numeros inteiros
    // atividade do modulo 03 - exercicio 02 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
    public static void main(String[] args) {
        long n1, n2, n3, soma;
        double media;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe um numero: ");
        n1 = teclado.nextLong();
        System.out.print("Informe outro numero: ");
        n2 = teclado.nextLong();
        System.out.print("Informe mais um numero: "); 
        n3 = teclado.nextLong();
        soma = n1 + n2 + n3;
        media = soma / 3.0;
        System.out.println("Media = " + media);
        teclado.close(); 
    }
}
