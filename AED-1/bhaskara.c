#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void) {
  printf("\nResolve equacao de segundo grau\n");

//input
  float a, b, c, delta, x1, x2;
  printf("\nNo formato ax^2+bc+c\nInforme o A: ");
  scanf("%f", &a);
  printf("\nInforme o B: ");
  scanf("%f", &b);
  printf("\nInforme o C: ");
  scanf("%f", &c);

// formula de bhaskhara 
  delta = pow(b,2) -4 * a * c;
  if (delta >0){
    x1 = (-b + sqrt(delta)) / (2 * a);
    x2 = (-b - sqrt(delta)) / (2 * a);
    printf("As raizes reais sao %.2f e %.2f", x1, x2);
  } else {
    printf("O delta e negativo, informe outro valor.");
  }

  return 0;
}