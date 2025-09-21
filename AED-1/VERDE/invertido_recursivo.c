#include <stdlib.h>
#include <stdio.h>

void escreveInvertidoRec(int x)
{
    if (x > 0) // caso base
    { 
        printf("%d", x%10); // pega o ultimo valor
        escreveInvertidoRec(x/10); // reduz 1 casa recursivamente
    }
} // fim escreveInvertidoRec()

int main()
{
     int x=12345;
     escreveInvertidoRec(x);
     return 0;
} // fim main()
