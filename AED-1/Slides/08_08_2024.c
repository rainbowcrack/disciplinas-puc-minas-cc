#include <stdio.h>
#include <stdlib.h>

int main()
{
  // comparacao de numeros
  printf("\nDado dois valores, qual sera o maior?\n");

  float a,b;

  printf("\nInsira o primeiro valor: ");
  scanf("%f", &a);
  printf("Insira o segundo valor: ");
  scanf("%f", &b);

  if (a > b){
      printf("\n%.1f maior do que %.1f",a,b);
  }
  else if (a < b){
      printf("\n%.1f maior do que %.1f",b,a);
  }
  else {
      printf("\n%.1f igual %.1f",a,b);
  }

    return 0;
}
