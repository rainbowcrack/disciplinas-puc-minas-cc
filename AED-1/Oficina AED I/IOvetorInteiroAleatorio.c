#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// o random esta definifido na biblioteca <time.h>, pegar numeros aleatorios para o vetor
// 'srandc' pega a semente pelo horario do pc

// funcao que cria numero aleatorio
int gera_aleatorio_int(int lim_inferior, int lim_superior){
    return rand()%(lim_superior - lim_inferior)+lim_inferior;
}

int main()
{
    // semente, comecar numeros aleatorios de um espaco diferente com o horario do computador
    // criacao de semente, lembra seed de minecraft

    srand(time(NULL));

// cria o vetor
    int n;
    int vetor_int[n], indice_impar[n], indice_par[n];
    int pares, impares;
    int lim_inferior, lim_superior;
    pares = 0; impares = 0;
    
// pega dados do usuario
    printf("Insira o tamanho do vetor: ");
    scanf("%d", &n);
    printf("Insira o limite inferior do vetor: ");
    scanf("%d", &lim_inferior);
    printf("Insira o limite superior do vetor: ");
    scanf("%d", &lim_superior);

    // percorre o vetor e imprime os numeros aleatorios
    for(int i=0; i<n; i++){
        vetor_int[i] = gera_aleatorio_int(lim_inferior,lim_superior);
        printf(" %d \t", vetor_int[i]);
    }
    return 0;
}
