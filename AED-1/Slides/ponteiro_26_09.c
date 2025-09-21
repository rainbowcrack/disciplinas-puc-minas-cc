// mostra o endereco da memoria
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x;
    printf("\nA variavel x foi declarada na posicao %p", &x);
    printf("\nOcupando %d bytes", sizeof(int));
    x = 7;
    printf("\nE guarda o valor %d", x);
    return 0;
}

// ponteiros e realoca a memoria
// &x posicao na memoria
// *x mostra o valor
// x mostra a posicao
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int *x;
    printf("\nA variavel x foi declarada na posicao %p", &x); // posicao inicial
    x = malloc(sizeof(int)); // realoca a memoria
    printf("\nOcupando %d bytes", sizeof(int)); // quantidade de bytes ocupados
    printf("\nE aponta para %p posicao", x); // onde aponta

    *x = 7;
    printf("\nE guarda o valor %d", *x); // onde invade
    return 0;
}

// Experimente
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int A = 7;
    int *p;
    p = &A;

    printf("\nPosicao de A: %p", &A);
    printf("\nPosicao do ponteiro P: %p", &p);
    printf("\nOnde aponta o ponteiro p: %p", p);
    printf("\nValor de A: %d", A);
    printf("\nValor guardado no local para onde aponta p: %d", *p);

    return 0;
}
