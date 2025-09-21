#include <stdlib.h>
#include <stdio.h>

int maisVelho(int M, int A, int B){
    int C = M - (A + B);
    int resultado;
    
    if (A > B && A > C) {
        resultado = A;
    } else if (B > A && B > C) {
        resultado = B;
    } else {
        resultado = C;
    }
    
    return resultado;
}

int main()
{
     int M; scanf("%i", &M); // Idade da Dona Mônica
     int A; scanf("%i", &A); // Idade de um dos filhos
     int B; scanf("%i", &B); // Idade de outro filho
     printf("%i", maisVelho(M,A,B) );
     return 0;
}
