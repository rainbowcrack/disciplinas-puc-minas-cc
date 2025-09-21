typedef struct{
  char nome[50];
  int ano;
}Livro;

// --------------------------------------------------------------------------------
// ITERATIVA

void leituraArquivo(char *nomeArquivo, Livro livros[]){
  FILE * arquivo = fopen(nomeArquivo, "rb");
  
  if(arquivo == NULL) printf("Error!");

  fread(livros, sizeof(Livro), TAM, arquivo);
  
  fclose(arquivo);
}

void listagemLivros(Livro livros[], int chaveAno){
  for(int i=0; i < TAM; i++){
    if(livros[i].ano == chaveAno){
      printf("%s\n", livros[i].nome);
    }
  }
}
// ---------------------------------------------------------------------------------
// RECURSIVA

void listagemLivrosRec(Livro livros[], int chaveAno, int i){
  if(i >= 0){
    if(livros[i].ano == chaveAno){
      printf("%s\n", livros[i].nome);
    }
    listagemLivrosRec(livros, chaveAno, i-1);
  }
}
