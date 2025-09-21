/*class Celula{
    int elemento;
    Celula prox;
}

class No{
    int elemento;
    No esq, dir;
}

class Tabela{

}
*/

public class HashDoido{

    // construtor
    void HashDoido(){
    Celula primeiroT1, ultimoT1;
    No raizT1, raizT3;
    Tabela T1[], T3[];  
    } 
}
// insere no HASH (1)
public void inserir(int chave){
    int posT1 = hashT1(chave);

    // add
    if(T1[posT1] == null){
        T1[posT1] = chave;
    } else{
        // hash reserva que comporta como hash virtual
        int posT2 = hashT2(chave);

        // HASH DE RESERVA
        if(posT2 == 0){
            int posT3 = hashT3(chave);

            if(T3[posT3] == null){
                T3[posT3] = chave; // add
            
            } else{
                raizT3 = inserirArvore(raizT3, chave); // reserva hash T3
            }
        } else if(posT2 == 1){
            ultimoT1.prox = new Celula(chave); // add lista encadeada na reserva
            ultimoT1 = ultimoT1.prox;
        } else if(posT3 == 2){
            raizT2 = inserirArvore(raizT2, chave); // add arvore na reserva
        }
    }
    
}

// inserir na arvore
public No inserirArvore(No raiz, int valor){
    if(raiz == null){
        raiz = new No(valor);
    } else if(raiz < raiz.elemento){
        raiz.esq = inserirArvore(raiz.esq, valor);
    } else if(raiz > raiz.elemento){
        raiz.dir = inserirArvore(raiz.dir, valor);
    }

    return raiz;
}


