#include <stdio.h>
#include <stdlib.h>
// ordem decrescente de [10,1] com repeticao de teste final
int main()
{
    int n=10;
    do {
        printf("%d, ", n);
        n -= 1;
    } while (n >= 1);

    return 0;
}
