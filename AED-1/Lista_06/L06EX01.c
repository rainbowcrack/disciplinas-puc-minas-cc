// lista 06 - exercicio 01
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>

int main() {
    // declara
    char genero;
    int idade, feminino = 0, masculino = 0, maioridade = 0, totalAlunos = 0, maior = -1, menor = 101;
    float percentualHomens, percentualMulheres, percentualMaioridade;
    bool erro;
    
    // quantidade de alunos, valor lido
    printf("\nQual a quantidade de alunos? ");
    scanf("%d", &totalAlunos);
    
    // contagem
    for (int i = 0; i < totalAlunos; i++) {
    // erro de genero
        do {
            printf("\nIndique o genero [m/f]: ");
            scanf(" %c", &genero);
            genero = toupper(genero);
            erro = genero != 'M' && genero != 'F';
            if(erro) printf("\n\aErro!\n");
        } while(erro);
        
        // erro de idade
        do {
            printf("\nInforme a idade: ");
            scanf(" %d", &idade);
            erro = idade < 0 || idade > 100;
            if (erro) printf("\n\aIdade invalida!\n");
        } while(erro);
        
            // somatorio de mulheres
            if (genero == 'F') {
                feminino++;
            // somatorio masculino
            } else {
                masculino++;
            }
            // somatorio de maiores de idade
            if (idade > 18){
                maioridade++;
            }
            // acumulador da idade da pessoa mais velha e mais nova
            if (idade > maior) maior = idade;
            if (idade < menor) menor = idade;
            
            // percentual
            percentualMulheres = (feminino / (float)totalAlunos) * 100;
            percentualHomens = (masculino / (float)totalAlunos) * 100;
            percentualMaioridade = (maioridade / (float)totalAlunos) * 100;
    }
    
    printf("\n----------------------------------------");
    
    // percentuais
    printf("\nO percentual de mulheres: %.1f%%", percentualMulheres);
    printf("\nO percentual de homens: %.1f%%", percentualHomens);
    printf("\nO percentual de maiores de idade: %1.f%%", percentualMaioridade);
    
    // idade da pessoa mais velha e mais nova
    printf("\nA idade da pessoa mais velha: %d anos", maior);
    printf("\nA idade da pessoa mais nova: %d anos", menor);
    
    printf("\n----------------------------------------");

    return 0;
}
