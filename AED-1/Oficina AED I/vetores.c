#include <stdio.h>
#include <stdlib.h>
#include <time.h>
// o random esta definifido na biblioteca <time.h>, pegar numeros aleatorios para o vetor
// 'srandc' pega a semente

int gera_aleatorio_int(int lim_inferior, int lim_superior){
    return rand()%(lim_superior - lim_inferior)+lim_inferior;

}

int main()
{
    // semente, comecar numeros aleatorios de um espaco diferente
    // lembra seed de minecraft

    srand(time(NULL));

    // criacao de semente
    int n=50;
    int vetor_int[n], indice_impar[n], indice_par[n];
    int pares, impares;
    int lim_inferior, lim_superior;

    lim_inferior=0, lim_superior=10;
    pares = 0; impares = 0;

    for(int i=0; i<n; i++){
        vetor_int[i] = gera_aleatorio_int(lim_inferior,lim_superior);
        printf(" %d \n", vetor_int[i]);
    }

    return 0;
}
