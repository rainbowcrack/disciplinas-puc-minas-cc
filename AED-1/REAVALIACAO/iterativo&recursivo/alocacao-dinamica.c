#include <stdio.h>
#include <stdlib.h>

int main(){
    
    // alocacao dinamica
    float *a =  malloc(sizeof(float));
    float *b = malloc(sizeof(float));
    float *sum = malloc(sizeof(float));
    
    // faz a leitura
    scanf("%f", a);
    scanf("%f", b);
    
    // soma dinamica
    *sum = *a + *b;
    
    
    printf("%f", *sum);
    
    // libera memoria
    free(a);
    free(b);
    free(sum);
    
    return 0;
}
