import java.util.Scanner;

public class Pokemon{
    
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        // a quantidade de pokemons
        int N = teclado.nextInt();
        
        // armazena os pokemons
        String[] pokemons = new String[N];
        for(int i = 0; i < N; i++){
            pokemons[i] = teclado.next();
        }
        
        // contador
        int count = 0;
        
        // conta os pokemons repetidos
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(pokemons[i].equals(pokemons[j])) count++;
            }
        }
        
        // tira os pokemons repetidos
        int qt = 151 - (N - count);
        
        System.out.println("Falta(m) " + qt + " pomekons(s).");
        teclado.close();
    }
}
