package matriz.java;
class Celula {
    int elemento;
    Celula dir, esq, sup, inf;

    Celula(int elemento) {
        this.elemento = elemento;
    }
}

class Matriz {
    int linhas, colunas;
    Celula inicio;

    Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;

        Celula linhaAnterior = null, atual = null, acima = null;

        for (int i = 0; i < linhas; i++) {
            Celula linhaAtual = null;
            for (int j = 0; j < colunas; j++) {
                Celula nova = new Celula(0);

                if (linhaAtual == null)
                    linhaAtual = nova;
                else {
                    atual.dir = nova;
                    nova.esq = atual;
                }

                if (linhaAnterior != null) {
                    acima.inf = nova;
                    nova.sup = acima;
                    acima = acima.dir;
                }

                if (j == 0)
                    atual = nova;
                else
                    atual = atual.dir;

                if (i == 0 && j == 0)
                    inicio = nova;
            }
            linhaAnterior = linhaAtual;
            acima = linhaAtual;
        }
    }
