import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

// Superclasse para gerar e manipular arrays
class Geracao {
    protected int[] array;
    protected int n;

    public Geracao() {
        array = new int[100];
        n = array.length;
    }

    public Geracao(int tamanho) {
        array = new int[tamanho];
        n = array.length;
    }

    public void crescente() {
        for (int i = 0; i < n; i++) array[i] = i;
    }

    public void decrescente() {
        for (int i = 0; i < n; i++) array[i] = n - 1 - i;
    }

    public void aleatorio() {
        Random rand = new Random();
        crescente();
        for (int i = 0; i < n; i++) {
            swap(i, Math.abs(rand.nextInt()) % n);
        }
    }

    public void mostrar(int k) {
        System.out.print("[");
        for (int i = 0; i < k; i++) {
            System.out.print(" (" + i + ")" + array[i]);
        }
        System.out.println("]");
    }

    public void mostrar() {
        mostrar(n);
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public long now() {
        return new Date().getTime();
    }

    public boolean isOrdenado() {
        for (int i = 1; i < n; i++) {
            if (array[i] < array[i - 1]) return false;
        }
        return true;
    }

    public void sort() {
        System.out.println("Método a ser implementado nas subclasses.");
    }
}

// Algoritmo de ordenação por inserção
class Insercao extends Geracao {

    public Insercao() {
        super();
    }

    public Insercao(int tamanho) {
        super(tamanho);
    }

    @Override
    public void sort() {
        for (int i = 1; i < n; i++) {
            int tmp = array[i];
            int j = i - 1;

            while ((j >= 0) && (array[j] > tmp)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
    }
}

// Inserção com contagem de comparações e movimentações
class InsercaoComContagem extends Insercao {
    private long comparacoes = 0;
    private long movimentacoes = 0;

    public InsercaoComContagem(int tamanho) {
        super(tamanho);
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

    @Override
    public void sort() {
        for (int i = 1; i < n; i++) {
            int tmp = array[i];
            movimentacoes++; // tmp recebe array[i]

            int j = i - 1;
            while (j >= 0) {
                comparacoes++;
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                    movimentacoes++;
                    j--;
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
            movimentacoes++;
        }
    }
}

// Classe principal que executa e gera CSV
public class Main {
    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000, 100000};
        String nomeArquivo = "resultados_insercao.csv";

        try {
            FileWriter writer = new FileWriter(nomeArquivo);
            writer.write("Tamanho,Tempo(ms),Comparacoes,Movimentacoes\n");

            for (int tam : tamanhos) {
                InsercaoComContagem insercao = new InsercaoComContagem(tam);
                insercao.aleatorio();

                long inicio = insercao.now();
                insercao.sort();
                long fim = insercao.now();

                long tempo = fim - inicio;
                long comparacoes = insercao.getComparacoes();
                long movimentacoes = insercao.getMovimentacoes();

                // Print no console
                System.out.println("Tamanho do vetor: " + tam);
                System.out.println("Tempo de execucao: " + tempo + " ms");
                System.out.println("Comparacoes: " + comparacoes);
                System.out.println("Movimentacoes: " + movimentacoes);
                System.out.println("------------------------------------");

                // Escreve no CSV
                writer.write(tam + "," + tempo + "," + comparacoes + "," + movimentacoes + "\n");
            }

            writer.close();
            System.out.println("Arquivo '" + nomeArquivo + "' criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao escrever o CSV: " + e.getMessage());
        }
    }
}
