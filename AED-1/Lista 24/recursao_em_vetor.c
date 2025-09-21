#include <stdio.h>
#include <stdlib.h>

// fazer recursao pelo ultimo elemento reduz os parametros a serem passados na funcao

float somaArray(float v[], int N){ 
    float soma = 0;
    
    if(N == 1) soma = v[0]; // caso base
    
    else if(N>1) soma = v[N-1] + somaArray(v, N-1); // ultimo elemento mais a soma do resto
       
    return soma;
} // fim somaArray()
