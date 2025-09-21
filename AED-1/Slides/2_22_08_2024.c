#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
    // input
    float n, soma=0;
    printf("\nDigite (0) para sair\n");
    printf("\nValor de n: ");
    scanf("%f", &n);
    
    // uso de flag
    while (n != 0){
        soma += n;
        printf("\nValor de n: ");
        scanf("%f", &n);
    }
    
    // fora do loop
    printf("\nSoma: %.1f\n", soma);

    return 0;
}
