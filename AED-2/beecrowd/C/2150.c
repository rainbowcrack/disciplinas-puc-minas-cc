#include <stdio.h>
#include <stdlib.h>

#define tam 150

int alien(char vogais[], char frase[]) {
    int count = 0;
    
    for (int i = 0; frase[i] != '\0'; i++) {
        char letra = frase[i];

        // Verifica se o caractere da frase é uma vogal
        for (int j = 0; vogais[j] != '\0'; j++) {
            if (letra == vogais[j]) {
                count++;
            }
        }
    }
    
    return count;
}

int main() {
    char vogais[tam], frase[tam];

    // Loop para repetir a leitura até linha vazia ou EOF
    while (fgets(vogais, tam, stdin) != NULL) {
        
        // Verifica se a linha de vogais está vazia (apenas pressionado Enter)
        if (vogais[0] == '\n') {
            break; // Encerra o programa se a linha estiver vazia
        }

        // Lê a segunda linha, que é a frase
        if (fgets(frase, tam, stdin) == NULL) {
            break; // Encerra se o EOF for alcançado ou não houver entrada
        }

        // Exibe a contagem de vogais alienígenas
        printf("%d\n", alien(vogais, frase) - 1);
    }

    return 0;
}
