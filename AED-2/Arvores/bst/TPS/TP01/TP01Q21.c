/**************************************
 * TP01Q21                            *
 * INVERSÃO DE STRING (C) - RECURSIVO *
 *************************************/

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define MAX 100

// funcao para inverter string recursivamente
void inverterRecursivo(char array[MAX], int i, int j){
    char temp;
  
    if (i < j){  // condicao para continuar a troca de caracteres, caso base
        // swap com i e j
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        // chamada recursiva para inverter o restante
        inverterRecursivo(array, i + 1, j - 1);
    }
}

// recursao indireta para iniciar a recursao
void recursivoIndireto(char array[MAX]){
    inverterRecursivo(array, 0, strlen(array) - 1);
}

int main() {

    char array[MAX];

    // leitura inicial
    fgets(array, MAX, stdin);

    // verificacao para garantir que a string não esteja vazia
    if (strlen(array) > 0 && array[strlen(array) - 1] == '\n') {
        array[strlen(array) - 1] = '\0'; // remove o '\n' do final
    }

    // FLAG com "FIM"
    while (strcmp(array, "FIM") != 0) {

        // chama a funcao para inverter a string
	recursivoIndireto(array);
        printf("%s\n", array);

        // faz novamente a leitura
        fgets(array, MAX, stdin);

        // verificacao novamente
        if (strlen(array) > 0 && array[strlen(array) - 1] == '\n') {
            array[strlen(array) - 1] = '\0'; 
        }
    }

    return 0;
}
