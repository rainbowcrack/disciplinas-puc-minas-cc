package TP01;
/****************************************
* TP01Q07                               *
* INVERSAO DE STRING (JAVA) - ITERATIVO *
*****************************************/

import java.util.Scanner;

public class TP01Q07{
    
    // metodo para escrever invertido
    public static String escreveInvertido(String nome){
        
        char caractere;
        String resultado = "";
        
        // comecar a leitura do char pelo ultimo
        for(int j = nome.length() - 1; j >= 0; j--){
            caractere = nome.charAt(j);
            
            // concatencao de char com acumulador para String
            resultado += caractere;
        }
        
        return resultado;
    }
    
    public static void main(String[] args){
        String nome;
        
        Scanner teclado = new Scanner(System.in);
        
        nome = teclado.nextLine();
        
        // condicao de parada e chamda da funcao
        while(!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){
            System.out.println(escreveInvertido(nome));
            
            nome = teclado.nextLine();
        }
        
        teclado.close();
    }
}
