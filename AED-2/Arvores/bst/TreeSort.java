class No {
    int valor;
    No esq, dir;
    
    No(int valor) {
        this.valor = valor;
        // esq e dir já vêm null por padrão
    }
}

public class TreeSort {
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
    static void imprimir(No i) {
        if (i != null) {
            imprimir(i.esq);
            System.out.print(i.valor + " ");
            imprimir(i.dir);
        }
    }

    public static void main(String[] args) {
        No i = null;                // iniciar árvore vazia
        i = insere(i, 10);
        i = insere(i, 5);
        i = insere(i, 15);
        i = insere(i, 8);
        i = insere(i, 3);
        i = insere(i, 11);
        i = insere(i, 17);

        imprimir(i);                // saída: 3 5 8 10 11 15 17 
    }
}
