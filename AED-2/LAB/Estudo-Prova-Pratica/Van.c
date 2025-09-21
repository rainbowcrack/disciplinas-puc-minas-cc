/**************************
 *  [Warm-up 02] Van em C *
**************************/ 

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define MAX 100

// estrutura de estudante
typedef struct{
    char nome[50];
    char regiao;
    int custo;
}Estudante;

int main()
{
    // cria array de objetos
    Estudante estudante[MAX];
    int count = 0;
    
    // condicao do EOF
    while(count < MAX && scanf("%s %c %d", estudante[count].nome, &estudante[count].regiao, &estudante[count].custo)) count++;
    
    // ordenacao: distancia menor/maior -- regiao (alfabetica) -- nome
    for(int i = 0; i < count - 1; i++){
        for(int j = 0; j < count - 1 - i; j++){
            bool trocar = false;
            
            // compara a menor distancia
            if(estudante[j].custo > estudante[j+1].custo){
                trocar = true;
            } else if(estudante[j].custo == estudante[j+1].custo){
                
                // compara por regiao ordem alfabetica em ASCII
                if(estudante[j].regiao > estudante[j+1].regiao){
                    trocar = true;
                
                // compara nome ordem alfabetica
                } else if(estudante[j].regiao == estudante[j+1].regiao){
                    if(strcmp(estudante[j].nome, estudante[j+1].nome) > 0){
                        trocar = true;
                    }
                    
                }
            }
            
            // swap
            Estudante tmp;
            tmp = estudante[j];
            estudante[j] = estudante[j+1];
            estudante[j+1] = tmp;
        }
    }
    
    // resultado
    for(int i = 0; i < count; i++){
        printf("%s %c %d\n", estudante[i].nome, estudante[i].regiao, estudante[i].custo);
    }
    
    return 0;
}
