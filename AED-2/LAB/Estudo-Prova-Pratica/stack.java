import java.util.Scanner;
import java.util.Stack;

public class Main {
    static class Carro {
        int chegada;
        int saida;

        Carro(int c, int s) {
            this.chegada = c;
            this.saida = s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt(); // número de motoristas
            int K = sc.nextInt(); // capacidade do estacionamento

            if (N == 0 && K == 0) break;

            Stack<Carro> pilha = new Stack<>();
            boolean possivel = true;

            for (int i = 0; i < N; i++) {
                int chegada = sc.nextInt();
                int saida = sc.nextInt();

                // Retira carros que já saíram antes da chegada do novo carro
                while (!pilha.isEmpty() && pilha.peek().saida < chegada) {
                    pilha.pop();
                }

                // Verifica se o carro atual vai sair antes de quem está no topo (quebra a ordem da pilha)
                if (!pilha.isEmpty() && saida < pilha.peek().saida) {
                    possivel = false;
                }

                pilha.push(new Carro(chegada, saida));

                // Verifica se a capacidade foi excedida
                if (pilha.size() > K) {
                    possivel = false;
                }
            }

            System.out.println(possivel ? "Sim" : "Nao");
        }
    }
}
