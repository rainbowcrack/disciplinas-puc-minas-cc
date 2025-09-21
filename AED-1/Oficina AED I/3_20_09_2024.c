#include <stdlib.h>
#include <stdio.h>

// #include "triangulo.h"
// criei uma pasta para a minha funcao e eu chamei minha biblioteca

int ehTriangulo(float, float, float);
int tipoTriangulo(float, float, float);

int main(){


    float a, b, c;
    int resultado;

    printf("Entre com lados: ");
    scanf(" %f %f %f", &a, &b, &c);

    printf("Eh triangulo (1) sim, (0) nao. \n %d", ehTriangulo(a,b,c));
    return 0;
}

int ehTriangulo(float a, float b, float c){
    float soma_bc, soma_ac, soma_ab;

    soma_bc = b + c;
    soma_ac = a + c;
    soma_ab = a + b;

    if ((a < soma_bc) && (b < soma_ac) && (c < soma_ab)){
        return 1;

    }
    else return 0;
}
