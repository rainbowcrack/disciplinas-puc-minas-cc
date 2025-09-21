void inserirValor(Matriz* mat, int linha, int coluna, int valor) {
    Celula *temp = mat->inicio;
    for (int i = 0; i < linha; i++) temp = temp->inf;
    for (int j = 0; j < coluna; j++) temp = temp->dir;
    temp->elemento = valor;
}
