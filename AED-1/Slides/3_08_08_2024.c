#include <stdio.h>
#include <stdlib.h>

int main()
{
  // maior entre 3 valores
  printf("\nComparar 3 valores\n");

  // declara
  float a,b,c;

  // input
  printf("\nInsira o primeiro valor: ");
  scanf("%f", &a);
  printf("\nInsira o segundo valor: ");
  scanf("%f", &b);
  printf("\nInsira o terceiro valor: ");
  scanf("%f", &c);

  // condicional comparativa
  if (a > b && a > c){
        printf("\n%.1f e o maior valor", a);

  }
  else if (b > a && b > c){
      printf("\n%.1f e o maior valor", b);

  }
  else {
      printf("\n%.1f e o maior valor", c);

  }

    return 0;
}
