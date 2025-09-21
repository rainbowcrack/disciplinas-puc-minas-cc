// calculo do peso ideal
// com dois testes
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>

int main() {
  // declara
  float h;
  bool erro;
  char sexo;
  float peso;

  // loop recebe erro
  do {
      printf("\nSeu genero [M/F]: ");
      scanf(" %c", &sexo);
      sexo = toupper(sexo);
      erro = (sexo != 'M' && sexo != 'F');
      if (erro) printf("\n\aErro!\n");
  } while (erro);
  
  do {
      printf("\nDigite sua altura: ");
      scanf("%f", &h);
      erro = h < 0 || h > 2.5;
      if (erro) printf("\n\aErro!\n");
  } while (erro);
  
  // condicional
  if (sexo == 'M') {
    peso = (72.7 * h) - 58;
    printf("\nSeu peso ideal e: %.2f Kg", peso);
  }
  else {
    peso = (62.1 * h) - 44.7;
    printf("\nSeu peso ideal e: %.2f Kg", peso);
  }

  return 0;
}
