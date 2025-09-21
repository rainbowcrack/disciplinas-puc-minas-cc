void mostrarDiagonalPrincipal(Matriz* mat) {
    Celula *temp = mat->inicio;
    for (int i = 0; i < mat->linhas && i < mat->colunas; i++) {
        Celula *p = temp;
        for (int j = 0; j < i; j++) p = p->dir;
        printf("%d ", p->elemento);
        temp = temp->inf;
    }
    printf("\n");
}

void mostrarDiagonalSecundaria(Matriz* mat) {
    Celula *temp = mat->inicio;
    for (int i = 0; i < mat->linhas && i < mat->colunas; i++) {
        Celula *p = temp;
        for (int j = 0; j < mat->colunas - i - 1; j++) p = p->dir;
        printf("%d ", p->elemento);
        temp = temp->inf;
    }
    printf("\n");
}
