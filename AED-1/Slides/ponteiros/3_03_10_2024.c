#include <stdio.h>
#include <stdlib.h>

// garante a leitura de todos os dados do arquivo, sem loop
int main()
{
    FILE* arquivo = fopen("exemplo.dat", "r");
    if(arquivo != NULL){
        int x;

        fscanf(arquivo, "%d", &x);
        while(!feof(arquivo)){
            printf("\n%d", x); // ou fprintf(stdout, "\n%d", x)
            fscanf(arquivo, "%d", &x);
        }
    }

    fclose(arquivo);

    return 0;
}
