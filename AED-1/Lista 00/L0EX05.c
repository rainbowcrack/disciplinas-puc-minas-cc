#include <stdio.h>
#include <stdlib.h>

int main(void) {
  printf("\nCalculo da area de um circulo\n");

  // declara
  float raio;

  // input
  printf("\nInforme a medida do raio: ");
  scanf("%f", &raio);

  //calcula
  float area = 2 * 3.14 * raio;

  //output
  printf("\nA area e: %.2f", area);

  return 0;
}
