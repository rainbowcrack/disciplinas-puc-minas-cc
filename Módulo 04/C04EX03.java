import java.util.Scanner;

// atividade do modulo 04 - exercicio 03 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para criar uma tabela sobre o poluente emitido e sua relacao a multa aplicada
public class C04EX03 {
    public static void main(String[] args) {
        // input
        int p_menor, p_maior;
        float multa1, multa2, multa3;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Registre o menor valor do poluente emitido pela empresa: ");
        p_menor = teclado.nextInt();
        System.out.print("E o maior tambem: ");
        p_maior = teclado.nextInt();
        System.out.print("Insira o valor da multa aplicada para o menor poluente emitido: ");
        multa1 = teclado.nextFloat();
        System.out.print("A multa aplicada para o valor intermediario dos poluentes: ");
        multa2 = teclado.nextFloat();
        System.out.print("Multa aplicada para o valor acima da maior emissao: ");
        multa3 = teclado.nextFloat();
        // output
        System.out.println("___________________________________________");
        System.out.print(
                "Quantidade de Poluente Emitido x Valor da Multa" + "\n___________________________________________");
        System.out.printf("\nAte " + p_menor + " multa de R$%1.2f", multa1);
        System.out.print("\n___________________________________________");
        System.out.printf("\nEntre " + p_menor + " e " + p_maior + " multa de R$%1.2f", multa2);
        System.out.print("\n___________________________________________");
        System.out.printf("\nAcima de " + p_maior + " multa de R$%1.2f", multa3);
        System.out.print(" por poluente emitido" + "\n___________________________________________");
        teclado.close();
    }
}
