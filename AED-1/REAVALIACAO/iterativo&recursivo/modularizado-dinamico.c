#include <stdio.h>
#include <stdlib.h>

// Função que realiza a soma e retorna o valor através de referência
float somaAlocada(float *a, float *b) {
    float *sum = malloc(sizeof(float));
    // Calcula a soma e armazena no ponteiro 'sum'
    *sum = *a + *b;
    
    return *sum; // Retorna 0 para indicar sucesso
}

int main() {
    // Alocação dinâmica
    float *a = malloc(sizeof(float));
    float *b = malloc(sizeof(float));
    
    scanf("%f", a);  // Lê o valor de 'a'
    scanf("%f", b);  // Lê o valor de 'b'

    somaAlocada(a, b);

    // Imprime o resultado da soma
    printf("%f\n", somaAlocada(a, b));

    // Libera a memória alocada
    free(a);
    free(b);

    return 0;
}
