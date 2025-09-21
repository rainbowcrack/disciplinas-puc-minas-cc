// a soma de numeros lidos com flag igual a 0
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
    // input
    float n=1, soma;
    printf("\nDigite (0) para sair\n");
    while (n) {
        if (n != 0){
            printf("\nValor de n: ");
            scanf("%f", &n);
            soma += n;
            printf("\nSoma: %.1f\n", soma);
        } else {
            printf("\nSoma: %.1f\n", soma); // podia ser um break
        }
    }

    return 0;
}
