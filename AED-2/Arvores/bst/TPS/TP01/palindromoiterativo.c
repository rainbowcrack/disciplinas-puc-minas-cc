/****************************
* PALINDROMO ITERATIVO EM C *
*****************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define  MAX 100

bool verificaPalindromo(char array[MAX]){

        bool palindromo = true;

        /*  variaveis de controle, onde "i" marca o inicio e incrementada em 1
        e "j" o fim e decrementada em 1 */
        int i = 0;
        int j = strlen(array) - 1;

        while(palindromo && i < j){

                if(array[i] != array[j]) palindromo = false;

                i++; j--;
        }

        return palindromo;
}

int main(){

        char array[MAX];

        // faz a leitura da string
        fgets(array, MAX, stdin);

        // limpa o "\n" do buffer
        array[strcspn(array, "\n")] = '\0';

        while(strcmp(array, "FIM") != 0){

                // chama a funcao
                printf("%s\n", verificaPalindromo(array)? "SIM" : "NAO");

                // faz a leitura novamente ate parar no fim
                fgets(array, MAX, stdin);
                array[strcspn(array, "\n")] = '\0';
        }

        return 0;
}
