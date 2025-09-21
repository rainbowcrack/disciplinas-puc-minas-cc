#include <stdio.h>
#include <stdlib.h>
void apresentacao();
float leiaReal();
float soma2(float, float);
void escreva(float, float, float);

int main()
{
    apresentacao();
    float a = leiaReal();
    float b = leiaReal();
    float soma = soma2(a, b);

    void apresentacao() {
        printf("\nsoma de 2 numeros\n\n");
    }
    float leiaReal() {
        float x;
        printf("\nDigite numero: ");
        scanf("%f", &x);
        return x;
    }
    float soma2(float x, float y){
        return x + y;
    }
    void escreva(float x, float y, float s){
        printf("\n%.2f + %.2f = %.2f", x, y, s);
    }
    return 0;
}
