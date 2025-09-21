#include <stdio.h>
#include <stdlib.h>

void leiaVetor(int idades[], int n, int *soma);
void imprimeVetor(int idades[], int n, float media);
float calculeMedia(int soma, int n);

int main(){
    int n;
    printf("Informe a quantidade de alunos: ");
    scanf("%d", &n);
    
    int idades[n];
    int soma = 0;
    float media;
    
    
    leiaVetor(idades, n, &soma);
    media = calculeMedia(soma, n);
    imprimeVetor(idades, n, media);
    
    return 0;
} // fim da main()

void leiaVetor(int idades[],int n, int *soma){
    for(int i=0; i<n; i++){
        printf("\n%d.a idade: ", (i+1));
        scanf("%d", &idades[i]);
        *soma += idades[i];
        
    }
    printf("\n");
} // fim do leiaVetor()

float calculeMedia(int soma, int n){
    
    return (float) soma / n;
} // fim da calculeMedia()

void imprimeVetor(int idades[], int n, float media){
    for(int i=0; i<n; i++){
        if(idades[i] > media){
            printf("Notas acima da media: %d \t", idades[i]);
        }
    }
} // fim do imprimeVetor()
