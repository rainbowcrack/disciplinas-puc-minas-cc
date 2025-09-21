package TP01;
import java.util.Scanner;

public class algebraboole {

    public static boolean evaluate(String expression, int[] values, int index) {
        // ignora espacos aumentando o indice
        while (index < expression.length() && expression.charAt(index) == ' ') {
            index++; 
        }

        if (index >= expression.length()) return false; // Evita acesso fora dos limites

        if (expression.charAt(index) == 'A' || expression.charAt(index) == 'B' || expression.charAt(index) == 'C') {
            return values[expression.charAt(index) - 'A'] == 1;
        }

        // operador NOT
        if (expression.startsWith("not", index)) {
            return !evaluate(expression, values, index + 4);
        }

        // operador AND
        if (expression.startsWith("and", index)) {
            int open = index + 4, mid = open;
            int count = 1;
            
            while (mid < expression.length() && count > 0) {
                mid++;
                if (expression.charAt(mid) == '(') count++;
                if (expression.charAt(mid) == ')') count--;
                if (expression.charAt(mid) == ',') count = 0;
            }
            return evaluate(expression, values, open) && evaluate(expression, values, mid + 2);
        }

        // operador OR
        if (expression.startsWith("or", index)) {
            int open = index + 3, mid = open;
            int count = 1;
            
            while (mid < expression.length() && count > 0) {
                mid++;
                if (expression.charAt(mid) == '(') count++;
                if (expression.charAt(mid) == ')') count--;
                if (expression.charAt(mid) == ',') count = 0;
            }
            return evaluate(expression, values, open) || evaluate(expression, values, mid + 2);
        }

        return false; 
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (teclado.hasNextLine()) {  // Evita erro ao tentar ler após o fim da entrada
            String nome = teclado.nextLine();

            if (nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M') {
                break;
            }

            if (nome.length() < 3) { // Entrada inválida, evitar erro
                continue;
            }

            // formatacao de entrada, por vetorizacao
            int n = nome.charAt(0) - '0';
            int[] values = new int[n];
            int index = 2;

            if (nome.length() < 2 + 2 * n) { // Verifica se há caracteres suficientes
                continue;
            }

            // preenche o vetor com a expressao booleana
            for (int i = 0; i < n; i++) {
                values[i] = nome.charAt(index) - '0';
                index += 2; 
            }

            // evoca o metodo recursivo e retorna com um operador ternario
            boolean result = evaluate(nome, values, index);
            System.out.println(result ? "1" : "0");
        }

        teclado.close();
    }
}
