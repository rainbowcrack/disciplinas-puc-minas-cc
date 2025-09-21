#include <stdio.h>
#include <stdlib.h>
// recursividade x funcao chamando ela mesma
void apresentacao(int x){
    if(x <= 5){ // caso base
        printf("%d, ", x); // ordem crescente
        apresentacao(x+1);
        printf("%d, ", x);// ordem decrescente
    }

} // fim apresentacao()

int main()
{
    apresentacao(1); // comeca com 1
    return 0;
}
