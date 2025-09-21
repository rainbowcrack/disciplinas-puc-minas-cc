// crie uma calculadora que utilize equações de soma, subtracao, divisao, multiplicacao
#include <stdlib.h>
#include <stdio.h>

float somar(float x, float y) {
    return x + y;
} // fim somar()

float subtrair(float x, float y) {
    return x - y;
} // fim subtrair()

float dividir(float x, float y) {
    return x/y;
} // fim dividir()

float multiplicar(float x, float y) {
    return x * y;
} // fim multiplicar()

void menu(char opcao, float resultado){
    printf("\nEscolha uma opcao: ");
    printf("\n1 - Somar");
    printf("\n2 - Subtrair");
    printf("\n3 - Dividir");
    printf("\n4- Multiplicar");
    printf("\nSua opcao: ");
    scanf("% c", &opcao);
    
    switch (opcao) {
        case '1':
        resultado = somar(x,y);
        break;
        
        case '2':
        resultado = subtrair(x,y);
        break;
        
        case '3':
        resultado = dividir(x,y);
        break;
        
        case '4':
        resultado = multiplicar(x,y):
        default:
        printf("Insira outro valor");
        break;
        
        return resultado;
    }
}

int main() {
    float 
    
    

    return 0;
}
