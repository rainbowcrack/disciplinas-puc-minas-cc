package matriz.java;

public class inserir {
    void inserir(int l, int c, int valor) {
        Celula temp = inicio;
        for (int i = 0; i < l; i++) temp = temp.inf;
        for (int j = 0; j < c; j++) temp = temp.dir;
        temp.elemento = valor;
    }
}
