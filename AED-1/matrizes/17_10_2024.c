#include <stdio.h>
#include <stdlib.h>

void escreve(float M[][2]){
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 2; j++){
            printf("%f\t", M[i][j]);
        }
        printf("\n");
    }
}

int main(){
    float M[][2] = {9, 10, 7, 1, 2, 7};
    escreve(M);

    return 0;
}
