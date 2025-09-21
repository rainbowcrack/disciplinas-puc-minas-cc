import java.util.*;

// Classe base para geração de arrays
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

    public void mostrar(int k) {
        System.out.print("[");
        for (int i = 0; i < k; i++) {
            System.out.print(" (" + i + ")" + array[i]);
        }
        System.out.println("]");
    }

    public void mostrar() {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(" (" + i + ")" + array[i]);
        }
        System.out.println("]");
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
        boolean resp = true;
        for (int i = 1; i < n; i++) {
            if (array[i] < array[i - 1]) {
                i = n;
                resp = false;
            }
        }
        return resp;
    }

    public void sort() {
        System.out.println("Método a ser implementado nas subclasses.");
    }
}

// Implementação da ordenação por seleção
class Selecao extends Geracao {
    public Selecao() {
        super();
    }

    public Selecao(int tamanho) {
        super(tamanho);
    }

    @Override
    public void sort() {
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (array[menor] > array[j]) {
                    menor = j;
                }
            }
            swap(menor, i);
        }
    }
}

// Subclasse que conta comparações e movimentações
class SelecaoComContagem extends Selecao {
    private long comparacoes;
    private long movimentacoes;

    public SelecaoComContagem(int tamanho) {
        super(tamanho);
        comparacoes = 0;
        movimentacoes = 0;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

    @Override
    public void sort() {
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                comparacoes++;
                if (array[menor] > array[j]) {
                    menor = j;
                }
            }
            if (menor != i) {
                swapContando(menor, i);
            }
        }
    }

    private void swapContando(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        movimentacoes += 3;
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000, 100000};

        for (int tam : tamanhos) {
            SelecaoComContagem selecao = new SelecaoComContagem(tam);
            selecao.aleatorio();

            long inicio = selecao.now();
            selecao.sort();
            long fim = selecao.now();

            System.out.println("Tamanho do vetor: " + tam);
            System.out.println("Tempo de execução: " + (fim - inicio) + " ms");
            System.out.println("Número de comparações: " + selecao.getComparacoes());
            System.out.println("Número de movimentações: " + selecao.getMovimentacoes());
            System.out.println("------------------------------------");
        }
    }
}
