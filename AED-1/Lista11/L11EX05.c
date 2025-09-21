#include <stdlib.h>
#include <stdio.h>

int leia(){
    int x;
    printf("Digite um numero: ");
    scanf("%d", &x);
    return x;
} // fim do leia()

long fatorial(int x){
    long fat = 1;
    for (int i=x; i > 1; i--){
        fat *= i;
    }
    return fat;
    } // fim de fatorialr()

void escrevaResultado(int x, long s){
    printf("\nA fatorial de %d = %ld", x, s);
} // fim escrevaResultado()

int main() {
    printf("\nPrograma para calcular a fatorial\n");
    
    int a = leia();
    long resultado = fatorial(a);
    escrevaResultado(a, resultado);

    return 0;
}
