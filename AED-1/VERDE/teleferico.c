#include <stdlib.h>
#include <stdio.h>

int minimoDeViagens(int A, int C) {
    int grupo = A/C; // divisao inteira
    return grupo + 1; // margem de erro
} // fim minimoDeViagens()

int main()
{
     int C; scanf("%i", &C); // Capacidade da cabine
     int A; scanf("%i", &A); // Número total de alunos na turma
     printf("%i", minimoDeViagens(A,C) ); // inverter a leitura
     return 0;
}
