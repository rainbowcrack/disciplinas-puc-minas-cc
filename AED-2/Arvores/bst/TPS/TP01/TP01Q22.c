/**********************************
* TP01Q22                         *
* SOMA DE DIGITOS (C) - RECURSIVO *
**********************************/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

// funcao para somar numeros recursivamente
int somaRecursiva(int num){
    // caso base
    if(num == 0){ 
        return 0;
    } else {
        
        /* pega o num pelo mod
        pula para o proximo na divisao por 10
        a recursao sera um acumulador
        */
        
        return (num % 10) + somaRecursiva(num/10);
    }
}

int main(){

    int num;
    char entrada[100];
    
    fgets(entrada, 100, stdin);
    entrada[strcspn(entrada, "\n")] = '\0'; // remove a quebra de linha

    // compara as chaves
    while (strncmp(entrada, "FIM", 3) != 0) {
        num = atoi(entrada); // converte de string para int
        
        printf("%d\n", somaRecursiva(num)); // chama a funcao recursiva

        fgets(entrada, 100, stdin);
        entrada[strcspn(entrada, "\n")] = '\0'; 
    }
    
    return 0;
}
