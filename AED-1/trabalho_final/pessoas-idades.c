// CODIGO PARA LER E ESCREVER, PESSOA E IDADE

/*
SEM: arquivos, diretiva, set_locale
COM: POO, for e while, funcoes
PROBLEMA: fazer entrsda para TAM e continuacao
*/
#include <stdio.h>
#include <stdlib.h>

/* variaveis globais
tamanho logico e fisico */
const int MAX = 4;
int TAM = 0;

/* estruturas de POO
pessoa
*/
typedef struct{
    char nome[50];
    int idade;
}Pessoa;

/* funcoes e procedimentos */
void leiaPessoa(Pessoa PESSOAS[]){
    printf("\nNome: ");
    fgets(PESSOAS[TAM].nome, 50, stdin);
    printf("\nIdade: ");
    scanf("%d", &PESSOAS[TAM].idade);
    getchar();
    TAM++;

}

void escrevePessoa(Pessoa PESSOA[], int i){
    printf("\nNome = %s", PESSOA[i].nome);
    printf("Idade = %d\n", PESSOA[i].idade);
}

void listaPessoas(Pessoa PESSOAS[]){
    for(int i=0; i<TAM; i++){
        escrevePessoa(PESSOAS, i);
    }
    printf("\n");
}

int main()
{
    Pessoa PESSOAS[MAX];

    while(TAM < MAX){
        leiaPessoa(PESSOAS);
    } // repeticao ate o tamanho maximo

    listaPessoas(PESSOAS);
    return 0;
}
