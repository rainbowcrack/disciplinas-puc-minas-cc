import java.util.Scanner;

// atividade do modulo 06 - exercicio 01 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa que retorna o valor de fx dado em um funcao
public class C06EX01 {
    public static void main(String[] args){
        // declarar e atribuir variavel
        double x, fx;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para resolver a funcao,\nInforme o valor do x: ");
        x = teclado.nextDouble();
        // operacao e condicional
        if (x == 4)
            fx = 0;
        else
        if (x < 4)
            fx = ((5 * x) + 3) / Math.sqrt(16 - Math.pow(x, 2));
                    else
                        fx = ((5 * x) + 3) / Math.sqrt(Math.pow(x, 2) - 16);
                    // output
        System.out.print("F(x) = " + fx);
        teclado.close();
    }
}
