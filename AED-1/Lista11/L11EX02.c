#include <stdlib.h>
#include <stdio.h>

float leiaReal(){
    float x;
    printf("Digite um numero real: ");
    scanf("%f", &x);
    return x;
} // fim do leiaReal()

float maior(float x, float y){
    float maior = y; // fazer uma aposta e trocar
    if (x > y) {
        x = maior;
    } // fim de maior()

    return maior;
} // fim da soma()

void escrevaResultado(float x, float y, float s){
    printf("\nEntre %.2f e %.2f, o maior eh %.2f\n", x, y, s);
} // fim escrevaResultado()

int main() {
    printf("\nPrograma para encontrar o maior valor\n");
    
    float a = leiaReal();
    float b = leiaReal();
    float resultado = maior(a,b);
    escrevaResultado(a, b, resultado);

    return 0;
}
