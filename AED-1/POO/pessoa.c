#include <stdio.h>
#include <stdlib.h>

// POO
typedef struct{
    char nome[50];
    int idade;
}Pessoa; 

// ponteiro para ler a posicao
void leiaPessoa(Pessoa *PESSOA){
    printf("\nNome: ");
  
  // -> mostra que eh um ponteiro de colecao
    fgets(PESSOA->nome, 50, stdin);
  
    printf("\nIdade: ");
    scanf("%d", &PESSOA->idade);
} // fim do leiaPessoa()

// PESSOA.nome entra no universo da colecao
void escrevaPessoa(Pessoa PESSOA){
    printf("\nNome = %s", PESSOA.nome);
    printf("\nIdade = %d", PESSOA.idade);
}

int main(){
    Pessoa iza;
  
  // passagem por referencia
    leiaPessoa(&iza);
  
    escrevaPessoa(iza);
    return 0;

} // fim da main()
