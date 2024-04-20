import java.util.Scanner;
// atividade do modulo 06 - exercicio 11 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para saber a pontuacao da equipe de volei a partir dos pontos de set
class C06EX11 {
    public static void main(String[] args) {
        String equipe1, equipe2;
        int set1, set2;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para saber a pontuacao dos times de volei,\nInforme o nome da Equipe 1: ");
        equipe1 = teclado.nextLine();
        System.out.print("E o nome da Equipe 2: ");
        equipe2 = teclado.nextLine();
        System.out.print("Sets ganhos da Equipe 1: ");
        set1 = teclado.nextInt();
        System.out.print("Sets ganhos da Equipe 2: ");
        set2 = teclado.nextInt();
        // condicional
        if ((set1 == 3 && set2 == 0) || (set1 == 3 && set2 == 1)) // 3x0 ou 3x1 ganha equipe1
            System.out.print("\nPontos " + equipe1 + " = 3" + " Pontos " + equipe2 + " = 0");
        else if (set1 == 3 && set2 == 2) // 3x2 ganha equipe1
            System.out.print("\nPontos " + equipe1 + " = 2" + " Pontos " + equipe2 + " = 1");
        else if ((set2 == 3 && set1 == 0) || (set2 == 3 && set1 == 1)) // 3x0 ou 3x1 ganha equipe2
            System.out.print("\nPontos " + equipe1 + " = 0" + " Pontos " + equipe2 + " = 3");
        else if (set2 == 3 && set1 == 2) // 3x2 ganha equipe2
            System.out.print("\nPontos " + equipe1 + " = 1" + " Pontos " + equipe2 + " = 2");
        teclado.close();        
    }
}
