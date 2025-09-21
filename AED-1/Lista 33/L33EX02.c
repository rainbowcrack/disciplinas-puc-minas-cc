#include <stdio.h>

#define NUM_FUNCIONARIOS 5

// Definindo a estrutura Funcionario
struct Funcionario {
    char nome[100];
    float salario;
};

// Função para calcular a média salarial
float calcularMediaSalarial(struct Funcionario funcionarios[], int numFuncionarios) {
    float somaSalarios = 0.0;
    
    // Soma todos os salários dos funcionários
    for (int i = 0; i < numFuncionarios; i++) {
        somaSalarios += funcionarios[i].salario;
    }
    
    // Retorna a média salarial
    return somaSalarios / numFuncionarios;
}

// Função para contar os funcionários com salário acima da média
int contarAcimaDaMedia(struct Funcionario funcionarios[], int numFuncionarios, float media) {
    int count = 0;
    
    // Conta os funcionários com salário acima da média
    for (int i = 0; i < numFuncionarios; i++) {
        if (funcionarios[i].salario > media) {
            count++;
        }
    }
    
    return count;
}

int main() {
    // Criando um arranjo de funcionários
    struct Funcionario funcionarios[NUM_FUNCIONARIOS] = {
        {"João", 2500.0},
        {"Maria", 3000.0},
        {"Carlos", 1500.0},
        {"Ana", 5000.0},
        {"Lucas", 3500.0}
    };
    
    // Calculando a média salarial
    float mediaSalarial = calcularMediaSalarial(funcionarios, NUM_FUNCIONARIOS);
    
    // Contando os funcionários com salário acima da média
    int quantidadeAcimaDaMedia = contarAcimaDaMedia(funcionarios, NUM_FUNCIONARIOS, mediaSalarial);
    
    // Exibindo o resultado
    printf("Média salarial: %.2f\n", mediaSalarial);
    printf("Quantidade de funcionários com salário acima da média: %d\n", quantidadeAcimaDaMedia);
    
    return 0;
}
