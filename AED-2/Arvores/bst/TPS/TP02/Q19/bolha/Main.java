import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Geracao {
    protected int[] array;
    protected int n;
    public long comparacoes = 0;
    public long movimentacoes = 0;

    public Geracao() {
        array = new int[100];
        n = array.length;
    }

    public Geracao(int tamanho) {
        array = new int[tamanho];
        n = array.length;
    }

    public void crescente() {
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
    }

    public void decrescente() {
        for (int i = 0; i < n; i++) {
            array[i] = n - 1 - i;
        }
    }

    public void aleatorio() {
        Random rand = new Random();
        crescente();
        for (int i = 0; i < n; i++) {
            swap(i, Math.abs(rand.nextInt()) % n);
        }
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        movimentacoes += 3;
    }

    public long now() {
        return new Date().getTime();
    }

    public void sort() {
        System.out.println("Método a ser implementado nas subclasses.");
    }
}

class Bolha extends Geracao {
    public Bolha() { super(); }
    public Bolha(int tamanho) { super(tamanho); }

    @Override
    public void sort() {
        for (int i = (n - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                comparacoes++;
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000, 100000};
        String arquivo = "bolha.csv";

        try (FileWriter fw = new FileWriter(arquivo)) {
            fw.write("Tamanho,Tempo (ms),Comparacoes,Movimentacoes\n");

            for (int tamanho : tamanhos) {
                Bolha sort = new Bolha(tamanho);
                sort.aleatorio();
                long inicio = sort.now();
                sort.sort();
                long fim = sort.now();

                long tempo = fim - inicio;
                System.out.println("Tamanho: " + tamanho + " | Tempo: " + tempo + "ms | Comparacoes: " + sort.comparacoes + " | Movimentacoes: " + sort.movimentacoes);
                fw.write(tamanho + "," + tempo + "," + sort.comparacoes + "," + sort.movimentacoes + "\n");
            }

            System.out.println("Resultados exportados para " + arquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
