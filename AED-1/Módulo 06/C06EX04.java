import java.util.Scanner;
// atividade do modulo 06 - exercicio 04 por Izabel Oliveira da Paz Chaves (1 periodo de C.C)
// programa para calcular o imc do user
public class C06EX04 {
    public static void main(String[] args) {
        // atribuicao e declarar variaveis
        String nome;
        double peso, altura, imc;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Para o indicador IMC,\nInforme o seu nome: ");
        nome = teclado.nextLine();
        System.out.print("A sua altura: ");
        altura = teclado.nextDouble();
        System.out.print("E o seu peso: ");
        peso = teclado.nextDouble();
        // operacao IMC e condicional
        imc = peso / Math.pow(altura, 2);
        if (imc < 18) {
            System.out.print("A pessoa, " + nome + ", esta desnutrida.");
        } else if (imc < 20) {
            System.out.print("A pessoa, " + nome + ", esta abaixo do peso.");
        } else if (imc > 20 && imc < 25) {
            System.out.print("A pessoa, " + nome + ", esta no peso ideal.");
        } else if (imc > 25 && imc <= 27) {
            System.out.print("A pessoa, " + nome + ", esta acima do peso");
        } else if (imc > 27) {
            System.out.print("A pessoa, " + nome + ", esta obesa");
        }
        teclado.close(); // fechar o teclado fora da condicional
    }
}
