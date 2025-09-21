#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>
#include <stdbool.h>

int main() {
    int atletico = 0, cruzeiro = 0, outros = 0;
    char time;
    bool erro;

    printf("\n\rSendo: Atletico [A], Cruzeiro [C] e Outro time [O]\n");

    // loop para erro
    do{
        printf("\nDigite X para sair\n\n");
        printf("\nInforme o time [A/C/O]: ");
        scanf(" %c", &time);
        time = toupper(time);
        erro = (time != 'A' && time != 'C' && time != 'O');
    } while (erro);

    // acumulador no time
    while (time != 'X') {
        switch (time) {
            case 'A':
                atletico++;
                break;

            case 'C':
                cruzeiro++;
                break;

            case 'O':
                outros++;
        }

        do {
            printf("\nDigite X para sair\n");
            printf("\nInforme o time [A/C/O]: ");
            scanf(" %c", &time);
            time = toupper(time);
            erro = (time != 'A' && time != 'C' && time != 'O' && time != 'x');
            } while (erro);

    } int total = (atletico + cruzeiro + outros);

    float percentualAtleticano = (float) atletico/total * 100;
    float percentualCruzeiro = (float) cruzeiro/total * 100;
    float percentualOutros = (float) outros/total * 100;

    printf("\n%f%% atletico", percentualAtleticano);
    printf("\n%f%% cruzeiro", percentualCruzeiro);
    printf("\n%f%% outros", percentualOutros);

    // loop para erro




  return 0;

}
