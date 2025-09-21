// funcao, passagem por referencia e ponterios
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

void apresentacao(){
    printf("\nCalculo da area de um triangulo\n");
} // fim apresentacao()

float leiaLados(char *msg){
    float base;
    bool erro;
    do {
        printf("\n%s", msg);
        scanf("%f", &base);
        erro = base <= 0;
    } while(erro);
    return base;
} // fim leiaLados()

float areaTriangulo(float base, float altura){
    return (base * altura)/2;
} // fim area()

void escrevaResultado(float area){
    printf("\nA area do triangulo eh: %.2f", area);
} // fim escrevaResultado()

int main() {
    apresentacao();
    float base = leiaLados("Digite a base: ");
    float altura = leiaLados("Digite a altura: ");
    float area = areaTriangulo(base, altura);
    escrevaResultado(area);
    
    return 0;
}
