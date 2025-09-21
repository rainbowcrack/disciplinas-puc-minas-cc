#include <stdio.h>
#include <stdlib.h>

float salarioliquido(float valor, float quantidade, float* bruto, float* inss, float* irrf){
    float liquido;
    *bruto = valor * quantidade;
    *inss = *bruto * 0.09; // 9%
    *irrf = *bruto * 0.1; // 10%
    liquido = *bruto - *inss - *irrf;


    return liquido;
}

int main()
{
    float nh = 10, vh = 5, sb, inss, irrf;
    printf("\nSalario liquido = %.2f", salarioliquido(vh, nh, &sb, &inss, &irrf));
    printf("\n%.2f - %.2f - %.2f", sb, inss, irrf);
    return 0;
}
