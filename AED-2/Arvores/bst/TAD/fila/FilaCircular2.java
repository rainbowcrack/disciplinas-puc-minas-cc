public class FilaCircular2{

    static class FilaCircular {
        private static final int TAM = 10;
        private int[] vetor;
        private int primeiro;
        private int ultimo;

        // Construtor: inicializa a fila circular
        public FilaCircular() {
            vetor = new int[TAM];
            primeiro = 0;
            ultimo = 0;
        }

        // Verifica se a fila está cheia
        public boolean cheia() {
            return (ultimo + 1) % TAM == primeiro;
        }

        // Verifica se a fila está vazia
        public boolean vazia() {
            return primeiro == ultimo;
        }

        // Insere um elemento na fila
        public void enqueue(int valor) {
            if (cheia()) {
                System.out.println("Fila cheia!");
                return;
            }
            vetor[ultimo] = valor;
            ultimo = (ultimo + 1) % TAM;  // Incrementa e garante que o índice seja circular
        }

        // Remove um elemento da fila
        public int dequeue() {
            if (vazia()) {
                System.out.println("Fila vazia!");
                return -1;
            }
            int valor = vetor[primeiro];
            primeiro = (primeiro + 1) % TAM;  // Incrementa e garante que o índice seja circular
            return valor;
        }

        // Exibe os elementos da fila
        public void exibir() {
            System.out.print("Fila Circular: ");
            int i = primeiro;
            while (i != ultimo) {
                System.out.print(vetor[i] + " ");
                i = (i + 1) % TAM;  // Vai para o próximo índice de forma circular
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FilaCircular f = new FilaCircular();

        // Enfileirando elementos
        f.enqueue(10);
        f.enqueue(20);
        f.enqueue(30);
        f.exibir();

        // Removendo um elemento
        int removido = f.dequeue();
        System.out.println("Removido: " + removido);
        f.exibir();

        // Adicionando mais elementos
        f.enqueue(40);
        f.enqueue(50);
        f.exibir();
    }
}
