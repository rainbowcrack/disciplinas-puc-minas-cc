// 2312 - MEDAL TABLE
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Estrutura paises e medalhas
typedef struct {
    char pais[100];
    int ouro, prata, bronze;
} Medalhas;

// ordenar os paises conforme as regras
void bubbleSort(Medalhas medalha[], int n) {
    int trocou;
    for (int i = 0; i < n - 1; i++) {
        trocou = 0;
        for (int j = 0; j < n - i - 1; j++) {
            int swap = 0;
            
            // Comparacao pelas regras
            if (medalha[j].ouro < medalha[j + 1].ouro) {
                swap = 1;
            } 
            else if (medalha[j].ouro == medalha[j + 1].ouro) {
                if (medalha[j].prata < medalha[j + 1].prata) {
                    swap = 1;
                } 
                else if (medalha[j].prata == medalha[j + 1].prata) {
                    if (medalha[j].bronze < medalha[j + 1].bronze) {
                        swap = 1;
                    } 
                    else if (medalha[j].bronze == medalha[j + 1].bronze) {
                        // Se ouro, prata e bronze forem iguais, ordenar por ordem alfabetica crescente
                        if (strcmp(medalha[j].pais, medalha[j + 1].pais) > 0) {
                            swap = 1;
                        }
                    }
                }
            }

            // faz o swap
            if (swap) {
                Medalhas temp = medalha[j];
                medalha[j] = medalha[j + 1];
                medalha[j + 1] = temp;
                trocou = 1;
            }
        }
        // se nao teve troca, vetor ordenado
        if (!trocou) break;
    }
}

int main() {
    // Quantidade de paises
    int n;
    scanf("%d", &n);
    
    Medalhas medalha[n];
    
    // Leitura dos dados
    for (int i = 0; i < n; i++) {
        scanf("%s %d %d %d", medalha[i].pais, &medalha[i].ouro, &medalha[i].prata, &medalha[i].bronze);
    }
    
    // Ordenacao com Bubble Sort
    bubbleSort(medalha, n);
    
    // Exibicao dos resultados ordenados
    for (int i = 0; i < n; i++) {
        printf("%s %d %d %d\n", medalha[i].pais, medalha[i].ouro, medalha[i].prata, medalha[i].bronze);
    }

    return 0;
}
