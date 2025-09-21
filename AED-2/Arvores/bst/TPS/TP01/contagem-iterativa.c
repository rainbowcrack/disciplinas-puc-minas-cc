#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

// metodo para contar maiusculas
int contarCapslock(char array[100]) { 
    int count = 0;
    
    // percorre o array contando maiusculas
    for (int i = 0; array[i] != '\0' && array[i] != '\n'; i++) {
        if (isupper(array[i])) count++;
        
    }
    return count;
}
     
int main() { 
    char array[100];
    
    fgets(array, 100, stdin);
    
    // Remove a quebra de linha (faz um virar outro, parece swap)
    array[strcspn(array, "\n")] = '\0';
    
    while (strcmp(array, "FIM") != 0) {
        printf("%d\n", contarCapslock(array));
        fgets(array, 100, stdin);
        
        // Remove a quebra de linha
        array[strcspn(array, "\n")] = '\0';
    }

    return 0;
}
