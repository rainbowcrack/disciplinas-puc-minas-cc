import java.util.Scanner;

// atividade do módulo 04 - exercício 02 por Izabel Oliveira da Paz Chaves (1º período de C.C)
// programa interativo para mostrar os dados do user pelo JOptionPane
public class C04EX02 {
    public static void main(String[] args) {
        String nome, cpf, ci, empresa;
        long n_eleitor, n_motorista;
        double salario;
        Scanner arquivo = new Scanner(
                C04EX02.class.getResourceAsStream("Dados_C04EX05.txt"));
        nome = arquivo.nextLine();
        cpf = arquivo.nextLine();
        ci = arquivo.nextLine();
        empresa = arquivo.nextLine();
        n_eleitor = arquivo.nextLong();
        n_motorista = arquivo.nextLong();
        salario = arquivo.nextDouble();
        arquivo.nextLine();
        // ouput e formatacao
        System.out.println("\n FICHA FUNCIONAL DE: " + nome);
        System.out.println();
        System.out.println("Documentos:");
        System.out.print(
                "CPF .......... " + cpf + "\nC.I. .......... " + ci + " \nTitulo de eleitor .......... "
                        + n_eleitor + "\nCarteira de motorista .......... " + n_motorista);
        System.out.printf("\nEmpresa: " + empresa + "\nSalario: R$%1.2f", salario);
        arquivo.close();
    }
}
