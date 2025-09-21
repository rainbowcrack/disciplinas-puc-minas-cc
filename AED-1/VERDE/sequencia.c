#include <stdlib.h>
#include <stdio.h>

int leituraInteiro(){
    int n;
    scanf("%d", &n);
    return n;
} // fim leituraInteiro()

void matriz(int n){
    if (0 < n && n < 10){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                printf("%d ", i * j); // multiplica linha por coluna
            }
            printf("\n"); // salta linha
        }
    }
} // fim do parametro matriz()

int main(){
    int n = leituraInteiro();
    matriz(n); // parametro matriz passa "n"
    
    return 0;
} // fim main()
