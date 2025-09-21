// 2312 - Medals Table
import java.util.Scanner;

public class Main {
    // classe de medalhas
    static class Medalhas { 
        String pais;
        int ouro, prata, bronze;
    }

    // ordena medalhas
    public static void bubbleSort(Medalhas[] medalha, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                boolean swap = false;

                // medalhas de ouro
                if (medalha[j].ouro < medalha[j + 1].ouro) {
                    swap = true;
                } else if (medalha[j].ouro == medalha[j + 1].ouro) {
                    // medalhas de prata
                    if (medalha[j].prata < medalha[j + 1].prata) {
                        swap = true;
                    } else if (medalha[j].prata == medalha[j + 1].prata) {
                        // medalhas de bronze
                        if (medalha[j].bronze < medalha[j + 1].bronze) {
                            swap = true;
                        } else if (medalha[j].bronze == medalha[j + 1].bronze) {
                            // comparacao alfabetica
                            if (medalha[j].pais.compareTo(medalha[j + 1].pais) > 0) {
                                swap = true;
                            }
                        }
                    }
                }

                // Se precisar trocar, faz o swap
                if (swap) {
                    Medalhas temp = medalha[j];
                    medalha[j] = medalha[j + 1];
                    medalha[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n = teclado.nextInt();
        teclado.nextLine(); // Consumir a quebra de linha

        Medalhas[] medalha = new Medalhas[n];

        for (int i = 0; i < n; i++) {
            medalha[i] = new Medalhas(); // Criar um novo objeto para cada indice
            medalha[i].pais = teclado.next();
            medalha[i].ouro = teclado.nextInt();
            medalha[i].prata = teclado.nextInt();
            medalha[i].bronze = teclado.nextInt();
        }

        // Ordena as medalhas
        bubbleSort(medalha, n);

        // Exibir saida
        for (int i = 0; i < n; i++) {
            System.out.println(medalha[i].pais + " " + medalha[i].ouro + " " + medalha[i].prata + " " + medalha[i].bronze);
        }

        teclado.close();
    }
}
