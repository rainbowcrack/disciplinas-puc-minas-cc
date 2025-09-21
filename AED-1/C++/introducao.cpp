#include <iostream>
using namespace std;

class Pessoa{
private:
    char nome[50];
    int idade;

public:
void escrevePessoa(){
    printf("\nNome: %s", nome);
    printf("\nIdade: %d", idade);
}

void leiaPessoa(){
    printf("\nNome: ");
    fgets(nome, 50, stdin);
    printf("\nIdade: ");
    scanf("%d", &idade);
}
};
int main()
{
    Pessoa P;
    P.leiaPessoa();
    P.escrevePessoa();
    return 0;
}
