package TP01;
import java.util.Scanner;

public class teste{

    public static boolean evaluateIterative(String expression, int[] values, int startIndex) {
        boolean[] stack = new boolean[100]; // Array simulando a pilha
        char[] operators = new char[100]; // Para armazenar operadores (and/or)
        int stackIndex = -1, opIndex = -1;
        boolean lastValue = false;
        int i = startIndex;

        while (i < expression.length()) {
            char c = expression.charAt(i);

            if (c == 'A' || c == 'B' || c == 'C') {
                lastValue = values[c - 'A'] == 1;
            } else if (c == 'n' && i + 3 < expression.length() && expression.charAt(i + 1) == 'o' &&
                       expression.charAt(i + 2) == 't' && expression.charAt(i + 3) == '(') {
                i += 3;
                lastValue = !lastValue;
            } else if (c == 'a' && i + 3 < expression.length() && expression.charAt(i + 1) == 'n' &&
                       expression.charAt(i + 2) == 'd' && expression.charAt(i + 3) == '(') {
                i += 3;
                stack[++stackIndex] = lastValue;
                operators[++opIndex] = 'a';
                lastValue = true;
            } else if (c == 'o' && i + 2 < expression.length() && expression.charAt(i + 1) == 'r' &&
                       expression.charAt(i + 2) == '(') {
                i += 2;
                stack[++stackIndex] = lastValue;
                operators[++opIndex] = 'o';
                lastValue = false;
            } else if (c == ',') {
                if (stackIndex >= 0) {
                    char op = operators[opIndex--];
                    if (op == 'a') {
                        lastValue = stack[stackIndex--] && lastValue;
                    } else {
                        lastValue = stack[stackIndex--] || lastValue;
                    }
                }
            } else if (c == ')') {
                if (stackIndex >= 0) {
                    char op = operators[opIndex--];
                    if (op == 'a') {
                        lastValue = stack[stackIndex--] && lastValue;
                    } else {
                        lastValue = stack[stackIndex--] || lastValue;
                    }
                }
            }

            i++;
        }

        return lastValue;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (teclado.hasNextLine()) { // Evita erro ao tentar ler após o fim da entrada
            String nome = teclado.nextLine();
            if (nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M') {
                break;
            }

            if (nome.length() < 3) {
                continue;
            }

            int n = nome.charAt(0) - '0';
            int[] values = new int[n];
            int index = 2;

            if (nome.length() < 2 + 2 * n) {
                continue;
            }

            for (int i = 0; i < n; i++) {
                values[i] = nome.charAt(index) - '0';
                index += 2;
            }

            boolean result = evaluateIterative(nome, values, index);
            System.out.println(result ? "1" : "0");
        }

        teclado.close();
    }
}
