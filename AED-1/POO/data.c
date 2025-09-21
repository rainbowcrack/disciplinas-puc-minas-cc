#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

const int MAX_STR = 50;
const int MAX = 100;
int TAM = 0;

typedef struct{
    int dia;
    int mes;
    int ano;
}Data;

typedef struct{
    char nome[50];
    Data dataNascimento;
}Pessoa;

void escrevaPessoa(Pessoa PESSOAS[], int i){
    printf("\nNome: %s", PESSOAS[i].nome);
    printf("\nData de Nascimento: %d/%d/%d",
           PESSOAS[i].dataNascimento.dia,
           PESSOAS[i].dataNascimento.mes,
           PESSOAS[i].dataNascimento.ano
           );
}

void cadastrePessoa(Pessoa PESSOAS[]){
    fflush(stdin);
    printf("\nNome: ");
    fgets(PESSOAS[TAM].nome, MAX_STR, stdin);
    printf("\nData de nascimento: ");
    scanf("%d/%d/%d",
          &PESSOAS[TAM].dataNascimento.dia,
          &PESSOAS[TAM].dataNascimento.mes,
          &PESSOAS[TAM].dataNascimento.ano
          );
    TAM++;
}

int diasMes(Data data){
    int dias[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    return dias[data.mes-1];
}

char *mesExtenso(Data data){
    char* mes[]={"janeiro","fevereiro", "marco", "abril", "maio", "junho",
    "julho", "agosto", "setembro", "outubro", "novemebro", "dezembro"};

    return mes[data.mes-1];
}

bool ehBissexto(Data data){
    bool bissexto = false;

    if(data.ano % 4 == 0){
        return bissexto = true;
    }
}

void escreveData(Data data){
    printf("\n%d/%d/%d",
           data.dia,
           data.mes,
           data.ano);
}

void leiaData(Data* data){
    printf("\ndd/mm/aaaa: ");
    scanf("%d/%d/%d",
          &data->dia,
          &data->mes,
          &data->ano);
}

int main()
{
    Data hoje;
    hoje.dia = 31;
    hoje.mes = 10;
    hoje.ano = 2024;

    escreveData(hoje);

    Data nascimento;
    leiaData(&nascimento);
    escreveData(nascimento);

    printf("\nO mes %s tem %i dias",
           mesExtenso(nascimento),
           diasMes(nascimento));

    return 0;
}
