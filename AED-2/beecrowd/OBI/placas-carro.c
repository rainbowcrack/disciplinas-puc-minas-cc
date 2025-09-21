#include <stdio.h>

int main() {
    char placa[9]; // Até 8 caracteres + '\0'
    scanf("%s", placa); // Proteção contra buffer overflow

    // Verifica se segue o padrão brasileiro antigo (ABC-1234)
    if (placa[0] >= 'A' && placa[0] <= 'Z' &&
        placa[1] >= 'A' && placa[1] <= 'Z' &&
        placa[2] >= 'A' && placa[2] <= 'Z' &&
        placa[3] == '-' &&
        placa[4] >= '0' && placa[4] <= '9' &&
        placa[5] >= '0' && placa[5] <= '9' &&
        placa[6] >= '0' && placa[6] <= '9' &&
        placa[7] >= '0' && placa[7] <= '9' &&
        placa[8] == '\0') {
        
        printf("1\n"); // Padrão Brasileiro Antigo
        return 0;
    }

    // Verifica se segue o padrão Mercosul (ABC1D23)
    if (placa[0] >= 'A' && placa[0] <= 'Z' &&
        placa[1] >= 'A' && placa[1] <= 'Z' &&
        placa[2] >= 'A' && placa[2] <= 'Z' &&
        placa[3] >= '0' && placa[3] <= '9' &&
        placa[4] >= 'A' && placa[4] <= 'Z' &&
        placa[5] >= '0' && placa[5] <= '9' &&
        placa[6] >= '0' && placa[6] <= '9' &&
        placa[7] == '\0') {
        
        printf("2\n"); // Padrão Mercosul
        return 0;
    }

    // Se não passou em nenhum dos dois testes, é falsificada
    printf("0\n");
    return 0;
}
