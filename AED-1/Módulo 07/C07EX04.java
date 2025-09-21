import java.util.Scanner;

// atividade do modulo 07 - exercicio 04 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para associar os times de futebol com os Estados brasileiros
public class C07EX04 {
    public static void main(String[] args) {
        // input, variaveis e biblioteca
        String time;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para saber o Estado,\nInforme o time de futebol: ");
        time = teclado.nextLine();
        // switch
        switch (time) {
            case "America": case "Atletico": case "Cruzeiro": case "Villa Nova":
                System.out.print("\nMinas Gerais.");
                break;
            case "Botafogo": case "Flamengo": case "Fluminense": case "Vasco":
                System.out.print("\nRio de Janeiro.");
                break;
            case "Corinthians": case "Palmeiras": case "Santos": case "Sao Paulo":
                System.out.print("\nSao Paulo.");
                break;
            case "Gremio": case "Internacional": case "Juventude":
                System.out.print("\nRio Grande do Sul.");
                break;
            case "Nautico": case "Santa Cruz": case "Sport":
                System.out.print("\nPernambuco.");
                break;
            default:
                System.out.print("\nTime nao catalogado.");
                break;
        }
        teclado.close();
    }
}
