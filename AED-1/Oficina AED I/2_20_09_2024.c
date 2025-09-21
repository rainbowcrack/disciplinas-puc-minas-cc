#include <stdio.h>
#include <stdlib.h>
# include <math.h>

// testar com 42356
// 43256 / 10 = 4235
double soma_quadrado(int);

int main() {
    int n;

    printf("\nEntre com n: ");
    scanf("%d", &n);
    printf("Resposta: %.2lf", soma_quadrado(n)); 

    return 0;
} // fim main()

double soma_quadrado(int n) {
    double soma = 0;

    while (n != 0) { // Loop enquanto n for maior que 0
        int resto = n % 10; // pega o último dígito

        if (resto % 2 == 0) {
            soma += resto; // soma se o dígito for par
        }

        n = n / 10; // move para o próximo dígito
    }
    return pow(soma, 2); // eleva a soma ao quadrado
} // fim soma_quadrado()
