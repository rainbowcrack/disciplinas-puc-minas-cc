Matriz* somarMatrizes(Matriz* a, Matriz* b) {
    Matriz* soma = criarMatriz(a->linhas, a->colunas);
    Celula *pa = a->inicio, *pb = b->inicio, *ps = soma->inicio;

    for (int i = 0; i < a->linhas; i++) {
        Celula *ca = pa, *cb = pb, *cs = ps;
        for (int j = 0; j < a->colunas; j++) {
            cs->elemento = ca->elemento + cb->elemento;
            ca = ca->dir;
            cb = cb->dir;
            cs = cs->dir;
        }
        pa = pa->inf;
        pb = pb->inf;
        ps = ps->inf;
    }

    return soma;
}
