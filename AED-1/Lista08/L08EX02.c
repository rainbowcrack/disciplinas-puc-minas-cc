// ERRO

// 10/100, 99/11, 12/98, 97/13 (10 primeiros termos)
#include <stdlib.h>
#include <stdio.h>

int main() {
    // declare
    int numerador1=10, denominador1=100, numerador2=99, denominador2=11;
    
    for (int i=0; i <= 10; i++){
        printf("%d/%d, ", numerador1, denominador1);
        
        numerador1 += 2;
        denominador1 -= 2;
        
        printf("%d/%d, ", denominador2, numerador2);
        
        numerador2 -= 2;
        denominador2 += 2;
        
    }
        
    return 0;
}
