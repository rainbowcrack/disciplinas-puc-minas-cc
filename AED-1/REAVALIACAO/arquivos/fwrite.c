#include <stdio.h>
#include <stdlib.h>

int main(){
    FILE *arquivo = fopen("teste.txt", "w");
    
    int x = 123;
    fwrite(&x, sizeof(int), 1, arquivo);
    
    return 0;
}
