import java.util.Scanner;
// atividade do modulo 06 - exercicio 17 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para saber se o entrevistador esta apto (RH)
public class HelloWorld {
    // variaveis booleanas, biblioteca
    public static void main(String[] args) {
        boolean tecnico, superior, experiencia, criatividade, liderar, grupo, autodidata, salario, lugar;
        Scanner teclado = new Scanner(System.in);
        // input que igora case sensitive
        System.out.print("Responda, com V para Verdadeiro ou F para Falso:\nVoce tem curso tecnico de programacao: ");
        tecnico = teclado.next().equalsIgnoreCase("V");
        System.out.print("Voce tem curso superior de programacao: ");
        superior = teclado.next().equalsIgnoreCase("V");
        System.out.print("Voce tem menos de 3 anos de experiencia em programacao: ");
        experiencia = teclado.next().equalsIgnoreCase("V");
        System.out.print("Voce se considera uma pessoa criativa: ");
        criatividade = teclado.next().equalsIgnoreCase("V");
        System.out.print("Voce prefere liderar a ser liderado: ");
        liderar = teclado.next().equalsIgnoreCase("V");
        System.out.print("Voce prefere trabalhar sozinho a trabalhar em equipe: ");
        grupo = teclado.next().equalsIgnoreCase("V");
        System.out.print("Voce e autodidata (aprende sozinho): ");
        autodidata = teclado.next().equalsIgnoreCase("V");
        System.out.print("Voce aceitaria uma remuneracao inicial de R$1500: ");
        salario = teclado.next().equalsIgnoreCase("V");
        System.out.print("Voce so aceitaria trabalhar em escritorios da empresa dentro da grande BH: ");
        lugar = teclado.next().equalsIgnoreCase("V");
        // Verificacao da habilidade de programador
        // && inclusao de habilidade || ou para sentencas ! para falso
        if ((tecnico && !experiencia) || (superior && !experiencia) || (experiencia && criatividade && !liderar && !grupo && autodidata && salario && lugar)) {
            System.out.println("\nVoce esta apto para exercer a funcao de programador na empresa.");
        } else {
            System.out.println("\nVoce nao esta apto para exercer a funcao de programador na empresa.");
        }
        teclado.close(); // fechar fora da condicional
    }
}
