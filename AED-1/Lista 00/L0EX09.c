// sem otimizacao
#include <stdio.h>
#include <stdlib.h>

int main(void) {
  // calculo do peso ideal em homens e mulheres
  float h;
  char sexo;
  float feminino;
  float masculino;

  // input
  printf("\nSe seu genero [M/F]: ");
  scanf("%c", &sexo);
  printf("\nInforme sua altura em Metros: "); 
// restringir a altura a 3
  scanf("%f", &h);

  // condicional
  if (sexo == 'm' || sexo == 'M') {
    masculino  = (72.7 * h) - 58;
    printf("\nSeu peso ideal e: %.2f Kg", masculino);
  }
  else if (sexo == 'f' || sexo == 'F') {
    feminino = (62.1 * h) - 44.7;
    printf("\nSeu peso ideal e: %.2f Kg", feminino);
  }
  else {
    printf("\nGenero invalido"); // criar um loop para o erro
  }

  // criar um bloco de erro ou Flag, para um loop de genero e altura em metros (2.5)
  return 0;
}
