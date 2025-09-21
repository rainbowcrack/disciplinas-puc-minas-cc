#include <stdio.h>
#include <stdlib.h>

// funcao que imprime
void imprime(int array[], int n){
    for(int i = 0; i < n; i++){
        printf("%d ", array[i]);
    }
}

// funcao de ordenacao por bubble sort
void bubblesort(int array[], int n){
    int temp;
    
    for(int i = 0; i < n-1; i++){
        for(int j = 0; j < n-1-i; j++){
            if(array[j] > array[j+1]){
                // swap
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }
}
int main(){
    
    int n;
    scanf("%d", &n);
    int array[n];
    
    for(int i = 0; i < n; i++){
        scanf("%d", &array[i]);
    }
    
    printf("Antes: ");
    imprime(array, n);
    // bubblesort
    bubblesort(array, n);
    printf("\nDepois: "); 
    imprime(array, n);
}
