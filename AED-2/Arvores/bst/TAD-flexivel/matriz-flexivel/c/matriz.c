typedef struct Celula {
    int elemento;
    struct Celula *dir, *esq, *sup, *inf;
} Celula;

typedef struct Matriz {
    int linhas, colunas;
    Celula *inicio;
} Matriz;

Matriz* criarMatriz(int linhas, int colunas) {
    Matriz* mat = (Matriz*)malloc(sizeof(Matriz));
    mat->linhas = linhas;
    mat->colunas = colunas;

    Celula *linhaAnterior = NULL, *atual = NULL, *acima = NULL;

    for (int i = 0; i < linhas; i++) {
        Celula *linhaAtual = NULL;
        for (int j = 0; j < colunas; j++) {
            Celula *nova = (Celula*)malloc(sizeof(Celula));
            nova->elemento = 0;
            nova->dir = nova->esq = nova->sup = nova->inf = NULL;

            if (linhaAtual == NULL)
                linhaAtual = nova;
            else {
                atual->dir = nova;
                nova->esq = atual;
            }

            if (linhaAnterior != NULL) {
                acima->inf = nova;
                nova->sup = acima;
                acima = acima->dir;
            }

            if (j == 0)
                atual = nova;
            else
                atual = atual->dir;

            if (i == 0 && j == 0)
                mat->inicio = nova;
        }
        linhaAnterior = linhaAtual;
        acima = linhaAtual;
    }
    return mat;
}