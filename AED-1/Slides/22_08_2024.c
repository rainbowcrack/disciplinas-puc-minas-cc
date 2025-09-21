// calcular o n de dias vividos ate o ultimo aniversario, idade (0-150)
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>

int main() {
    // input
    int idade, dias;
    bool erro;

    // loop para erro
    do {
        printf("\nDigite a sua idade: ");
        scanf("%d", &idade);
        erro = idade < 0 || idade > 150;
        if(erro) printf("\nErro!\n");

    } while (erro);
        dias = idade * 365;
        printf("\nO numero de dias vivido eh %d\n", dias);

    return 0;
}
