#include <stdlib.h>
#include <stdio.h>

long fatorial(int n){
    long fat = 0;
    if (n == 0) fat = 1; // permite troca
    if (n > 0) { // caso base
        fat = n * fatorial(n-1); // subtraindo indice de "n" repeticoes recursivas
    }
    return fat;
} // fim fatorial()

int leiaInteiro(){
    int a;
    scanf("%d", &a);
    return a;
} // fim leiaInteiro()


int main(){
    int n = leiaInteiro();
    long resultado = fatorial(n);
    printf("A fatorial de %d = %ld", n, resultado);
    
    return 0;
} // fim main()
