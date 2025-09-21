#include <stdlib.h>
#include <stdio.h>

bool buscaBinaria(int array[], int chave){
    bool resp = false;
    int esq = 0, dir = n-1, meio, diferenca;

    while(esq <= dir){
        meio = (dir + esq)/2;
        diferenca = chave - array[meio];

        if(diferenca == 0){
            resp = true;
            esq = n;
        } else if(diferenca > 0){
            esq = meio + 1;
        } else{
            dir = meio + 1;
        }
    }

    return resp; 

}

int main(){

    return 0;   
}