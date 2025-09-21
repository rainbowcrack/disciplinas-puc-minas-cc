#include <stdlib.h>
#include <stdio.h>

// programa para saber se o numero eh primo
int main() {
    // declarar variavel
    int divisiveis=0, num;
    
    // loop para erro
    do {
        printf("\nInsira um numero: ");
        scanf("%d", &num);
    } while (num < 1);
    
    // loop para divisores
    for (int i=2; i <= num/2; i++){
        
        if (num % i == 0) divisiveis++;
    }
    
    // condicional para saber se eh primo ou nao
    if (divisiveis > 0) printf("\nNao eh primo");
    else printf("\nEh primo");

    return 0;
}
