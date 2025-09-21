// ITERATIVO 

void excluirCirculo(Circulo *circulos[], int &k, int quantidade){

  if(k >= 0 && k < quantidade){
    delete vetor[k];
    quantidade--;
  }

  for(int i = k; i < quantidade-1; i++){
    circulos[i] = circulos[i+1] // shift-1
  } 
}

// --------------------------------------------------------------------------
// RECURSIVO

void excluirCirculoRec(Circulo *circulos[], int &k, int quantidade){
  if(k >= 0 && K < quantidade-1){
    delete vetor[k];
    quantidade--;
  } 

  if(k < quantidade-1){
    circulos[i] = circulos[i+1];
    excluirCirculoRec(circulos, k+1, quantidade-1);
  }
}
