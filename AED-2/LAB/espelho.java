  1 import java.util.Scanner;
  2 
  3 public class espelho{
  4 
  5         public static void main(String[] args){
  6 
  7                 Scanner teclado = new Scanner(System.in);
  8 
  9                 int num1 = teclado.nextInt();
 10                 int num2 = teclado.nextInt();
 11 
 12                 int tam = (num2 - num1) + 1;
 13                 int array[] = new int[tam];
 14 
 15                 for(int i = 0; i < tam; i++){
 16                         array[i] = num1 + i;
 17                 }
 18 
 19                 for(int i = 0
 20 
 21                 for(int i = 0; i < tam; i++){
 22                  
 23                         System.out.print(array[i]);
 24                 }
 25                 teclado.close();
 26         }
 27 }
