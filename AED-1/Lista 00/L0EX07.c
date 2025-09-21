#include <stdio.h>
#include <stdlib.h>

int main(void) {
  printf("\nCalculo do peso ideal em Homens\n");
  
  float h;
  // input
  printf("\nInforme sua altura em Metros: "); 
  scanf("%f", &h);

  // calculo e output
  float masculino  = (72.7 * h) - 58;
  printf("\nSeu peso ideal e: %.2f Kg", masculino); 

  return 0;
}
