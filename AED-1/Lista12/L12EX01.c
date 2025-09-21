#include <stdlib.h>
#include <stdio.h>

int informeDias(int idade){
    
    int dias = idade * 365;
    return dias;
} // fim informeDias()

int leiaIdade(){
    int idade;
    scanf("%d", &idade);
    return idade;
} // fim leiaIdade()

int main() {
    int idade = leiaIdade();
    int dias = informeDias(idade);
    printf("\nNumero de dias vividos: %d", dias);

    return 0;
} // fim main()
