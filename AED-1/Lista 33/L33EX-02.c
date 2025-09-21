#include <stdio.h>

#define NUM_PESSOAS 5

// Definindo a estrutura Pessoa
struct Pessoa {
    char nome[100];
    int idade;
};

// Função para listar todas as pessoas de forma iterativa
void listarPessoas(struct Pessoa pessoas[], int numPessoas) {
    // Laço para percorrer o arranjo e listar as pessoas
    for (int i = 0; i < numPessoas; i++) {
        // Imprime a pessoa no índice i
        printf("Nome: %s, Idade: %d\n", pessoas[i].nome, pessoas[i].idade);
    }
}

int main() {
    // Criando um arranjo de pessoas
    struct Pessoa pessoas[NUM_PESSOAS] = {
        {"João", 25},
        {"Maria", 30},
        {"Carlos", 22},
        {"Ana", 28},
        {"Lucas", 35}
    };

    // Chama a função para listar as pessoas de forma iterativa
    printf("Lista de pessoas:\n");
    listarPessoas(pessoas, NUM_PESSOAS);
    
    return 0;
}
