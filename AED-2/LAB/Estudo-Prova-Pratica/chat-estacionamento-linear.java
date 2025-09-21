import java.util.Scanner;

public class Main {
    
    static class Pilha {
        int Ci;
        int Si;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt(); // número de motoristas
            int K = sc.nextInt(); // capacidade do estacionamento

            if (N == 0 && K == 0) break;

            Pilha[] pilha = new Pilha[K + 1]; // pilha com capacidade +1
            for (int i = 0; i <= K; i++) {
                pilha[i] = new Pilha(); // inicializa os objetos
            }

            int topo = -1;
            boolean possivel = true;

            for (int i = 0; i < N; i++) {
                int chegada = sc.nextInt();
                int saida = sc.nextInt();

                // Remove carros que já saíram antes da chegada do novo carro
                while (topo >= 0 && pilha[topo].Si < chegada) {
                    topo--;
                }

                // Verifica se o carro atual vai sair antes do que está no topo (violação da pilha)
                if (topo >= 0 && saida < pilha[topo].Si) {
                    possivel = false;
                }

                // Insere o carro na pilha
                topo++;
                if (topo >= K) {
                    possivel = false; // excedeu capacidade
                } else {
                    pilha[topo].Ci = chegada;
                    pilha[topo].Si = saida;
                }
            }

            System.out.println(possivel ? "Sim" : "Nao");
        }
    }
}
