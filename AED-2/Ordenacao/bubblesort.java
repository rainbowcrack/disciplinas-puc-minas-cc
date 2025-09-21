import java.util.Scanner;
public class Main{
    
    public static void bubblesort(int array[], int tam){
        int temp; 
        
        for(int i = 0; i < tam-1; i++){
            for(int j = 0; j < tam -1 -i; j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    public static void imprime(int array[], int tam){
        for(int i = 0; i < tam; i++){
            System.out.print(array[i] + " ");
        }
    }
    
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        
        int tam = teclado.nextInt();
        int[] array = new int[tam];
        
        for(int i = 0; i < tam; i++){
            array[i] = teclado.nextInt();
        }
        
        System.out.println("Antes: ");
        imprime(array, tam);
        bubblesort(array, tam);
        System.out.println("\nDepois: ");
        imprime(array, tam);
        
    }
}
