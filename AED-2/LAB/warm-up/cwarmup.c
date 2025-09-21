#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAX_NAME 50
#define MAX_ATLETES 100

// estrutura Atleta
typedef struct {
    char name[MAX_NAME];
    int peso;
} Atleta;

int main()
{
    Atleta atletas[MAX_ATLETES];
    int count = 0;

    // leitura ate EOF
    while (count < MAX_ATLETES && scanf("%s %d", atletas[count].name, &atletas[count].peso) == 2) {
        count++;
    }

    // bubble sort: ordena por peso decrescente e empate ordem alfabetica
    for (int i = 0; i < count - 1; i++) {
        for (int j = 0; j < count - 1 - i; j++) {
            bool troca = false;

            if (atletas[j].peso < atletas[j + 1].peso) {
                troca = true;
            } else if (atletas[j].peso == atletas[j + 1].peso) {
                if (strcmp(atletas[j].name, atletas[j + 1].name) > 0) {
                    troca = true;
                }
            }

            if (troca) {
                Atleta temp = atletas[j];
                atletas[j] = atletas[j + 1];
                atletas[j + 1] = temp;
            }
        }
    }

    // impressao
    for (int i = 0; i < count; i++) {
        printf("%s %d\n", atletas[i].name, atletas[i].peso);
    }
    return 0;
}
