import java.util.Scanner;

// cria uma celula (bloquinho matriz)
class Celula {
    int elemento;
    Celula dir, esq, sup, inf;

    Celula(int elemento) {
        this.elemento = elemento;
        this.dir = null;
        this.esq = null;
        this.sup = null;
        this.inf = null;
    }
}

// cria uma matriz flexivel
class Matriz {
    int linhas, colunas;
    Celula inicio;

    Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;

        this.inicio = null; // inicializa a primeira celula com null

        Celula linhaAnteriorCabeca = null; // celula cabeca

        for (int i = 0; i < linhas; i++) {
            Celula linhaAtualCabeca = null; 
            Celula atual = null; 
            Celula acima = linhaAnteriorCabeca; // ponteiro

            for (int j = 0; j < colunas; j++) {
                Celula nova = new Celula(0);

                // conecta horizontal
                if (linhaAtualCabeca == null) {
                    linhaAtualCabeca = nova; 
                } else {
                    atual.dir = nova;
                    nova.esq = atual;
                }
                atual = nova; 

                // conecta vertical
                if (acima != null) {
                    acima.inf = nova;
                    nova.sup = acima;
                    acima = acima.dir; 
                }

                if (i == 0 && j == 0) {
                    this.inicio = nova;
                }
            }
            linhaAnteriorCabeca = linhaAtualCabeca; 
        }
    }

    // metodo para ler os elementos da matriz
    public void ler(Scanner scanner) {
        Celula linhaTemp = inicio;
        for (int i = 0; i < linhas; i++) {
            Celula colTemp = linhaTemp;
            for (int j = 0; j < colunas; j++) {
                colTemp.elemento = scanner.nextInt(); 
                colTemp = colTemp.dir;
            }
            linhaTemp = linhaTemp.inf;
        }
    }

    // metodo para mostrar os elementos da matriz
    public void mostrar() {
        Celula linhaTemp = inicio;
        for (int i = 0; i < linhas; i++) {
            Celula colTemp = linhaTemp;
            for (int j = 0; j < colunas; j++) {
                System.out.print(colTemp.elemento + (j == colunas - 1 ? "" : " ")); 
                colTemp = colTemp.dir;
            }
            System.out.println(); 
            linhaTemp = linhaTemp.inf;
        }
    }

    // metodo para somar duas matrizes
    public Matriz soma(Matriz b) {
        if (this.linhas != b.linhas || this.colunas != b.colunas) {
            throw new IllegalArgumentException("A");
        }

        Matriz res = new Matriz(this.linhas, this.colunas); // Cria uma nova matriz para o resultado

        Celula pa = this.inicio; // Ponteiro para a matriz 'a'
        Celula pb = b.inicio; // Ponteiro para a matriz 'b'
        Celula pr = res.inicio; // Ponteiro para a matriz resultado 'res'

        for (int i = 0; i < this.linhas; i++) {
            Celula ca = pa; // Célula atual na linha para a matriz 'a'
            Celula cb = pb; // Célula atual na linha para a matriz 'b'
            Celula cr = pr; // Célula atual na linha para a matriz resultado 'res'

            for (int j = 0; j < this.colunas; j++) {
                cr.elemento = ca.elemento + cb.elemento; // Soma os elementos

                ca = ca.dir;
                cb = cb.dir;
                cr = cr.dir;
            }
            pa = pa.inf; // Move para a próxima linha na matriz 'a'
            pb = pb.inf; // Move para a próxima linha na matriz 'b'
            pr = pr.inf; // Move para a próxima linha na matriz resultado 'res'
        }

        return res;
    }

    // Método para multiplicar duas matrizes
    public Matriz multiplicacao(Matriz b) {
        // Verifica se as dimensões são compatíveis para multiplicação
        // (número de colunas da primeira matriz deve ser igual ao número de linhas da segunda)
        if (this.colunas != b.linhas) {
            throw new IllegalArgumentException("Número de colunas da primeira matriz deve ser igual ao número de linhas da segunda para multiplicação.");
        }

        Matriz res = new Matriz(this.linhas, b.colunas); // Cria a matriz resultado com as dimensões apropriadas

        Celula pr = res.inicio; // Ponteiro para a matriz resultado

        for (int i = 0; i < this.linhas; i++) { // Percorre as linhas da primeira matriz
            Celula cr = pr; // Célula atual na linha da matriz resultado
            for (int j = 0; j < b.colunas; j++) { // Percorre as colunas da segunda matriz
                int sum = 0;
                Celula ca = this.inicio; // Começa da primeira célula da primeira matriz
                Celula cb = b.inicio; // Começa da primeira célula da segunda matriz

                // Move 'ca' para a célula inicial correta para a linha 'i'
                for (int k = 0; k < i; k++) {
                    ca = ca.inf;
                }
                // Move 'cb' para a célula inicial correta para a coluna 'j'
                for (int k = 0; k < j; k++) {
                    cb = cb.dir;
                }

                // Realiza o produto escalar (soma dos produtos)
                for (int k = 0; k < this.colunas; k++) { // (ou b.linhas, que são iguais)
                    sum += ca.elemento * cb.elemento;
                    ca = ca.dir; // Move para a próxima coluna na primeira matriz
                    cb = cb.inf; // Move para a próxima linha na segunda matriz
                }
                cr.elemento = sum; // Define a soma calculada na célula resultado
                cr = cr.dir; // Move para a próxima coluna na matriz resultado
            }
            pr = pr.inf; // Move para a próxima linha na matriz resultado
        }
        return res;
    }

    // Método para exibir a diagonal principal
    public void mostrarDiagonalPrincipal() {
        Celula temp = inicio;
        // Percorre a diagonal principal (onde linha == coluna)
        for (int i = 0; i < linhas && i < colunas; i++) {
            Celula p = temp; // Ponteiro temporário para a célula atual na diagonal
            System.out.print(p.elemento + (i == Math.min(linhas, colunas) - 1 ? "" : " ")); // Imprime com espaço, sem espaço após o último elemento

            // Verifica se não é o último elemento da diagonal antes de tentar mover 'temp'
            if (i < linhas - 1 && i < colunas - 1) {
                temp = temp.inf.dir; // Move para a próxima célula na diagonal (uma para baixo, uma para a direita)
            }
        }
        System.out.println(); // Nova linha após imprimir a diagonal
    }

    // Método para exibir a diagonal secundária
    public void mostrarDiagonalSecundaria() {
        Celula temp = inicio;
        // Move 'temp' para a primeira célula da diagonal secundária (linha 0, coluna 'colunas - 1')
        for (int j = 0; j < colunas - 1; j++) {
            temp = temp.dir;
        }

        // Percorre a diagonal secundária
        for (int i = 0; i < linhas && i < colunas; i++) {
            Celula p = temp; // Ponteiro temporário para a célula atual
            System.out.print(p.elemento + (i == Math.min(linhas, colunas) - 1 ? "" : " ")); // Imprime com espaço, sem espaço após o último elemento
            
            // Move 'temp' para a próxima célula na diagonal secundária (uma para baixo, uma para a esquerda)
            if (temp != null && temp.inf != null && temp.inf.esq != null) { // Adiciona verificações para evitar NullPointerException
                 temp = temp.inf.esq;
            } else { // Se não houver mais elementos válidos na diagonal, para
                break;
            }
        }
        System.out.println(); // Nova linha após imprimir a diagonal
    }
}

