/**************************
 * Importando bibliotecas *
 *************************/
import java.util.*;
import java.io.*;

/**************************
 * Classe Main            *
 *************************/
public class TP02Q01 {
    public static void main(String[] args) {

        // le o arquvivo csv pelo metodo da classe e faz um vetor de objetos
        SHOW[] shows = SHOW.lerCSV("/tmp/disneyplus.csv");

        Scanner teclado = new Scanner(System.in);
        String entrada = teclado.nextLine();

        // condicao de entrada para diferente de "FIM"
        while (!entrada.equals("FIM")) {
            for (SHOW s : shows) {
                if (s != null && s.getIDFormatado().equals(entrada)) {
                    s.print();
                    break;
                }
            }
            entrada = teclado.nextLine(); // lê a próxima
        }

        teclado.close();
    }
}

/**************************
 * Classe SHOW            *
 *************************/
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

    // construtor vazio
    public SHOW() {}

    // construtor parametrizado
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

    // Getters and Setters
    public int getSHOW_ID() {
        return SHOW_ID;
    }

    public void setSHOW_ID(int SHOW_ID) {
        this.SHOW_ID = SHOW_ID;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getDIRECTOR() {
        return DIRECTOR;
    }

    public void setDIRECTOR(String DIRECTOR) {
        this.DIRECTOR = DIRECTOR;
    }

    public String[] getCAST() {
        return CAST;
    }

    public void setCAST(String[] CAST) {
        this.CAST = CAST;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public DATE getDATA_ADDED() {
        return DATA_ADDED;
    }

    public void setDATA_ADDED(DATE DATA_ADDED) {
        this.DATA_ADDED = DATA_ADDED;
    }

    public int getRELEASE_YEAR() {
        return RELEASE_YEAR;
    }

    public void setRELEASE_YEAR(int RELEASE_YEAR) {
        this.RELEASE_YEAR = RELEASE_YEAR;
    }

    public String getRATING() {
        return RATING;
    }

    public void setRATING(String RATING) {
        this.RATING = RATING;
    }

    public String getDURATION() {
        return DURATION;
    }

    public void setDURATION(String DURATION) {
        this.DURATION = DURATION;
    }

    public String[] getLISTED_IN() {
        return LISTED_IN;
    }

    public void setLISTED_IN(String[] LISTED_IN) {
        this.LISTED_IN = LISTED_IN;
    }

    // Metodo para formatar o ID
    public String getIDFormatado() {
        return "s" + SHOW_ID;
    }

    // Metodo para imprimir as informacoes
    public void print() {
        System.out.print("=> s" + SHOW_ID);

        // obs.: o title vem primeiro do que o type
        System.out.print(" ## " + TITLE);
        System.out.print(" ## " + TYPE);
        System.out.print(" ## " + DIRECTOR);

        // Ordenar copia do array CAST para impressao por ordem alfabetica
        String[] castOrdenado = Arrays.copyOf(CAST, CAST.length);
        Arrays.sort(castOrdenado);
        System.out.print(" ## " + Arrays.toString(castOrdenado));

        System.out.print(" ## " + COUNTRY);

        // verifica se a data eh vazia ou nao
        System.out.print(" ## " + (DATA_ADDED != null ? DATA_ADDED.toString() : "NaN"));
        System.out.print(" ## " + RELEASE_YEAR);
        System.out.print(" ## " + RATING);
        System.out.print(" ## " + DURATION);
        System.out.println(" ## " + Arrays.toString(LISTED_IN) + " ##");
    }

    // Método para ler o arquivo CSV
    public static SHOW[] lerCSV(String nomeArquivo) {
        // vetor de show a partir do tam como id
        SHOW[] vetor = new SHOW[1368];

        // contador ate 12 para ler as colunas
        int contador = 0;

        // trata o erro de leitura vazia
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine(); // Cabecalho
            if (linha == null || !linha.toLowerCase().contains("show_id")) {
                System.out.println("Arquivo CSV invalido.");
                return vetor;
            }

            // limitacao do intervalo
            while ((linha = br.readLine()) != null && contador < vetor.length) {
                String[] dados = dividirCSV(linha);

                if (dados.length < 11) continue;

                // se for vazia, retorna NaN
                for (int i = 0; i < dados.length; i++) {
                    if (dados[i].trim().isEmpty()) dados[i] = "NaN";
                }

                int id;
                try {
                    id = Integer.parseInt(dados[0].substring(1));
                } catch (Exception e) {
                    continue;
                }

                // atribuicao variavel por dado de coluna
                String type = dados[1];
                String title = dados[2];
                String director = dados[3];

                // so faz a divisao por virgulas caso seja fora das aspas ""
                String[] cast = dados[4].equals("NaN") ? new String[] { "NaN" } : dados[4].split(", ");
                String country = dados[5];

                // chama a classe DATE
                DATE dataAdded = null;
                if (!dados[6].equals("NaN")) {
                    dataAdded = new DATE(dados[6]);
                }

                int releaseYear = -1;
                try {
                    releaseYear = Integer.parseInt(dados[7]);
                } catch (Exception e) {}

                String rating = dados[8];
                String duration = dados[9];
                String[] listedIn = dados[10].equals("NaN") ? new String[] { "NaN" } : dados[10].split(", ");

                vetor[contador++] = new SHOW(id, type, title, director, cast, country, dataAdded, releaseYear, rating, duration, listedIn);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return vetor;
    }

    // Metodo auxiliar para dividir as linhas do CSV
    private static String[] dividirCSV(String linha) {
        List<String> campos = new ArrayList<>();
        StringBuilder atual = new StringBuilder();
        boolean aspas = false;

        for (int i = 0; i < linha.length(); i++) {

            // linhas do CSV
            char c = linha.charAt(i);

            if (c == '\"') {
                aspas = !aspas;
            } else if (c == ',' && !aspas) {
                campos.add(atual.toString().trim());
                atual.setLength(0);
            } else {
                atual.append(c);
            }
        }

        campos.add(atual.toString().trim());
        return campos.toArray(new String[0]);
    }

    // Metodo de clonagem
    public SHOW clone() {
        // Criando uma nova instancia do objeto SHOW com os mesmos dados
        SHOW clonedShow = new SHOW(
            this.SHOW_ID,
            this.TYPE,
            this.TITLE,
            this.DIRECTOR,
            Arrays.copyOf(this.CAST, this.CAST.length), // Clonando o array CAST
            this.COUNTRY,
            this.DATA_ADDED != null ? new DATE(this.DATA_ADDED.toString()) : null, // Clonando o objeto DATE
            this.RELEASE_YEAR,
            this.RATING,
            this.DURATION,
            Arrays.copyOf(this.LISTED_IN, this.LISTED_IN.length) // Clonando o array LISTED_IN
        );
        
        return clonedShow;
    }
}

// Classe DATE
class DATE {
    private String dataCompleta;

    public DATE(String dataCompleta) {
        this.dataCompleta = dataCompleta;
    }

    public String toString() {
        return dataCompleta;
    }
}
