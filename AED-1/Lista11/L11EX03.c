#include <stdlib.h>
#include <stdio.h>

float leiaReal(){
    float x;
    printf("Digite o lado do quadrado: ");
    scanf("%f", &x);
    return x;
} // fim do leiaReal()

float perimetro(float x){
    float perimetro;
    perimetro = x * 4;
    return perimetro;
    } // fim de perimetro()

void escrevaResultado(float x, float s){
    printf("\nCom o lado %.2f, o perimetro eh %.2f\n", x, s);
} // fim escrevaResultado()

int main() {
    printf("\nPrograma para encontrar o perimetro de um quadrado qualquer\n");
    
    float a = leiaReal();
    float resultado = perimetro(a);
    escrevaResultado(a, resultado);

    return 0;
}
