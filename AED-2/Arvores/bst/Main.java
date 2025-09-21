/************************************
* NO                                *
************************************/
class No {
    int valor;
    No esq, dir;
    
    No(int valor) {
        this.valor = valor;
        // esq e dir já vêm null por padrão
    }
}

/************************************
* Onde fica a class                 *
************************************/
public class Main {
    // Insere recursivamente e retorna a nova raiz da subárvore
    static No insere(No i, int valor) {
        if (i == null) {
            return new No(valor);
        }
        if (valor < i.valor) {
            i.esq = insere(i.esq, valor);
        } else if (valor > i.valor) {
            i.dir = insere(i.dir, valor);
        }
        // valor igual não insere (evita duplicatas)
        return i;
    }

    // Impressão em-ordem (caminhamento ascendente)
    static void caminhamentoCentral(No i) {
        if (i != null) {
            
            caminhamentoCentral(i.esq);
            System.out.print(i.valor + " ");
            caminhamentoCentral(i.dir);
        }
    }

    // impresso os pais primeiro
    static void caminhamentoPre(No i){
        if(i != null){
            System.out.print(i.valor + " ");
            caminhamentoPre(i.esq);
            caminhamentoPre(i.dir);
        }
    }

    // impresso os filhos primeiro
    static void caminhamentoPos(No i){
        if(i != null){
            caminhamentoPos(i.esq);
            caminhamentoPos(i.dir);
            System.out.print(i.valor + " ");
        }
    }
    
    // maior elemento
    static int maiorValor(No i){
        while(i.dir != null){
            i = i.dir;
        }
        return i.valor;
    }

    // menor elemento
    static int menorValor(No i){
        while(i.esq != null){
            i = i.esq;
        }
        return i.valor;
    }
    
    // implementar soma total  
    static int somaTotal(No i){
        if(i == null) return 0;
        
        return i.valor + somaTotal(i.esq) + somaTotal(i.dir);
    }
    
    // implementar soma de pares  
    static int somaPar(No i){
        if(i == null) return 0;
        
        int soma = (i.valor % 2 == 0)? i.valor : 0;
        return soma + somaPar(i.esq) + somaPar(i.dir);
    }
    
    // implementar soma de impares
    static int somaImpar(No i){
        if(i == null) return 0;
        
        int soma = (i.valor % 2 == 0)? 0 : i.valor;
        return soma + somaImpar(i.esq) + somaImpar(i.dir);
    }
    
    // imprimir pares
    static void imprimirPares(No i){
        if(i == null) return; // impede que seja executado
        
        if(i.valor % 2 == 0){
            System.out.print(i.valor + " ");
        }
        
        imprimirPares(i.esq); 
        imprimirPares(i.dir);
    }

    // imprimir impares
    static void imprimirImpares(No i){
        if(i == null) return;
        
        if(i.valor % 2 != 0){
            System.out.print(i.valor + " ");
        }
        
        imprimirImpares(i.esq);
        imprimirImpares(i.dir);
    }

    // imprimir folhas
    static void imprimirFolhas(No i){
        if(i == null) return;
        
        if(i.dir == null && i.esq == null){
            System.out.print(i.valor + " ");
        }
        
        imprimirFolhas(i.esq);
        imprimirFolhas(i.dir);
    }
    
    // imprimir folhas
    static void imprimirSemFolhas(No i){
        if(i == null) return;
        
        if(i.dir != null && i.esq != null){
            System.out.print(i.valor + " ");
        }
        
        imprimirSemFolhas(i.esq);
        imprimirSemFolhas(i.dir);
    }

    // imprimir sub-arvore direita
    static void subArvoreDir(No i){
        if(i == null || i.dir == null) return;
        
        caminhamentoCentral(i.dir);
    }

    // imprimir sub-arvore esquerda
    static void subArvoreEsq(No i){
        if(i == null || i.esq == null) return;
        
        caminhamentoCentral(i.esq);
    }

    // busca
    static boolean temElemento(No i, int chave){
        if(i == null) return false;
        
        boolean resp = false;
        
        if(chave == i.valor){
            resp = true;
        }else if(chave < i.valor){
            resp = temElemento(i.esq, chave);
        } else if(chave > i.valor){
            resp = temElemento(i.dir, chave);
        }
        
        return resp;
    }

    // impressao por largura
    static void impressaoLargura(No i){}

    // maior da sub-arvore esquerda ou menor da sub-arvore direita para a remocao da raiz
    static No maiorEsq(No i, No j){
        if(j.dir == null){i.valor = j.valor; j = j.esq;}
        else{j.dir = maiorEsq(i, j.dir);}

        return j;
    }
    // remover No
    static No remover(No i, int x){
        // if(i == null){throw new Exception("Erro");}

        if(x < i.valor){i.esq = remover(i.esq, x);}
        else if(x > i.valor){ i.dir = remover(i.dir, x); }
        

        else if(i.dir == null){i = i.esq;}
        else if(i.esq == null){i = i.dir;}
        else{i.esq = maiorEsq(i, i.esq);}

        return i;
    }

    // qt de nos

    /*************************************
     * MAIN                              *
     ************************************/
    public static void main(String[] args) {
        No i = null;   
        
        // inserir
        i = insere(i, 10);
        i = insere(i, 5);
        i = insere(i, 15);
        i = insere(i, 8);
        i = insere(i, 3);
        i = insere(i, 11);
        i = insere(i, 17);

        // caminhamentos
        System.out.print("\nCaminhamento central: ");
        caminhamentoCentral(i);
        System.out.print("\nCaminhamento pos: ");
        caminhamentoPos(i);
        System.out.print("\nCaminhamento pre: ");
        caminhamentoPre(i);
        
        System.out.println("\n----------------------------------");
        
        // maior e menor
        System.out.println("Maior valor: " + maiorValor(i));
        System.out.println("Menor valor: " + menorValor(i));
        
        System.out.println("----------------------------------");
        
        // somas
        System.out.println("Soma de valores: " + somaTotal(i));
        System.out.println("Soma de pares: " + somaPar(i));
        System.out.println("Soma de impares: " + somaImpar(i));
        
        System.out.println("----------------------------------");
        
        // imprimir 
        System.out.print("Imprimir pares: ");
        imprimirPares(i);
        System.out.print("\nImprimir impares: ");
        imprimirImpares(i);
        System.out.print("\nImprimir folhas: ");
        imprimirFolhas(i);
        System.out.print("\nImprimir sem folhas: ");
        imprimirSemFolhas(i);
        System.out.print("\nImprimir sub-arvore direita: ");
        subArvoreDir(i);
        System.out.print("\nImprimir sub-arvore esquerda: ");
        subArvoreEsq(i);
        
        System.out.println("\n----------------------------------");
        
        // pesquisar
        System.out.print("Pesquisar 10: ");
        System.out.println(temElemento(i, 10)? "S" : "N");
        System.out.print("Pesquisar 100: ");
        System.out.println(temElemento(i, 100)? "S" : "N");

        // remover
        System.out.println("----------------------------------");
        System.out.println("Remover 8 ");
        System.out.println(remover(i, 8));
        System.out.print("\nCaminhamento central: ");
        caminhamentoCentral(i);

    }
}
