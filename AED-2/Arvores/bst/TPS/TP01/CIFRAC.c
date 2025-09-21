int main()
{
    // chave do usuario
    int k;
    scanf("%d", &k);
    
    // ler frase
    char frase[20];
    scanf(" %s", frase);
    
    for(int i = 0; i < strlen(frase); i++){
        frase[i] = frase[i]+ k;
        printf("%c", frase[i]);
    }
    
    return 0;
}
