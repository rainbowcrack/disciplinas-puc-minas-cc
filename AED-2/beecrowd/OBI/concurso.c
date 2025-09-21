// Concurso OBI (Claudia)
#include <stdio.h>

int main()
{
    int N, K;
    scanf("%d %d", &N, &K);
    
    int array[N];
    
    for(int i = 0; i < N; i++){
        scanf("%d", &array[i]);
    }
    
    // bubble short (decrescente)
    for(int i = 0; i < (N-1); i++){
        for(int j = 0; j < (N-1-i); j++){
            if(array[j] < array[j+1]){
                int tmp = array[j];
                array[j] = array[j+1];
                array[j+1] = tmp;
            }
        }
    }
    
    int notaCorte = array[K - 1];
    
    printf("%d\n", notaCorte);

    return 0;
}
