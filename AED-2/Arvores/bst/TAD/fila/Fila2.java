public class Fila2 {
    
    // Classe Fila
    static class Fila {
        private static final int TAM = 10;
        private int[] vetor;
        private int primeiro;
        private int ultimo;

        // Construtor: inicializa a fila
        public Fila() {
            vetor = new int[TAM];
            primeiro = 0;
            ultimo = 0;
        }

        // Verifica se a fila está cheia
        public boolean cheia() {
            return ultimo == TAM;
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
            ultimo++;
        }

        // Remove um elemento da fila
        public int dequeue() {
            if (vazia()) {
                System.out.println("Fila vazia!");
                return -1;
            }
            int valor = vetor[primeiro];
            // Desloca os elementos para a esquerda
            for (int i = 0; i < ultimo - 1; i++) {
                vetor[i] = vetor[i + 1];
            }
            ultimo--;
            return valor;
        }

        // Exibe os elementos da fila
        public void exibir() {
            System.out.print("Fila: ");
            for (int i = primeiro; i < ultimo; i++) {
                System.out.print(vetor[i] + " ");
            }
            System.out.println();
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Criando uma instância da fila
        Fila f = new Fila();

        // Enfileirando elementos
        f.enqueue(10);
        f.enqueue(20);
        f.enqueue(30);
        f.exibir();

        // Removendo um elemento
        int removido = f.dequeue();
        System.out.println("Removido: " + removido);
        f.exibir();
    }
}
