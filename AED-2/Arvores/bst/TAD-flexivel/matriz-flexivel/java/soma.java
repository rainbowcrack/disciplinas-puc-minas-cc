package matriz.java;

public class soma {
    static Matriz somar(Matriz a, Matriz b) {
        Matriz res = new Matriz(a.linhas, a.colunas);

        Celula pa = a.inicio, pb = b.inicio, pr = res.inicio;

        for (int i = 0; i < a.linhas; i++) {
            Celula ca = pa, cb = pb, cr = pr;
            for (int j = 0; j < a.colunas; j++) {
                cr.elemento = ca.elemento + cb.elemento;
                ca = ca.dir;
                cb = cb.dir;
                cr = cr.dir;
            }
            pa = pa.inf;
            pb = pb.inf;
            pr = pr.inf;
        }

        return res;
    }

}
