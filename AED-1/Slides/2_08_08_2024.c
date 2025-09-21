#include <stdio.h>
#include <stdlib.h>

int main()
{
  // o valor eh par ou impar
  printf("\nPar ou Impar?\n");

  int valor, soma;

  printf("\nInforme um valor: ");
  scanf("%d", &valor);

  soma = (valor % 2);

  if (soma == 0) {
    printf("\n%d e par", valor);
  }
  else {
    printf("\n%d e impar", valor);
  }

    return 0;
}
