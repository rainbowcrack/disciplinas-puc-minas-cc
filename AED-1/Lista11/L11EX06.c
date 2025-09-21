#include <stdlib.h>
#include <stdio.h>

int leia(){
    int x;
    printf("Digite um numero: ");
    scanf("%d", &x);
    return x;
} // fim do leia()

long exponencial(int base, int num){
    long resultado = 1;
    for (int i=1; i <= num; i++){
        resultado *= base;
    }
    return resultado;
    } // fim de exponencial()

void escrevaResultado(int base, int num, long s){
    printf("\n%d ^ %ld = %ld", base, num, s);
} // fim escrevaResultado()

int main() {
    printf("\nPrograma para calcular a exponencial\n");
    
    int num = leia();
    int base = leia();
    long resultado = exponencial(base, num);
    escrevaResultado(base, num, resultado);

    return 0;
}
