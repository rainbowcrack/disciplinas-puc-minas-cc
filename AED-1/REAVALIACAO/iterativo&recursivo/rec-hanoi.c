#include <stdio.h>

// Funcao recursiva para resolver o problema das Torres de Hanoi
void moverDiscos(int n, int origem, int destino, int auxiliar) {
    if (n == 1) {
        // Caso base: mover um único disco do pino origem para o pino destino
        printf("%d -> %d\n", origem, destino);
    } else {
        // Passo recursivo:
        
        // Mover os n-1 discos do pino origem para o pino auxiliar
        moverDiscos(n - 1, origem, auxiliar, destino);
        
        // Mover o disco maior (n) do pino origem para o pino destino
        printf("%d -> %d\n", origem, destino);
        
        // Mover os n-1 discos do pino auxiliar para o pino destino
        moverDiscos(n - 1, auxiliar, destino, origem);
    }
}

int main() {
    int n;
    
    // Leitura do numero de discos
    scanf("%d", &n);
    
 
    moverDiscos(n, 1, 3, 2);

    return 0;
}
