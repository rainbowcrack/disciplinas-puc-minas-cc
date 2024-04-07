import java.util.Scanner;

// atividade do módulo 04 - exercício 02 por Izabel Oliveira da Paz Chaves (1º período de C.C)
// programa para criar uma ficha funcional a partir dos dados do user
public class C04EX02 {
    public static void main(String[] args) {
        // cpf e ci alternam nas respostas dos user para (.) ou (-), logo string
        String nome, cpf, ci, empresa;
        long n_eleitor, n_motorista;
        float salario;
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
        System.out.print("O numero do seu Titulo de Eleitor: ");
        n_eleitor = teclado.nextLong();
        System.out.print("O numero da sua Carteira de Motorista: ");
        n_motorista = teclado.nextLong();
        System.out.print("E o seu respectivo salario: R$ ");
        salario = teclado.nextFloat();
        System.out.println();
        // ouput e formatacao
        System.out.println("FICHA FUNCIONAL DE: " + nome);
        System.out.println();
        System.out.println("Documentos:");
        System.out.print(
                "CPF .......... " + cpf + "\nC.I. .......... " + ci + " \nTitulo de eleitor .......... "
                        + n_eleitor + "\nCarteira de motorista .......... " + n_motorista);
        System.out.printf("\nEmpresa: " + empresa + "\nSalario: R$%1.2f", salario);
        teclado.close();
    }
}
