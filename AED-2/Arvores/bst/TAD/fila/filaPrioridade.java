public class filaPrioridade{
    
    // Classe Fila, vetor eh tipado pelo elemento
    static class FilaDePrioridade {
        private static final int TAM = 10;
        private Elemento[] vetor;
        private int primeiro;
        private int ultimo;

        // Construtor: inicializa a fila de prioridade
        public FilaDePrioridade() {
            vetor = new Elemento[TAM];
            primeiro = 0;
            ultimo = 0;
        }

        // Classe interna com valor e prioridade
        static class Elemento {
            int valor;
            int prioridade;

            public Elemento(int valor, int prioridade) {
                this.valor = valor;
                this.prioridade = prioridade;
            }
        }

        // Verifica se a fila está cheia
        public boolean cheia() {
            return ultimo == TAM;
        }

        // Verifica se a fila está vazia
        public boolean vazia() {
            return primeiro == ultimo;
        }

        // Insere um elemento na fila de prioridade
        public void enqueue(int valor, int prioridade) {
            if (cheia()) {
                System.out.println("Fila cheia!");
                return;
            }

            Elemento novoElemento = new Elemento(valor, prioridade);
            vetor[ultimo] = novoElemento;
            ultimo++;

            // Organiza a fila de forma que o maior valor de prioridade fique no início
            ordenarFila();
        }

        // Ordena a fila com base na prioridade (do maior para o menor)
        // bubble sort
        private void ordenarFila() {
            for (int i = primeiro; i < ultimo - 1; i++) {
                for (int j = i + 1; j < ultimo; j++) {
                    if (vetor[i].prioridade < vetor[j].prioridade) {
                        // Troca os elementos
                        Elemento temp = vetor[i];
                        vetor[i] = vetor[j];
                        vetor[j] = temp;
                    }
                }
            }
        }

        // Remove um elemento da fila de prioridade
        public int dequeue() {
            if (vazia()) {
                System.out.println("Fila vazia!");
                return -1;
            }
            int valor = vetor[primeiro].valor;
            primeiro++;
            return valor;
        }

        // Exibe os elementos da fila de prioridade
        public void exibir() {
            System.out.print("Fila de Prioridade: ");
            for (int i = primeiro; i < ultimo; i++) {
                System.out.print("(" + vetor[i].valor + ", Prioridade: " + vetor[i].prioridade + ") ");
            }
            System.out.println();
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Criando uma instância da fila de prioridade
        FilaDePrioridade f = new FilaDePrioridade();

        // Enfileirando elementos com diferentes prioridades
        f.enqueue(10, 3);  
        f.enqueue(20, 1);
        f.enqueue(30, 2);  
        f.exibir();

        // Removendo o elemento de maior prioridade
        int removido = f.dequeue();
        System.out.println("Removido: " + removido);
        f.exibir();

        // Adicionando mais elementos
        f.enqueue(25, 5);  
        f.enqueue(5, 4);  
        f.exibir();

        // Removendo mais um elemento
        removido = f.dequeue();
        System.out.println("Removido: " + removido);
        f.exibir();
    }
}
