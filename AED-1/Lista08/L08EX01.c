#include <stdlib.h>
#include <stdio.h>

int main() {
    // declare
    int n, num, par=0, impar=0;
    
    // loop de erro
    do {
        printf("\nInsira a quantidade: ");
        scanf("%d", &n);
    } while (n < 0);
    
    // loop para numeros pares e impares
    for (int i = 0; i < n; i++) {
        do {
            printf("\nNumero: ");
            scanf("%d", &num);
        } while (n < 0);
        
        if (num % 2 == 0) par++;
        else impar++;
    } // fim do for
    
    printf("\nQuantidade de numeros pares: %d", par);
    printf("\nQuantidade de numeros impares: %d", impar);
  
    return 0;
}
