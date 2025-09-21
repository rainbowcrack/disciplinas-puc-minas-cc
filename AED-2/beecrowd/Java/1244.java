// 1244 - Sort by length
import java.util.Scanner;

public class Main {

    // funcao bubblesort para ordenar as palavras na frase
    public static void bubbleSort(String frase) {
        // pega cada palavra na frase
        String[] palavras = frase.split(" ");
        
        for (int i = 0; i < palavras.length - 1; i++) {
            boolean trocou = false;
            
            for (int j = 0; j < palavras.length - 1 - i; j++) {
                
                if (palavras[j].length() < palavras[j + 1].length()) {
                    
                    // Troca as palavras
                    String temp = palavras[j];
                    palavras[j] = palavras[j + 1];
                    palavras[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) break; // otimizacao nao precisa
        }
        
        // Imprime a frase ordenada
        for (int i = 0; i < palavras.length; i++) {
            System.out.print(palavras[i]);
            if (i < palavras.length - 1) {
                System.out.print(" "); // Adiciona o espaço entre as palavras
            }
        }
        System.out.println(); // Nova linha ao final
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int n = teclado.nextInt();
        teclado.nextLine(); // Consumir a quebra de linha
        
        // Leitura das frases
        for (int i = 0; i < n; i++) {
            String frase = teclado.nextLine();
            bubbleSort(frase); // Ordenacao de cada frase
        }

        teclado.close();
    }
}
