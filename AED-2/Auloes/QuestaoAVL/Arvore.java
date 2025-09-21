public class Arvore {
    private No raiz;

    public boolean isAVL(){
        return isAVL(raiz);

    }

    private boolean isAVL(No i){
        boolean resp = true;

        if(i != null){
            int altEsq = getAltura(i.esq);
            int altDir = getAltura(i.dir);

            resp = ((Math.abs(altDir - altEsq)) < 2) && isAVL(i.dir) && isAVL(i.esq);

        }

    }

    public int getAltura(){
        return getAltura(raiz);
    }

    private int getAltura(No i){
        int altura = 0;
        if(i != null){
            int alturaEsq = getAltura(i.esq);
            int alturaDir = getAltura(i.dir);
            altura = 1 + (alturaEsq > alturaDir? alturaEsq : alturaDir);
        }
        return altura;
    }
    
}
