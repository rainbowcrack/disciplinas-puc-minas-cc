#include <stdio.h>
#include <stdlib.h>

#define TAM 10  // Tamanho máximo da lista

// Estrutura da lista estática
typedef struct {
    int vetor[TAM];  
    int tamanho; // ponteiro
} Lista;

// Função para inicializar a lista
void inicializar(Lista *lista) {
    lista->tamanho = 0;
}

// Verifica se a lista está cheia
int cheia(Lista *lista) {
    return lista->tamanho == TAM;
}

// Verifica se a lista está vazia
int vazia(Lista *lista) {
    return lista->tamanho == 0;
}

// Insere um elemento na lista
void inserir(Lista *lista, int valor) {
    if (cheia(lista)) {
        printf("Lista cheia!\n");
        return;
    }
    lista->vetor[lista->tamanho] = valor;
    lista->tamanho++;
}

// Remove um elemento da lista (remove o último elemento)
int remover(Lista *lista) {
    if (vazia(lista)) {
        printf("Lista vazia!\n");
        return -1;  // Valor indicativo de erro
    }
    lista->tamanho--;
    return lista->vetor[lista->tamanho];
}

// Exibe os elementos da lista
void exibir(Lista *lista) {
    printf("Lista: ");
    for (int i = 0; i < lista->tamanho; i++) {
        printf("%d ", lista->vetor[i]);
    }
    printf("\n");
}

// Função principal
int main() {
    Lista lista;
    inicializar(&lista);

    // Inserindo elementos
    inserir(&lista, 10);
    inserir(&lista, 20);
    inserir(&lista, 30);
    exibir(&lista);

    // Removendo um elemento
    int removido = remover(&lista);
    printf("Removido: %d\n", removido);
    exibir(&lista);

    // Inserindo mais elementos
    inserir(&lista, 40);
    inserir(&lista, 50);
    exibir(&lista);

    return 0;
}
