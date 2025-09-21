#include <stdlib.h>
#include <stdio.h>

int main() {
    // declarar variavel
    int divisiveis=0, num;
    
    // loop para erro
    do {
        printf("\nInsira um numero: ");
        scanf("%d", &num);
    } while (num < 1);
    
    // loop para divisores
    for (int i=1; i <= num; i++){
        
        if (num % i == 0) divisiveis++;
    }
    
    printf("Existem %d divisores para o numero %d", divisiveis, num);

    return 0;
}
