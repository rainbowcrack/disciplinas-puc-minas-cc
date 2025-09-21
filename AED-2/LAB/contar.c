# include <stdlib.h>
#include <stdio.h>
#include <string.h>
 
 // criar um TAM para saber qual a str maior
 // juntar as duas em um vetor 
 // fazer um swap, casas impares para str2
  int main(){
        
        int const tam = 100;
  
         char str1[tam], str2[tam];
         
         scanf("%s %s", str1, str2);
         
         int tam1 = strlen(str1);
         int tam2 = strlen(str2);
         int min_len = tam1 < tam2 ? tam1 : tam2; 
         // strcat(str1, str2);
        
        // caso 1: str2 > str1
        
        for(int i = 1; i < min_len; i += 2){
             
            char temp = str1[i];
            str1[i] = str2[i];
            str2[i] = temp;
                
        }
        
        // caso 2: str1 > str2   
        } else if(tam1 > tam2){
        
        // caso 3: str1 == str2
        } else{
            
            for (int i = 0; i < tam1; i++) {
                if (i % 2 != 0) {  // Se o índice for ímpar
                    char temp = str1[i];
                    str1[i] = str2[i];
                    str2[i] = temp;
                }
            }
            printf("%s", str1);
            
        }
 
        return 0;
 }
