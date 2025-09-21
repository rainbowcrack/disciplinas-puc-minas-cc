#include <stdio.h>
#include <stdlib.h>
// recursividade x funcao chamando ela mesma
void escreveAte(int a, int b){
    if(a <= b){ // caso base
        printf("%d, ", a); // ordem crescente
        escreveAte(a+1, b); // soma "a" ate chegar em "b"
    }
} // fim apresentacao()

int leiaInteiro(char *msg){
    int valor;
    printf("%s", msg); // adiciona uma mensagem na mochila do heroi
    scanf("%d", &valor);
    return valor;
}

int main(){
    int a = leiaInteiro("O primeiro valor: ");
    int b = leiaInteiro("O valor limite: ");
    escreveAte(a,b); // comeca com 1
    return 0;
}
