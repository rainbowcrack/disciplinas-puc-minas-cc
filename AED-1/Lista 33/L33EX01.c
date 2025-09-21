#include <stdio.h>
#include <string.h>

// Definindo a estrutura Pessoa
struct Pessoa {
    char nome[100];
    int idade;
    float altura;
};

// Função que compara duas estruturas do tipo Pessoa
int compararPessoas(struct Pessoa p1, struct Pessoa p2) {
    // Verificando se o nome, idade e altura são iguais
    if (strcmp(p1.nome, p2.nome) == 0 && p1.idade == p2.idade && p1.altura == p2.altura) {
        return 1;  // Retorna 1 (verdadeiro) se as pessoas forem iguais
    } else {
        return 0;  // Retorna 0 (falso) se as pessoas forem diferentes
    }
}

int main() {
    // Criando duas instâncias de Pessoa
    struct Pessoa pessoa1 = {"João", 25, 1.75};
    struct Pessoa pessoa2 = {"João", 25, 1.75};
    struct Pessoa pessoa3 = {"Maria", 30, 1.65};
    
    // Comparando as pessoas
    if (compararPessoas(pessoa1, pessoa2)) {
        printf("Pessoa1 e Pessoa2 são iguais.\n");
    } else {
        printf("Pessoa1 e Pessoa2 são diferentes.\n");
    }
    
    if (compararPessoas(pessoa1, pessoa3)) {
        printf("Pessoa1 e Pessoa3 são iguais.\n");
    } else {
        printf("Pessoa1 e Pessoa3 são diferentes.\n");
    }

    return 0;
}
