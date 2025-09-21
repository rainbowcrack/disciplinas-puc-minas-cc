import java.util.Scanner;

public class Warmup2{
    
    // classe Atleta
    static class Atleta{
        String nome;
        int peso;
    }
    
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        // tamanho max e array de objetos
        int N = teclado.nextInt();
        // limpa o buffer
        teclado.nextLine();
        
        Atleta[] atleta = new Atleta[N];
        
        // faz a leitura
        for(int i = 0; i < N; i++){
            atleta[i] = new Atleta();
            
            atleta[i].nome = teclado.next(); // leitura sem quebra de linha
            atleta[i].peso = teclado.nextInt();
            // limpa buffer
            teclado.nextLine();
        }
        
        // ordena por maior peso, empate ordem alfabetica (bubble sort)
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < N - 1 - i; j++){
                
                // comparacao por peso
                if(atleta[j].peso < atleta[j+1].peso){
                    Atleta tmp = atleta[j];
                    atleta[j] = atleta[j+1];
                    atleta[j+1] = tmp;
                    
                } else if(atleta[j].peso == atleta[j+1].peso){
                    
                    // comparacao por ordem alfabetica
                    if(atleta[j].nome.compareTo(atleta[j+1].nome) > 0){
                        // swap
                        Atleta tmp = atleta[j];
                        atleta[j] = atleta[j+1];
                        atleta[j+1] = tmp;
                    }
                }
            }
        }
        
        // imprimir resultados
        for(int i = 0; i < N; i++){
            System.out.println(atleta[i].nome + " " + atleta[i].peso);
        }
        
        teclado.close();
        
    }
}
