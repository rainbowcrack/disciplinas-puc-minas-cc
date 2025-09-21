#include <stdlib.h>
#include <stdio.h>

long fatorialRec(int n){
    
    if(n > 1){
        return n * fatorialRec(n-1);        
    }
}

int main()
{
    int n;
    scanf("%d", &n);
    
    printf("%ld", fatorialRec(n));

    return 0;
}
