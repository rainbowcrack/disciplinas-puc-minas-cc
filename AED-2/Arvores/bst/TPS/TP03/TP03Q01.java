import java.util.*;
import java.io.*;

/***************
 * CLASSE MAIN *
 ***************/

public class TP03Q01 {
    public static void main(String[] args) {

        // leitura do caminho do arquivo
        SHOW[] shows = SHOW.lerCSV("/tmp/disneyplus.csv");

        Scanner teclado = new Scanner(System.in);
        ArrayList<SHOW> selecionados = new ArrayList<>();

        // Leitura dos IDs
        String entrada = teclado.nextLine();
        while (!entrada.equals("FIM")) {
            for (SHOW s : shows) {
                if (s != null && s.getIDFormatado().equals(entrada)) {
                    selecionados.add(s.clone());
                    break;
                }
            }
            entrada = teclado.nextLine();
        }

        // cria um tam fixo para armazenar os ID's na lista
        ListaAlocada lista = new ListaAlocada(200);
        for (SHOW show : selecionados) {
            try {
                lista.inserirFim(show);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        int qt = Integer.parseInt(teclado.nextLine());
        for (int i = 0; i < qt; i++) {
            String linha = teclado.nextLine();
            String[] partes = linha.split(" ");

            // testa possiveis casos de insercao e remocao na lista
            try {
                switch (partes[0]) {
                    case "II":
                        lista.inserirInicio(buscarPorID(shows, partes[1]));
                        break;
                    case "IF":
                        lista.inserirFim(buscarPorID(shows, partes[1]));
                        break;
                    case "I*":
                        int pos = Integer.parseInt(partes[1]);
                        lista.inserir(buscarPorID(shows, partes[2]), pos);
                        break;
                    case "RI":
                        lista.removerInicio();
                        break;
                    case "RF":
                        lista.removerFim();
                        break;
                    case "R*":
                        lista.remover(Integer.parseInt(partes[1]));
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        teclado.close();

        // primeiro os removidos e depois a lista
        lista.imprimirRemovidos();
        lista.imprimirLista();
    }

    private static SHOW buscarPorID(SHOW[] shows, String id) {
        for (SHOW s : shows) {
            if (s != null && s.getIDFormatado().equals(id)) {
                return s.clone();
            }
        }
        return null;
    }
}

/************************
 * CLASSE LISTA ALOCADA *
 ***********************/

class ListaAlocada {
    private SHOW[] lista;
    private int tamanho;
    private ArrayList<String> removidos;

    public ListaAlocada(int capacidade) {
        lista = new SHOW[capacidade];
        tamanho = 0;
        removidos = new ArrayList<>();
    }

    // insercao no inicio
    // II
    void inserirInicio(SHOW show) throws Exception {
        if (tamanho >= lista.length) throw new Exception("Erro, lista cheia");
        for (int i = tamanho; i > 0; i--) {
            lista[i] = lista[i - 1];
        }
        lista[0] = show;
        tamanho++;
    }

    // insercao na posicao
    // I*
    void inserir(SHOW show, int posicao) throws Exception {
        if (posicao < 0 || posicao > tamanho || tamanho >= lista.length)
            throw new Exception("Erro, posicao inválida");
        for (int i = tamanho; i > posicao; i--) {
            lista[i] = lista[i - 1];
        }
        lista[posicao] = show;
        tamanho++;
    }

    // insercao no fim
    // IF
    void inserirFim(SHOW show) throws Exception {
        if (tamanho >= lista.length) throw new Exception("Erro, lista cheia");
        lista[tamanho++] = show;
    }

    // remocao no inicio
    // RI
    SHOW removerInicio() throws Exception {
        if (tamanho == 0) throw new Exception("Erro, lista vazia");
        SHOW removido = lista[0];
        for (int i = 0; i < tamanho - 1; i++) {
            lista[i] = lista[i + 1];
        }
        tamanho--;
        removidos.add("(R) " + removido.getTITLE());
        return removido;
    }

    // remocao na posicao
    // R*
    SHOW remover(int posicao) throws Exception {
        if (posicao < 0 || posicao >= tamanho) throw new Exception("Erro, posicao inválida");
        SHOW removido = lista[posicao];
        for (int i = posicao; i < tamanho - 1; i++) {
            lista[i] = lista[i + 1];
        }
        tamanho--;
        removidos.add("(R) " + removido.getTITLE());
        return removido;
    }

    // remover no fim
    // RF
    SHOW removerFim() throws Exception {
        if (tamanho == 0) throw new Exception("Erro, lista vazia");
        SHOW removido = lista[--tamanho];
        removidos.add("(R) " + removido.getTITLE());
        return removido;
    }

    // imprime os removidos e depois a lista
    void imprimirRemovidos() {
        for (String s : removidos) {
            System.out.println(s);
        }
    }

    void imprimirLista() {
        for (int i = 0; i < tamanho; i++) {
            lista[i].print();
        }
    }
}
/***************
 * CLASSE SHOW *
 **************/

class SHOW {

    // atributos
    private int SHOW_ID;
    private String TYPE;
    private String TITLE;
    private String DIRECTOR;
    private String[] CAST;
    private String COUNTRY;
    private DATE DATA_ADDED;
    private int RELEASE_YEAR;
    private String RATING;
    private String DURATION;
    private String[] LISTED_IN;

    // construtor vazio e assinado
    public SHOW() {}

    public SHOW(int SHOW_ID, String TYPE, String TITLE, String DIRECTOR, String[] CAST, String COUNTRY, DATE DATA_ADDED, int RELEASE_YEAR, String RATING, String DURATION, String[] LISTED_IN) {
        this.SHOW_ID = SHOW_ID;
        this.TYPE = TYPE;
        this.TITLE = TITLE;
        this.DIRECTOR = DIRECTOR;
        this.CAST = CAST;
        this.COUNTRY = COUNTRY;
        this.DATA_ADDED = DATA_ADDED;
        this.RELEASE_YEAR = RELEASE_YEAR;
        this.RATING = RATING;
        this.DURATION = DURATION;
        this.LISTED_IN = LISTED_IN;
    }

    public String getIDFormatado() {
        return "s" + SHOW_ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    // imprimir formatado
    public void print() {
        System.out.print("=> s" + SHOW_ID);
        System.out.print(" ## " + TITLE);
        System.out.print(" ## " + TYPE);
        System.out.print(" ## " + DIRECTOR);

        String[] castOrdenado = Arrays.copyOf(CAST, CAST.length);
        Arrays.sort(castOrdenado);
        System.out.print(" ## " + Arrays.toString(castOrdenado));

        System.out.print(" ## " + COUNTRY);
        System.out.print(" ## " + (DATA_ADDED != null ? DATA_ADDED.toString() : "NaN"));
        System.out.print(" ## " + RELEASE_YEAR);
        System.out.print(" ## " + RATING);
        System.out.print(" ## " + DURATION);
        System.out.println(" ## " + Arrays.toString(LISTED_IN) + " ##");
    }

    // cria um clone do objeto 
    public SHOW clone() {
        return new SHOW(
            this.SHOW_ID, this.TYPE, this.TITLE, this.DIRECTOR,
            Arrays.copyOf(this.CAST, this.CAST.length),
            this.COUNTRY,
            this.DATA_ADDED != null ? new DATE(this.DATA_ADDED.toString()) : null,
            this.RELEASE_YEAR,
            this.RATING,
            this.DURATION,
            Arrays.copyOf(this.LISTED_IN, this.LISTED_IN.length)
        );
    }

    public static SHOW[] lerCSV(String nomeArquivo) {
        SHOW[] vetor = new SHOW[1368];
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine(); // header
            while ((linha = br.readLine()) != null && contador < vetor.length) {
                String[] dados = dividirCSV(linha);
                if (dados.length < 11) continue;

                for (int i = 0; i < dados.length; i++) {
                    if (dados[i].trim().isEmpty()) dados[i] = "NaN";
                }

                int id;
                try {
                    id = Integer.parseInt(dados[0].substring(1));
                } catch (Exception e) {
                    continue;
                }

                String type = dados[1];
                String title = dados[2];
                String director = dados[3];
                String[] cast = dados[4].equals("NaN") ? new String[] { "NaN" } : dados[4].split(", ");
                String country = dados[5];
                DATE dataAdded = !dados[6].equals("NaN") ? new DATE(dados[6]) : null;
                int releaseYear = -1;
                try {
                    releaseYear = Integer.parseInt(dados[7]);
                } catch (Exception ignored) {}

                String rating = dados[8];
                String duration = dados[9];
                String[] listedIn = dados[10].equals("NaN") ? new String[] { "NaN" } : dados[10].split(", ");

                vetor[contador++] = new SHOW(id, type, title, director, cast, country, dataAdded, releaseYear, rating, duration, listedIn);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }

        return vetor;
    }

    // divide o arquivo CSV por indices no array
    private static String[] dividirCSV(String linha) {
        List<String> campos = new ArrayList<>();
        boolean dentroDeAspas = false;
        StringBuilder campoAtual = new StringBuilder();

        for (char c : linha.toCharArray()) {
            if (c == '"') {
                dentroDeAspas = !dentroDeAspas;
            } else if (c == ',' && !dentroDeAspas) {
                campos.add(campoAtual.toString().trim());
                campoAtual = new StringBuilder();
            } else {
                campoAtual.append(c);
            }
        }
        campos.add(campoAtual.toString().trim());
        return campos.toArray(new String[0]);
    }
}

/***************
 * CLASSE DATA *
 **************/

class DATE {

    // atributo
    private String dataCompleta;

    // metodos
    public DATE(String dataCompleta) {
        this.dataCompleta = dataCompleta;
    }

    public String toString() {
        return dataCompleta;
    }
}
