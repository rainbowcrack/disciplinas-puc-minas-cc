#include <stdio.h>
#include <stdlib.h>
// ordem decrescente de [10,1] com repeticao de teste inicio
int main()
{
    int n=10;
    while (n > 0){
        printf("%d, ", n);
        n -= 1;
    }
    return 0;
}
