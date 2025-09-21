// 2929 smallest on the stack
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt();
        int[] pilha = new int[N]; // Simulando uma pilha com array
        int[] minimos = new int[N]; // Armazena os mínimos
        int topo = -1;
        
        for (int i = 0; i < N; i++) {
            String operacao = teclado.next();
            
            if (operacao.equals("PUSH")) {
                int valor = teclado.nextInt();
                topo++;
                pilha[topo] = valor;
                
                if (topo == 0) {
                    minimos[topo] = valor;
                } else {
                    minimos[topo] = Math.min(minimos[topo - 1], valor);
                }
            } else if (operacao.equals("POP")) {
                if (topo == -1) {
                    System.out.println("EMPTY");
                } else {
                    topo--;
                }
            } else if (operacao.equals("MIN")) {
                if (topo == -1) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(minimos[topo]);
                }
            }
        }
        teclado.close();
    }
}
