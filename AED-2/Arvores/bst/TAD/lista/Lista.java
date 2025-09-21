public class Lista {

    private static final int TAM = 10;  // Tamanho máximo da lista
    private int[] vetor;  // Vetor para armazenar os elementos
    private int tamanho;  // Número atual de elementos na lista

    // Construtor para inicializar a lista
    public Lista() {
        vetor = new int[TAM];
        tamanho = 0;
    }

    // Verifica se a lista está cheia
    public boolean cheia() {
        return tamanho == TAM;
    }

    // Verifica se a lista está vazia
    public boolean vazia() {
        return tamanho == 0;
    }

    // Insere um elemento na lista
    public void inserir(int valor) {
        if (cheia()) {
            System.out.println("Lista cheia!");
            return;
        }
        vetor[tamanho] = valor;
        tamanho++;
    }

    // Remove um elemento da lista (remove o último elemento)
    public int remover() {
        if (vazia()) {
            System.out.println("Lista vazia!");
            return -1;  // Valor indicativo de erro
        }
        tamanho--;
        return vetor[tamanho];
    }

    // Exibe os elementos da lista
    public void exibir() {
        System.out.print("Lista: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Lista lista = new Lista();

        // Inserindo elementos
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.exibir();

        // Removendo um elemento
        int removido = lista.remover();
        System.out.println("Removido: " + removido);
        lista.exibir();

        // Inserindo mais elementos
        lista.inserir(40);
        lista.inserir(50);
        lista.exibir();
    }
}
