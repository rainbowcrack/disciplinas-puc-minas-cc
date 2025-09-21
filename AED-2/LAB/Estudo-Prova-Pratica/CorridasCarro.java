import java.util.Scanner;

public class CorridasCarro
{
	// classe Piloto
    static class Piloto {
    String nome;
    int peso;
    int ranking;
    }
    
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        // quantidade de pilotos
        int N = teclado.nextInt();
        Piloto[] piloto = new Piloto[N];
        
        // leitura
        for(int i = 0; i < N; i++){
            piloto[i] = new Piloto();
            
            piloto[i].nome = teclado.next();
            piloto[i].peso = teclado.nextInt();
            piloto[i].ranking = teclado.nextInt();
        }
        
        // menor peso e desempate por ranking
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < N - 1 - i; j++){
                boolean troca = false;
                
                // menor peso
                if(piloto[j].peso > piloto[j+1].peso){
                    troca = true;
                } else if (piloto[j].peso == piloto[j+1].peso){
                    
                    // menor ranking
                    if(piloto[j].ranking > piloto[j+1].ranking){
                        troca = true;
                    }
                }
                
                // swap
                if(troca){
                    Piloto tmp = piloto[j];
                    piloto[j] = piloto[j+1];
                    piloto[j+1] = tmp;
                }
            }
        }
        
        // resultado
        for(int i = 0; i < N; i++){
            System.out.println(piloto[i].nome + " " + piloto[i].peso + " " + piloto[i].ranking);
        }
        teclado.close();
    }
}
