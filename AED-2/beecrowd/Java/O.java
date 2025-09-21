import java.util.Scanner;

// cria uma classe pais
class Pais{
    String nome;
    int ouro;
    int prata;
    int bronze;
    
    // define seu construtor
    public Pais(String nome, int ouro, int prata, int bronze){
        
        this.nome = nome;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }
    
    // comparador de objetos
}
public class Main
{
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int qtPais;
		
		qtPais = teclado.nextInt();
		String[] paises = new String[qtPais];
		
		for(int i = 0; i < qtPais; i++){
		
		    paises[i] = teclado.nextLine();
		}
	}
}

CONCERTAR ISSO AQUI
