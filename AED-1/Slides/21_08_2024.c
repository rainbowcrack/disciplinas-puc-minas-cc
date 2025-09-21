// calcular o n de dias vividos ate o ultimo aniversario, idade (0-150)
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
    // input
    int idade, dias;
 
    // loop para erro
    do {
        printf("\nDigite a sua idade: ");
        scanf("%d", &idade);
        
    } while (idade >= 150 || idade <= 0);
        dias = idade * 365;
        printf("\nO numero de dias vivido eh %d\n", dias);

    return 0;
}
