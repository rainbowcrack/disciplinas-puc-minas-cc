#include <stdlib.h>
#include <stdio.h>

int main() {
  long int a=1,b=1,c;
  int n;

  printf("\nDigite quantos termos da sequencia de Fibonacci: ");
  scanf("%d", &n);

    while (n <= 1){
      printf("\n\aErro!\n");
      printf("\nInforme um numero valido: ");
      scanf("%d", &n);
  }

    
    printf("\n\n1\n1\n");

    for (int i=0; i < n; i++){
      c = a + b;
      printf("%ld\n", c);
      a = b;
      b = c;
      
    }


  return 0;
}
