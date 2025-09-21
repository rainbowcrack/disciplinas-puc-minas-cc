#include <stdio.h>
#include <stdlib.h>

// Variavel Global
// define a constante como variavel global
const int TAM = 10;

// declarar as funcoes antes, mostrar o tipo e falar que eh vetor

    float mediaIdades(int A[]);
    int somaIdades(int A[]);
    int acimaMedia(int A[], float);
    void leiaIdades(int A[]);

    int main(){
        int idades[10];
        leiaIdades(idades);
        float media = mediaIdades(idades);
        printf("\nMedia = %f", media);
        printf("\n\n%d acima", acimaMedia(idades, media));
        return 0;
    } // fim da main()


    float mediaIdades(int A[]){
        return (float) somaIdades(A) / TAM; // sem coercao de tipo, o 10 pode virar 10.0
    } // fim mediaIdades()

    int somaIdades(int A[]){
        int soma = 0;
        for(int i = 0; i < TAM; i++){
            soma += A[i];
        }
        return soma;
    } // fim somaIdades()

    int acimaMedia(int A[], float media){
        int acima = 0;
        for(int i = 0; i < TAM; i++){
            if(A[i] > media){
                acima++;
            }
        }
        return acima++;
    }

    void leiaIdades(int idades[]){
        for(int i = 0; i < TAM; i++){
            printf("\n Insira a %d.a idade: ", i + 1);
            scanf("%d", &idades[i]);
        }

    } // fim escrevaArray()
