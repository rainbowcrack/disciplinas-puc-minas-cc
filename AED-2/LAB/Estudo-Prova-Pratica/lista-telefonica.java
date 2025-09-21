import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        while (teclado.hasNextInt()) {
            int N = teclado.nextInt();
            // teclado.nextLine(); // limpa o \n nao precisa

            String[] telefones = new String[N];
            for (int i = 0; i < N; i++) {
                telefones[i] = teclado.nextLine();
            }

            int economia = 0;

            for (int i = 1; i < N; i++) {
                int comum = 0;
                int tamanho = telefones[i].length();
                for (int j = 0; j < tamanho; j++) {
                    if (telefones[i].charAt(j) == telefones[i - 1].charAt(j)) {
                        comum++;
                    } else {
                        break;
                    }
                }
                economia += comum;
            }

            System.out.println(economia);
        }
    }
}
