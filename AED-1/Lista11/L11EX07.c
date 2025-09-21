// erro
#include <stdlib.h>
#include <stdio.h>

int leia() {
    int x;
    printf("\nInsira um numero: ");
    scanf("%d", &x);
    return x;
} // fim do leia()

int ehprimo(int x){
    // loop para divisores
    int divisiveis=0, num;
    for (int i=2; i <= num/2; i++){
        
        if (num % i == 0) divisiveis++;
    }
    return divisiveis;
} // fim do ehprimo()

void escrevaResultado(){
    int divisiveis=0;
     // condicional para saber se eh primo ou nao
    if (divisiveis > 0) {
        printf("\nNao eh primo");
    } else {
        printf("\nEh primo");
    }
} // fim do escrevaResultado()

int main() {
    printf("\nPrograma para saber se o numero eh primo\n\n");
    int a = leia();
    int resultado = ehprimo(a);
    escrevaResultado(resultado);
    
    return 0;
} // fim main()
