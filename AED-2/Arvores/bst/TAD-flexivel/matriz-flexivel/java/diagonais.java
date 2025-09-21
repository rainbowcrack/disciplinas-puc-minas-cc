package matriz.java;

public class diagonais {
    void diagonalPrincipal() {
        Celula temp = inicio;
        for (int i = 0; i < linhas && i < colunas; i++) {
            Celula p = temp;
            for (int j = 0; j < i; j++) p = p.dir;
            System.out.print(p.elemento + " ");
            temp = temp.inf;
        }
        System.out.println();
    }

    void diagonalSecundaria() {
        Celula temp = inicio;
        for (int i = 0; i < linhas && i < colunas; i++) {
            Celula p = temp;
            for (int j = 0; j < colunas - i - 1; j++) p = p.dir;
            System.out.print(p.elemento + " ");
            temp = temp.inf;
        }
        System.out.println();
    }

}
