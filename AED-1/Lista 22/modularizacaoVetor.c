#include <stdio.h>
#include <stdlib.h>

void leiaVetor(int idades[], int n);
void imprimeVetor(int idades[], int n);

int main(){
    int n;
    int idades[n];
    printf("Informe o tamanho do vetor: ");
    scanf("%d", &n);
    
    leiaVetor(idades, n);
    imprimeVetor(idades, n);
    
    return 0;
} // fim da main()

void leiaVetor(int idades[],int n){
    for(int i=0; i<n; i++){
        printf("\n%d.a idade: ", (i+1));
        scanf("%d", &idades[i]);
        
    }
    printf("\n");
} // fim do leiaVetor()

void imprimeVetor(int idades[], int n){
    for(int i=0; i<n; i++){
        printf("%d \t", idades[i]);
    }
} // fim do imprimeVetor()
