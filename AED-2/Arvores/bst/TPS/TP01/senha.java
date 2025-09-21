package TP01;
import java.util.Scanner;

public class senha{

    // metodo para verificar se a senha eh aceitavel
    public static boolean verificaSenha(String nome){

	String caracterEspecial = "!@#$%¨&*()'^][{}:;?/|ºª~´";

        boolean temOito = false;
	boolean temMaiuscula = false;
	boolean temMinuscula = false;
	boolean temNumero = false;
	boolean temEspecial = false;

        // condicao maisculas e minusculas
	//
	if(nome.length() >= 8) temOito = true;

        for(int i = 0; i < nome.length(); i++){

           char caractere = nome.charAt(i);

            if(caractere >= 'A' && caractere <= 'Z') temMaiuscula = true;
	    else if(caractere >= 'a' && caractere <= 'z') temMinuscula = true;
	    else if(caractere >= '0' && caractere <= '9') temNumero = true;
	    else{
		    for(int j = 0; j < caracterEspecial.length(); j++){
		    
			    if(caractere == caracterEspecial.charAt(j)) temEspecial = true;
		    }
	    }
        }
        return temOito && temMaiuscula && temMinuscula && temNumero && temEspecial;
    }
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);

        String nome;
        nome = teclado.nextLine();

        while(!(nome.length() == 3 && nome.charAt(0) == 'F' && nome.charAt(1) == 'I' && nome.charAt(2) == 'M')){
            System.out.println(verificaSenha(nome)? "SIM" : "NAO");

            nome = teclado.nextLine();
        }

        teclado.close();
    }
}
