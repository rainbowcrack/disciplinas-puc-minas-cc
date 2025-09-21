#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE* arquivo = fopen("exemplo.dat", "r");
    if(arquivo != NULL){
        int x;
        for(int i = 1; i <= 3; i++){ // loop para pegar a minha idade e dos meus pais
            fscanf(arquivo, "%d", &x);
            printf( "\n%d", x); // ou fprintf(stdout, "\n%d", x)
        }
    }

    fclose(arquivo);

    return 0;
}
