#include <stdio.h>

#define NUM_PESSOAS 5

// Definindo a estrutura Pessoa
struct Pessoa {
    char nome[100];
    int idade;
};

// Função recursiva para listar todas as pessoas
void listarPessoas(struct Pessoa pessoas[], int indice, int numPessoas) {
    // Caso base: quando o índice atingir o número total de pessoas, a recursão termina
    if (indice == numPessoas) {
        return;
    }

    // Imprime a pessoa no índice atual
    printf("Nome: %s, Idade: %d\n", pessoas[indice].nome, pessoas[indice].idade);

    // Chama a função recursivamente para o próximo índice
    listarPessoas(pessoas, indice + 1, numPessoas);
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

    // Chama a função recursiva para listar as pessoas
    printf("Lista de pessoas:\n");
    listarPessoas(pessoas, 0, NUM_PESSOAS);
    
    return 0;
}
