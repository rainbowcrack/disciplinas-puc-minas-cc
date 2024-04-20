import java.util.Scanner;
// atividade do modulo 06 - exercicio 14 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para inverter um numero de 4 digitos por uma condicional
public class C06EX14 {
    public static void main(String[] args) {
        // input e chamar a biblioteca
        int num, d1, d2, d3, d4;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para saber a inversao,\nInforme um numero de 4 digitos: ");
        num = teclado.nextInt();
        // operacao
        d1 = num / 1000; // milhares
        d2 = num / 100 % 10; // centenas
        d3 = num / 10 % 10; // dezenas
        d4 = num % 10; // unidades
        // condicional
        if (String.valueOf(num).length() == 4) { // converte para String e calcula o comprimento de bits
            // tambem poderia ser feito if (num >= 1000 && num <= 9999)
            System.out.print("Resultado = " + d4 + d3 + d2 + d1);
        } else {
            System.out.print("Informe um numero de 4 digitos.");
        }
        teclado.close(); // fechar o teclado fora da condicional
    }
}
