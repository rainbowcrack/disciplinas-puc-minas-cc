#include <stdlib.h>
#include <stdio.h>

void escreveInvertido(int x)
{
    while(x > 0) // loop
    { 
        printf("%d", x%10); // pega o ultimo valor
        x = x/10; // reduz 1 casa de modo iterativo
    }
} // fim escreveInvertido()

int main()
{
     int x=12345;
     escreveInvertido(x);
     return 0;
} // fim main()
