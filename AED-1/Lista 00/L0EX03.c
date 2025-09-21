#include <stdio.h>
#include <stdlib.h>

int main(void) {
  // representação em Farenheit da temperatura 37,777777 graus celsius
  printf("\nConversao de celsius em Farenheit\n");

  // declara e calcula
  float celsius = 37.777777;
  float fahrenheit = ((celsius * 1.8) + 32);

  // output
  printf("\nA temperatura em Fahrenheit e: %.2f", fahrenheit);
  
  return 0;
}
