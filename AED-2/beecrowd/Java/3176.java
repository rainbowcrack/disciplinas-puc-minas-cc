// 3176 - Gnome's Teams
import java.util.Scanner;

public class Main{
    static class Gnomos{
        String nome;
        int idade;
    }
    
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt();
        
        Gnomos[] gnomo = new Gnomos[N];
        
        for(int i = 0; i < N; i++){
            gnomo[i] = new Gnomos();
            gnomo[i].nome = teclado.next(); // Lê o nome primeiro
            gnomo[i].idade = teclado.nextInt(); // Depois a idade
        }
        
        // Bubble Sort corrigido
        for(int i = 0; i < (N-1); i++){
            for(int j = 0; j < (N-1-i); j++){
                if((gnomo[j].idade < gnomo[j+1].idade) || 
                   (gnomo[j].idade == gnomo[j+1].idade && gnomo[j].nome.compareTo(gnomo[j+1].nome) > 0)){
                    Gnomos tmp = gnomo[j];
                    gnomo[j] = gnomo[j+1];
                    gnomo[j+1] = tmp;
                }
            }
        }
        
        // Separar os times corretamente
        int times = N / 3;
        for(int i = 0; i < times; i++){
            System.out.println("Time " + (i+1)); // Corrigido sem ":"

            System.out.println(gnomo[i].nome + " " + gnomo[i].idade);
            System.out.println(gnomo[i + times].nome + " " + gnomo[i + times].idade);
            System.out.println(gnomo[i + 2 * times].nome + " " + gnomo[i + 2 * times].idade);

            if (i < times - 1) { // Impede linha extra no final
                System.out.println();
            }
        }
        
        teclado.close();
    }
}
