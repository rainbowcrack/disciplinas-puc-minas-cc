#include <stdio.h>
#include <stdlib.h>

int main(){
    FILE *arquivo = fopen("teste.txt", "w");
    
    for(int i=0; i<=50; i+=2){
        fprintf(arquivo, "%d\n", i);
    }
    
    
    fclose(arquivo);
    
    
    
    return 0;
}
