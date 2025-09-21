import java.util.Scanner;

public class Warmup{
    
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
        // teclado.nextLine();
        
        Atleta[] atleta = new Atleta[N];
        
        // faz a leitura
        for(int i = 0; i < N; i++){
            atleta[i] = new Atleta();
            
            atleta[i].nome = teclado.next(); // leitura sem quebra de linha
            atleta[i].peso = teclado.nextInt();
            // limpa buffer
            // teclado.nextLine();
        }

        // leitura ate EOF
        /*
        while (teclado.hasNextLine() && count < MAX_ATLETAS) {
            if (!teclado.hasNext()) break; // fim da entrada
            String nome = teclado.next();
            if (!teclado.hasNextInt()) break;
            int peso = teclado.nextInt();
            teclado.nextLine(); // limpa o resto da linha (como em C)

            atletas[count] = new Atleta();
            atletas[count].nome = nome;
            atletas[count].peso = peso;
            count++;
        }
        */
        
        // ordena por maior peso, empate ordem alfabetica (bubble sort)
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < N - 1 - i; j++){
                boolean trocou = false;
                
                // comparacao por peso
                if(atleta[j].peso < atleta[j+1].peso){
                    trocou = true;
                } else if(atleta[j].peso == atleta[j+1].peso){
                    
                    // comparacao por ordem alfabetica
                    if(atleta[j].nome.compareTo(atleta[j+1].nome) > 0){
                        trocou = true;
                    }
                }
                
                // swap
                if(trocou){
                    Atleta tmp = atleta[j];
                    atleta[j] = atleta[j+1];
                    atleta[j+1] = tmp;
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
