#include <stdio.h>
#include <stdlib.h>

// criacao de arquivos com ponteiros, direto do codigo fonte
int main()
{
    FILE* arquivo = fopen("exemplo.dat", "a"); // substitui por "w"
    fprintf(arquivo, "%d\n", 53); // colocar a minha idade, 18
    fprintf(arquivo, "%d\n", 52);

    fclose(arquivo);

    return 0;
}
