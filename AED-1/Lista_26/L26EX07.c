#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define TAM 10

/* escrever uma string de forma invertida
ROMA será AMOR */

void escreveInvertido(char str[]){
    // strlen conta o tamanho real da string
    for(int i = strlen(str) - 1; i >= 0; i--){
        printf(" %c", str[i]);
    }
}

int main()
{
    char str[TAM]; 
    fgets(str, sizeof(str), stdin);
    escreveInvertido(str);
    return 0;
}
