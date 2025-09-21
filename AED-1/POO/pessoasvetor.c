#include <stdio.h>
#include <stdlib.h>

const int MAX = 100;
int TAM = 0;

typedef struct{
    char nome[50];
    int idade;
}Pessoa; // fim do POO

void leiaPessoa(Pessoa PESSOAS[]){
    printf("\nNome: ");
    fgets(PESSOAS[TAM].nome, 50, stdin);
    printf("\nIdade: ");
    scanf("%d", &PESSOAS[TAM].idade);
} // fim do leiaPessoa()

void escrevaPessoa(Pessoa PESSOA[], int i){
    printf("\nNome = %s", PESSOA[i].nome);
    printf("\nIdade = %d", PESSOA[i].idade);
}

void listaPessoas(Pessoa PESSOAS[]){
    for(int i=0; i<TAM; i++){
        escrevaPessoa(PESSOAS, i);
    }
}

int main(){
    Pessoa PESSOAS[MAX];
    leiaPessoa(PESSOAS);
    return 0;
  
} // fim da main()
