#include <stdlib.h>
#include <stdio.h>

int leiaInteiro(){
    int n;
    scanf("%d", &n);
    return n;
} // fim leiainteiro()

void decrescente(int n){
    if (n >= 0) {
        printf("%d, ", n);
        decrescente(n-1);
    }
} // fim decrescente()

int main() {
    int valor = leiaInteiro();
    decrescente(valor);
    return 0;
} // fim main()
