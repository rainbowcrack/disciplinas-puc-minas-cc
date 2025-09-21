#include <stdio.h>

#define MAX 100005

int seq[MAX];  // Sequência de números

// Função para calcular o resultado da consulta de produto
char produto_resultado(int I, int J) {
    int produto = 1;
    for (int i = I; i <= J; i++) {
        if (seq[i] == 0) {
            return '0'; // Se houver um zero, o produto é zero
        } else {
            produto *= seq[i];
        }
    }
    
    if (produto > 0) {
        return '+'; // Produto positivo
    } else {
        return '-'; // Produto negativo
    }
}

int main() {
    int N, K;
    scanf("%d %d", &N, &K);
    
    // Inicializa a sequência
    for (int i = 1; i <= N; i++) {
        scanf("%d", &seq[i]);
    }
    
    // Processar os comandos
    for (int i = 0; i < K; i++) {
        char command;
        scanf(" %c", &command);
        
        if (command == 'C') {
            // Comando de mudança
            int idx, value;
            scanf("%d %d", &idx, &value);
            seq[idx] = value;  // Modifica o valor na posição 'idx'
        } else if (command == 'P') {
            // Comando de produto
            int I, J;
            scanf("%d %d", &I, &J);
            // Calcular o resultado do produto
            printf("%c", produto_resultado(I, J));
        }
    }
    
    printf("\n");
    return 0;
}
