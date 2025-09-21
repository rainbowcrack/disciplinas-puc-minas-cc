#include <stdio.h>
#include <stdlib.h>

int main()
{
    void escrevaArray(float A[], int TAM){
        for(int i = 0; i < TAM; i++){
            printf("\nA[%d] = %f", i + 1, A[i]);
        }

    } // fim escrevaArray()

    int main(){
        int vetor[] = {10,20,30,40,50,60,70,80,90,100};
        escrevaArray(vetor, 10);
        return 0;
    } // fim da main()

    return 0;
}
