// 1110 - throwing cards away

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            int n = teclado.nextInt();
            if (n == 0) break;

            int[] baralho = new int[2 * n]; // Simula uma fila com um array
            for (int i = 0; i < n; i++) {
                baralho[i] = i + 1;
            }

            int inicio = 0, fim = n, descartadas = 0;
            int[] descartes = new int[n - 1]; // No maximo n-1 descartes

            while (fim - inicio > 1) {
                descartes[descartadas++] = baralho[inicio++]; // Descarta a carta do topo
                baralho[fim++] = baralho[inicio++]; // Move a proxima carta para o final
            }

            // Imprime os descartes
            System.out.print("Discarded cards:");
            for (int i = 0; i < descartadas; i++) {
                if (i == 0) {
                    System.out.print(" " + descartes[i]);
                } else {
                    System.out.print(", " + descartes[i]);
                }
            }
            System.out.println();

            // Imprime a carta restante
            System.out.println("Remaining card: " + baralho[inicio]);
        }
        teclado.close();
    }
}
