#include <stdlib.h>
#include <stdio.h>

void apresentacao(){
    printf("\nPrograma que calcula a exponenciacao\n");
} // fim apresentacao()

int leiaInteiro(char *msg){
    int n;
    printf("%s", msg); // string na mochila do heroi
    scanf("%d", &n);
    return n;
} // fim leiaInteiro()

int exponencial(int base, int expoente){
    int saida = 0;
    if (expoente == 0) saida = 1;
    if (expoente > 0){ // caso base
        saida = base * exponencial(base, expoente - 1); // recursividade
    }
    return saida;
} // fim exponencial()


int main(){
    apresentacao();
    int base = leiaInteiro("Digite o valor da base: ");
    int expoente = leiaInteiro("Digite o valor do expoente: ");
    int resultado = exponencial(base, expoente);
    printf("\n %d ^ %d = %d", base, expoente, resultado);
    return 0;
} // fim main()
