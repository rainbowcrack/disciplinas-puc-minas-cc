package TP01;
/****************************************
* TP01Q12                               *
* VALIDACAO DE SENHA (JAVA) - ITERATIVO *
*****************************************/
import java.util.Scanner;

public class verificaSenha{

    // metodo para verificar se a senha eh aceitavel
    public static boolean verificaSenha(String nome){

	String caracterEspecial = "!@#$%&*()^][{}:;?/";

  	boolean temOito = nome.length() >= 8;
	boolean temMaiuscula = false;
	boolean temMinuscula = false;
	boolean temNumero = false;
	boolean temEspecial = false;

	// percorre cada caracter na string
        for(int i = 0; i < nome.length(); i++){

           char caractere = nome.charAt(i);

            if(caractere >= 'A' && caractere <= 'Z'){
                temMaiuscula = true; // maiuscula
            }
	        else if(caractere >= 'a' && caractere <= 'z'){
                temMinuscula = true; // minuscula
            }
	        else if(caractere >= '0' && caractere <= '9'){
                temNumero = true; // numero
            }
	        else{
			// percorre o novo array
		        for(int j = 0; j < caracterEspecial.length(); j++){
		    
			        if(caractere == caracterEspecial.charAt(j)){
                        		temEspecial = true; // caracter especial
                   		 }
		        }
	        }
        }
	// retorna uma expressao booleana de AND
        return temOito && temMaiuscula && temMinuscula && temNumero && temEspecial;
    }
	
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        String nome;
        nome = teclado.nextLine();

	// condicao de parada com FLAG "FIM"
        while(!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){

	    // chama a funcao com operador ternario
            System.out.println(verificaSenha(nome)? "SIM" : "N\u00c3O"); // unicode por conta do charset
            nome = teclado.nextLine(); // garante a quebra de linha
        }

        teclado.close();
    }
}
