#include <stdio.h>
#include <stdlib.h>

#define TAM 10

// Estrutura da fila
typedef struct {
    int vetor[TAM];
    int primeiro;
    int ultimo;
} Fila;

// Inicializa a fila
void inicializar(Fila *fila) {
    fila->primeiro = 0;
    fila->ultimo = 0;
}

// Verifica se a fila está cheia
int cheia(Fila *fila) {
    return (fila->ultimo == TAM);
}

// Verifica se a fila está vazia
int vazia(Fila *fila) {
    return (fila->primeiro == fila->ultimo);
}

// Insere um elemento na fila
void enqueue(Fila *fila, int valor) {
    if (cheia(fila)) {
        printf("Fila cheia!\n");
        return;
    }
    fila->vetor[fila->ultimo] = valor;
    fila->ultimo++;
}

// Remove um elemento da fila
int dequeue(Fila *fila) {
    if (vazia(fila)) {
        printf("Fila vazia!\n");
        return -1; // Valor indicativo de erro
    }
    int valor = fila->vetor[fila->primeiro];
    // Desloca os elementos para a esquerda
    for (int i = 0; i < fila->ultimo - 1; i++) {
        fila->vetor[i] = fila->vetor[i + 1];
    }
    fila->ultimo--;
    return valor;
}

// Exibe a fila
void exibir(Fila *fila) {
    printf("Fila: ");
    for (int i = fila->primeiro; i < fila->ultimo; i++) {
        printf("%d ", fila->vetor[i]);
    }
    printf("\n");
}

int main() {
    Fila f;
    inicializar(&f);

    enqueue(&f, 10);
    enqueue(&f, 20);
    enqueue(&f, 30);
    exibir(&f);

    int removido = dequeue(&f);
    printf("Removido: %d\n", removido);
    exibir(&f);

    return 0;
}
