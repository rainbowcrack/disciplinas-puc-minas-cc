#include <stdlib.h>
#include <stdio.h>

long fatorial(int n){
    long fatorial = 1;
    
    for(int i=1; i <= n; i++){
        fatorial *= i;
    }
    
    return fatorial;
}

int main()
{
    int n;
    scanf("%d", &n);
    
    printf("%ld", fatorial(n));

    return 0;
}ite
