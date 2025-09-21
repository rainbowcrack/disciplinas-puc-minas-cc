package matriz.java;
public class Teste {
    public static void main(String[] args) {
        Matriz m1 = new Matriz(3, 3);
        Matriz m2 = new Matriz(3, 3);

        m1.inserir(0, 0, 1); m1.inserir(0, 1, 2); m1.inserir(0, 2, 3);
        m1.inserir(1, 0, 4); m1.inserir(1, 1, 5); m1.inserir(1, 2, 6);
        m1.inserir(2, 0, 7); m1.inserir(2, 1, 8); m1.inserir(2, 2, 9);

        m1.diagonalPrincipal();    // 1 5 9
        m1.diagonalSecundaria();   // 3 5 7

        Matriz soma = Matriz.somar(m1, m1);
        soma.diagonalPrincipal(); // 2 10 18
    }
}
