#include <stdio.h>
#include <stdlib.h>

int main(void) {
  printf("\nCalculo do peso ideal em Mulheres\n");
  
  float h;
  // input
  printf("\nInforme sua altura em Metros: "); 
  scanf("%f", &h);

  // calculo e output
  float feminino = (62.1 * h) - 44.7;
  printf("\nSeu peso ideal e: %.2f Kg", feminino); 

  return 0;
}
