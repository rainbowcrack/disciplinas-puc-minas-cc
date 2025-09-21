#include <stdlib.h>
#include <stdio.h>

#define MAX 10 // 10 elementos maximos da pilha

// struct de pilha
typedef struct{
    int vetor[MAX];
    int topo;
}Pilha;

// empilha
void push(int valor, Pilha *pilha){
    if(pilha->topo < MAX){
        pilha->vetor[pilha->topo] = valor;
        pilha->topo++;
    }
}

// desempilha
int pop(Pilha *pilha){
    if(pilha->topo > 0){
        pilha->topo--;
        
        return pilha->vetor[pilha->topo];
    }
}

// imprime
void imprime(Pilha *pilha){
    printf("[ ");
    for(int i = pilha->topo-1; i >= 0; i--){
        printf("%d ", pilha->vetor[i]);
    }
    printf("]");
}

int main(){
    // inicializa a pilha
    Pilha p;
    p.topo = 0;
    
    // empilha
    push(5, &p);
    push(10, &p);
    push(15, &p);
    push(100, &p);
    
    // onde o ponteiro esta eh elemento + 1
    printf("Onde esta o topo: %d\n", p.topo);
    
    // imprime
    imprime(&p);
    
    // remove
    int removeu = pop(&p);
    printf("\nElemento removido: %d\n", removeu);
    
    // imprime
    imprime(&p);
    
    return 0;
}