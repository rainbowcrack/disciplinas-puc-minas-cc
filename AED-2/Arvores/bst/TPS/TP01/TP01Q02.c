/*****************************
* TP01Q02                    *
* PALINDROMO (C) - ITERATIVO *
*****************************/

// diretivas padrao
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// diretivas para tratar o charset
#include <wchar.h>
#include <locale.h>

#define MAX 100

// funcao para verificar se a string eh um palindromo
bool verificaPalindromo(wchar_t array[MAX]) {
    bool palindromo = true;

  // declara as variaveis para comparacao
    int i = 0;
    int j = wcslen(array) - 1; 

    while (palindromo && i < j) {
        if (array[i] != array[j]) {
            palindromo = false;
        }
        i++;
        j--;
    }

    return palindromo;
}

int main() {
    // passa para UTF-8, por conta do charset
    setlocale(LC_ALL, "C.UTF-8"); 

    wchar_t array[MAX];
    fgetws(array, MAX, stdin);
  
    array[wcslen(array) - 1] = L'\0'; // remove o '\n' do final

    while (wcscmp(array, L"FIM") != 0) {
        // chama a funcao para verificar o palíndromo
        wprintf(L"%ls\n", verificaPalindromo(array) ? L"SIM" : L"NAO");

        // faz novamente a leitura
        fgetws(array, MAX, stdin);
        array[wcslen(array) - 1] = L'\0';
    }

    return 0;
}
