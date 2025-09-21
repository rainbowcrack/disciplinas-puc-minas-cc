#include <stdio.h>
#include <stdlib.h>

// criacao de arquivos com ponteiros, direto do codigo fonte
// em binario, nao legivel
// %s eh string
int main()
{
    FILE* arquivo = fopen("novo.dat", "wb"); // substitui por "w"
    fprintf(arquivo, "%s\n", "Izabel");
    fprintf(arquivo, "%s\n", "Mamae"); // colocar a minha idade, 18
    fprintf(arquivo, "%s\n", "Papai");

    fclose(arquivo);

    return 0;
}
