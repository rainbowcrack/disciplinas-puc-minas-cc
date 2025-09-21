#include <stdio.h>
#include <stdlib.h>
// recursividade x funcao chamando ela mesma
void apresentacao(int x){
    if(x <= 5){ // caso base
        printf("%d, ", x); // ordem crescente
        apresentacao(x+1); // acressimo ou ++x       
    }

} // fim apresentacao()

int main()
{
    apresentacao(1); // comeca
    return 0;
}
