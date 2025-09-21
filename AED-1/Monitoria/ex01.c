#include <stdio.h>
#include <stdlib.h>

float leiaReal(float x) {
    printf("Insira um número: ");
    scanf("%f", &x);
    return x;
} // fim leiaReal()

float soma(float num1, float num2) {
    return num1 + num2;
} // fim soma()

void escrevaResultado(float x, float y, float s) {
    printf("\n%.2f + %.2f = %.2f", x, y, s);
} // fim escrevaResultado()

int main() {
    // procedimento que exibe a soma de dois numeros
    float a, b, num1, num2;
    num1 = leiaReal(a);
    num2 = leiaReal(b);
    float resposta = soma(num1, num2);
    escrevaResultado(num1, num2, resposta);

    return 0;
} // fim da main()
