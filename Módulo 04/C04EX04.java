import javax.swing.JOptionPane;

// atividade do módulo 04 - exercício 02 por Izabel Oliveira da Paz Chaves (1º período de C.C)
// programa interativo para mostrar os dados do user pelo JOptionPane
public class C04EX04 {
    public static void main(String[] args) {
        // strings atribuidas ao proprio metodo do JOtptionPane e logica replicada para
        // nome e idade
        String nome1 = JOptionPane.showInputDialog(null,
                "Digite o seu primeiro nome: ",
                "Primeiro nome",
                JOptionPane.QUESTION_MESSAGE);
        String nome2 = JOptionPane.showInputDialog(null,
                "O seu segundo nome: ",
                "Segundo nome",
                JOptionPane.QUESTION_MESSAGE);
        String nome3 = JOptionPane.showInputDialog(null,
                "O seu sobrenome: ",
                "Sobrenome",
                JOptionPane.QUESTION_MESSAGE);
        String idade = JOptionPane.showInputDialog(null,
                "Insira a sua idade: ",
                "Idade",
                JOptionPane.QUESTION_MESSAGE);
        int idade1 = Integer.valueOf(idade);
        JOptionPane.showMessageDialog(null,
                nome3 + ", " + nome1 + " " + nome2 + "\nIdade: " + idade1 + " anos.",
                "Dados do usuario",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
