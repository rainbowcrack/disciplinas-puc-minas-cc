#include <stdlib.h>
#include <stdio.h>

float leiaReal(){
    float x;
    printf("Digite um numero real: ");
    scanf("%f", &x);
    return x;
} // fim do leiaReal()

float soma(float x, float y){
    return x + y;
} // fim da soma()

void escrevaResultado(float x, float y, float s){
    printf("\n%.2f + %.2f = %.2f\n", x, y, s);
} // fim escrevaResultado()

int main() {
    printf("\n\rPrograma para somar dois numeros\n");
    
    float a = leiaReal();
    float b = leiaReal();
    float resultado = soma(a,b);
    escrevaResultado(a, b, resultado);

    return 0;
}
