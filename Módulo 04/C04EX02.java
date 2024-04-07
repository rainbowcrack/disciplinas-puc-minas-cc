import java.util.Scanner;

// atividade do módulo 04 - exercício 02 por Izabel Oliveira da Paz Chaves (1º período de C.C)
public class C04EX02 {
    public static void main(String[] args) {
        // cpf, ci e salario alternam nas respostas dos user para (.) (,) ou (-)
        // deixarei em string
        String nome, cpf, ci, empresa, salario;
        long n_eleitor, n_motorista;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Escreva o seu nome completo: ");
        // para converter os dados para maisculo
        nome = teclado.nextLine().toUpperCase();
        System.out.print("Informe o seu CPF: ");
        cpf = teclado.nextLine();
        System.out.print("O numero da sua Carteira de Identidade: ");
        ci = teclado.nextLine();
        System.out.print("A empresa em que trabalha: ");
        empresa = teclado.nextLine();
        System.out.print("O seu respectivo salario: R$ ");
        salario = teclado.nextLine();
        System.out.print("O numero do seu Titulo de Eleitor: ");
        n_eleitor = teclado.nextLong();
        System.out.print("E o numero da sua Carteira de Motorista: ");
        n_motorista = teclado.nextLong();
        System.out.println();
        // ouput e formatacao
        System.out.println("FICHA FUNCIONAL DE: " + nome);
        System.out.println();
        System.out.printf("Documentos:" + "\n");
        System.out.printf(
                "CPF .......... " + cpf + "\n" + "C.I. .......... " + ci + "\n" + "Titulo de eleitor .......... "
                        + n_eleitor + "\n" + "Carteira de motorista .......... " + n_motorista + "\n");
        System.out.println();
        System.out.printf("Empresa: " + empresa + "\n" + "Salario: R$" + salario);
        teclado.close();
    }
}
