#include <stdio.h>
#include <stdlib.h>

int main(void) {
  printf("\nConversao de celsius em Farenheit\n");

  // declara
  float celsius;
  printf("\nInforme a termperatura em Celsius: ");
  scanf("%f", &celsius);

  // calcula
  float fahrenheit = ((celsius * 1.8) + 32);

  // output
  printf("\nA temperatura em Fahrenheit e: %.2f", fahrenheit);

  return 0;
}
