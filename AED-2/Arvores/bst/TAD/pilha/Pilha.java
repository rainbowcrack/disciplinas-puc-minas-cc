public class Pilha {
    private static final int MAX = 10;  

    private int[] vetor;              
    private int topo; // ponteiro para topo

    // Construtor para inicializar a pilha
    public Pilha() {
        vetor = new int[MAX];
        topo = 0;  // Pilha inicialmente vazia
    }

    // Empilha um valor
    public void push(int valor) {
        if (topo < MAX) {
            vetor[topo] = valor;
            topo++;
        } else {
            System.out.println("Pilha cheia!");
        }
    }

    // Desempilha um valor
    public int pop() {
        if (topo > 0) {
            topo--;
            return vetor[topo];
        } else {
            System.out.println("Pilha vazia!");
            return -1;  // Valor indicativo de erro
        }
    }

    // Imprime a pilha
    public void imprime() {
        System.out.print("[ ");
        for (int i = topo - 1; i >= 0; i--) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("]");
    }

    // Método principal para testar a pilha
    public static void main(String[] args) {
        Pilha p = new Pilha();

        // Empilhando elementos
        p.push(5);
        p.push(10);
        p.push(15);
        p.push(100);

        // Mostra onde o topo da pilha está
        System.out.println("Onde está o topo: " + p.topo);

        // Imprime a pilha
        p.imprime();

        // Desempilha um elemento
        int removido = p.pop();
        System.out.println("Elemento removido: " + removido);

        // Imprime a pilha após o desempilhamento
        p.imprime();
    }
}
