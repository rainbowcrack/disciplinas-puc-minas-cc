import java.util.Scanner;
// atividade do módulo 03 - exercício 03 por Izabel Oliveira da Paz Chaves (1º período de C.C)
// programa que calcula a hipotenusa, a partir do teorema de pitágoras
public class C03EX03 {
    public static void main(String[] args) {
        double hipotenusa, cateto1, cateto2;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe o valor do cateto 1: ");
        cateto1 = teclado.nextDouble();
        System.out.print("Informe o valor do cateto 1 : ");
        cateto2 = teclado.nextDouble();
        hipotenusa = Math.pow(Math.pow(cateto1, 2) + Math.pow(cateto2, 2), 1.0 / 2);
        System.out.print("Hipotenusa = " + hipotenusa);
        teclado.close();
    }
}