// Main.java (ou TP03Q11.java, se esse for o nome do arquivo principal)
public class TP03Q11 { // O nome da classe pública deve corresponder ao nome do arquivo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCasosTeste = scanner.nextInt(); // Lê o número de casos de teste

        for (int k = 0; k < numCasosTeste; k++) {
            // Lê as dimensões e os elementos para a primeira matriz
            int l1 = scanner.nextInt();
            int c1 = scanner.nextInt();
            Matriz matriz1 = new Matriz(l1, c1);
            matriz1.ler(scanner);

            // Lê as dimensões e os elementos para a segunda matriz
            int l2 = scanner.nextInt();
            int c2 = scanner.nextInt();
            Matriz matriz2 = new Matriz(l2, c2);
            matriz2.ler(scanner);

            // Saída: Diagonais da primeira matriz
            matriz1.mostrarDiagonalPrincipal();
            matriz1.mostrarDiagonalSecundaria();

            // Saída: Matriz de soma
            try {
                Matriz matrizSoma = matriz1.soma(matriz2);
                matrizSoma.mostrar();
            } catch (IllegalArgumentException e) {
                // O enunciado implica que as somas sempre serão possíveis.
                // Se não fossem, você poderia imprimir uma mensagem de erro aqui.
            }

            // Saída: Matriz de multiplicação
            try {
                Matriz matrizMultiplicacao = matriz1.multiplicacao(matriz2);
                matrizMultiplicacao.mostrar();
            } catch (IllegalArgumentException e) {
                // Similarmente, o enunciado implica que as multiplicações sempre serão possíveis.
                // Se não fossem, você poderia imprimir uma mensagem de erro aqui.
            }
        }

        scanner.close(); // Fecha o scanner
    }
}
