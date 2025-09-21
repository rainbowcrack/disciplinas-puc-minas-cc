#include <stdlib.h>
#include <stdio.h>

int somatorio(int a, int b){
    int soma = 0;
    if(a <= b){
        soma = a + somatorio(a+1, b); // pega o valor seguinte e soma em a
    }
    return soma;
} // fim somatorio()

int leiaInteiro(char *msg){
    int n;
    printf("%s", msg); // mensagem na mochila do heroi
    scanf("%d", &n);
    return n;
} // fim leiaInteiro()

int main(){
    int x = leiaInteiro("Primeiro valor: ");
    int y = leiaInteiro("Valor limite: ");
    int resultado = somatorio(x, y);
    printf("\nA soma de %d ate %d = %d", x, y, resultado);
    return 0;
} // fim main()
