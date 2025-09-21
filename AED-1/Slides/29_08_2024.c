#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

int main() {

    float salarioBruto = 0, valorPassagem = 0, salarioFinal = 0;
    int numeroViagens = 0, opcao;
    bool erro;

  // menu de opcoes
    do {
        printf("\nMenu de Opcoes\n\n");
        printf("0 - Sair\n");
        printf("1 - Informar o salario bruto\n");
        printf("2 - Informar numero de viagens\n");
        printf("3 - Informar valor da passagem\n");
        printf("4 - Calcular salario\n");
      
  // caso com erro
        do {
            printf("\nDigite a sua opcao: ");
            scanf("%d", &opcao);
            erro = (opcao < 0 || opcao > 4);
            if (erro) {
                printf("Opcao invalida. Tente novamente.\n");
            }
        } while (erro);

      // opcoes
        switch(opcao)
        {
            case 0:
                printf("\nObrigado por usar o programa!\n");
                break;
    
            case 1:
                printf("\nSalario Bruto: R$");
                scanf("%f", &salarioBruto);
                break;
    
            case 2:
                printf("\nNumero de viagens: ");
                scanf("%d", &numeroViagens);
                break;
    
            case 3:
                printf("\nValor da passagem: ");
                scanf("%f", &valorPassagem);
                break;
    
            case 4:
                salarioFinal = salarioBruto - (numeroViagens * valorPassagem);
                printf("\nSalario final: R$%.2f\n", salarioFinal);
                break;
        }
    } while(opcao != 0);

  return 0;
}
