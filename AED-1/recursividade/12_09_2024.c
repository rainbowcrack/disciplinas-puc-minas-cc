#include <stdio.h>
#include <stdlib.h>
// recursividade x funcao chamando ela mesma
void apresentacao(int x){
    printf("\n%d", x);
    if(x <= 10){
        apresentacao(x+1);
        printf("\n%d", x);
    }

} // fim apresentacao()

int main()
{
    apresentacao(0);
    return 0;
}
