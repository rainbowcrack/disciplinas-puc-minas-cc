#include <stdio.h>
#include <stdlib.h>

float perimetroQuadrado(float *lado){
    float *perimetro = malloc(sizeof(float));
    *perimetro = *lado *4;
    
    return *perimetro;
}

// ---------------------------------------------

int main(){
    float *lado = malloc(sizeof(float));
    scanf("%f", lado);
    
    printf("%f", perimetroQuadrado(lado));
    
    return 0;
}
