#include <stdlib.h>
#include <stdio.h>

int main(){
    int n;
    int matriz[n][n];
    scanf("%d", &n);
    
    if (0 < n && n < 10){
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                printf("%d ", i * j); // multiplica linha por coluna
            }
            printf("\n"); // salta linha
        } // fim da matriz
    } // fim da condicional
    return 0;
} // fim main()
