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
    int n;
    int vetor_int[n], indice_impar[n], indice_par[n];
    int pares, impares;
    int lim_inferior, lim_superior;
    double vetor_double[n];
    
    // pega dados do usuario
    printf("Insira o tamanho do vetor: ");
    scanf("%d", &n);
    printf("Insira o limite inferior do vetor: ");
    scanf("%d", &lim_inferior);
    printf("Insira o limite superior do vetor: ");
    scanf("%d", &lim_superior);

    // percorre o vetor e imprime os numeros aleatorios
    for(int i=0; i<n; i++){
        vetor_double[i] = gera_aleatorio_double(lim_inferior,lim_superior);
        printf(" %lf \t", vetor_double[i]);
    }
    return 0;
}
