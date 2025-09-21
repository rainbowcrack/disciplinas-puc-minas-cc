# include <stdio.h>
# include <stdlib.h>

float fazDobro(float *x){
    float *dobro = malloc(sizeof(float));
    *dobro = *x *2;
    return *dobro;
}

// --------------------------------------------------

int main(){
    float *x = malloc(sizeof(float));
    scanf("%f", x);
    printf("%f",fazDobro(x));
    
    free(x);
    
    
    return 0;
}
