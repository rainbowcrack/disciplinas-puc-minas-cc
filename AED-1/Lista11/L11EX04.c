#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

int leia(){
    int x;
    printf("Digite um numero: ");
    scanf("%d", &x);
    return x;
} // fim do leia()

bool ehpar(int x){
    bool par = false;
    if (x % 2 == 0) par = true;
    return par;
    } // fim de ehpar()

void escrevaResultado(float x, float s){
    if (ehpar(x)) printf("\nPar");
    else printf("\nImpar");
} // fim escrevaResultado()

int main() {
    printf("\nPrograma para saber se eh par ou impar\n");
    
    float a = leia();
    bool resultado = ehpar(a);
    escrevaResultado(a, resultado);

    return 0;
} // fim da main()
