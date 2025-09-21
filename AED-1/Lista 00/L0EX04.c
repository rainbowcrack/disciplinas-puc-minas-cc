// sem otimizacao
#include <stdio.h>
#include <stdlib.h>

int main(void) {
  // calculo do peso ideal em homens e mulheres
  float h;
  int sexo;
  float feminino;
  float masculino;

  // input
  printf("\nSe seu genero e Masculino insira 0, se e Feminino insira 1: ");
  scanf("%d", &sexo);
  printf("\nInforme sua altura em Metros: "); // restringir a altura a 3
  scanf("%f", &h);

  // condicional
  if (sexo == 0) {
    masculino  = (72.7 * h) - 58;
    printf("\nSeu peso ideal e: %.2f Kg", masculino); 
  } 
  else if (sexo == 1) {
    feminino = (62.1 * h) - 44.7;
    printf("\nSeu peso ideal e: %.2f Kg", feminino);
  }
  else {
    printf("\nGenero invalido"); // criar um loop para o erro
  }

  // criar um bloco de erro ou Flag, para um loop de genero e altura em metros (2.5)
  return 0;
}
