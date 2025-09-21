#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// o random esta definifido na biblioteca <time.h>, pegar numeros aleatorios para o vetor
// 'srandc' pega a semente

// funcao que cria numero aleatorio
int gera_aleatorio_int(int lim_inferior, int lim_superior){
    return rand()%(lim_superior - lim_inferior)+lim_inferior;
}

int main()
{
    // semente, comecar numeros aleatorios de um espaco diferente com o horario do computador
    // lembra seed de minecraft

    srand(time(NULL));

    // criacao de semente
    int n=50;
    int vetor_int[n], indice_impar[n], indice_par[n];
    int pares, impares;
    int lim_inferior, lim_superior;

    lim_inferior=0, lim_superior=10;
    pares = 0; impares = 0;

    // percorre o vetor e imprime os numeros aleatorios
    for(int i=0; i<n; i++){
        vetor_int[i] = gera_aleatorio_int(lim_inferior,lim_superior);
        printf(" %d \t", vetor_int[i]);
    }

    // cria um contador para numeros pares a partir
    for(int i=0; i<n; i++){
        if(vetor_int[i]%2==0){
            indice_par[pares]=i;
            pares++;
        }
        else {
            indice_impar[impares]=i;
            impares++;
        }
    }
    
    // percorrer o novo vetor, a partir do indice

    printf("\n Os numeros pares sao: \n");

    for(int i=0; i<pares; i++){
            printf(" %d \t", vetor_int[indice_par[i]]);
        }

        printf("\n Os numeros impares sao: \n");

        for(int i=0; i<impares; i++){
            printf(" %d \t", vetor_int[indice_impar[i]]);
        }

    return 0;
}
