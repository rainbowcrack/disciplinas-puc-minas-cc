#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// o random esta definifido na biblioteca <time.h>, pegar numeros aleatorios para o vetor
// 'srandc' pega a semente

double gera_aleatorio_double(double lim_inferior, double lim_superior){
    double range = lim_superior-lim_inferior;
    double div = RAND_MAX/range;
    return rand()/div + lim_inferior;
}

int main()
{
    // semente, comecar numeros aleatorios de um espaco diferente com o horario do computador
    // lembra seed de minecraft

    //srand(time(NULL));

    // criacao de semente
    int n=50;
    int vetor_int[n], indice_impar[n], indice_par[n];
    int pares, impares;
    int lim_inferior, lim_superior;
    double vetor_double[n];

    lim_inferior=-30, lim_superior=-10; // defina o limite

    // percorre o vetor e imprime os numeros aleatorios
    for(int i=0; i<n; i++){
        vetor_double[i] = gera_aleatorio_double(lim_inferior,lim_superior);
        printf(" %lf \t", vetor_double[i]);
    }
    return 0;
}
