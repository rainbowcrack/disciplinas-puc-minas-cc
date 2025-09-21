#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// ponto de partida para o trabalho final
// CRUD eh o SQL

const int MAX=80, TAM=0; // constante global

/*
0 - ao sair, devera ser exibida uma mensagem de agradecimento pelo uso do programa
1- considere o seguinte dominio para a nota 0...100
2 - considere ser sessenta a nota minima para a aprovacao
3 - lembre-se que a amplitude corresponde a diferenca entre o maior e o menor
*/

int menu(){
    int opcao;
    bool erro;
    do{
        printf("\n\t0 - Sair");
        printf("\n\t1 - Cadastrar uma nota");
        printf("\n\t2 - Informar o numero de alunos aprovados");
        printf("\n\t3 - Informar a amplitude");
        printf("\nSua opcao; ");
        scanf("%d", &opcao);
        erro = opcao < 0 || opcao > 3;
        if(erro) printf("\nInforme um valor de 0-3");
    }while(erro)

    return erro;
} // fim menu()

void cadastraNota(float notas[]){
    float nota;
    bool erro;

    do{
        printf("\nNota: ");
        scanf("%f", &nota);
        erro = nota < 0 || nota > 100;
    }while(erro);

    notas[TAM] = nota;
    TAM++;
} // fim CadastrarNota()

void despedida(){
    printf("\n\nObrigada!");
} // fim despedida()

void informeAprovados(float notas[]){
    printf("\nO numero de aprovados = %f", qtAprovados(notas));
} // fim informeAprovados()

int qtAprovados(float notas[]){
    int count = 0;

    for(int i = 0; i < TAM; i++){
        if(notas[i] >= 60){
            count++
        }
    }
} // fim qtAprovados()

void intAmplitude(float notas){
    printf("\nA amplitude das notas = %f", amplitude(notas));
} // fim intAmplitude()

float amplitude(float v[]){
    return maiorArray(v) - menorArray(v);
} // fim amplitude()

int main()
{
    float notas[MAX];
    int opcao;

    do{
        int opcao = menu();

        switch(opcao){
            case 0:
                despedida();
                break;

            case 1:
                cadastraNota(notas);
                break;

            case 2:
                informeAprovados(notas);
                break;

            case 3:
                informeAmplitude(notas);
                break;

            default:
                printf("\nOpcao invalida");
        } // fim switch(opcao)

    }while(opcao != 0);

    return 0;
} // fim da main();
