bool linhaIgualColuna(float M[][MAX_LIN], int x){
  bool ehIgual = false;
  
  for(int i=0; i < MAX_LIN < i++){
    if(M[x][i] == M[i][x]){
      ehIgual = true;
    }
  }

  return ehIgual;  
}


bool linhaIgualColunaRec(float M[][MAX_LIN], int x, int i){
  bool ehIgual = false;
  int i = 0;
  
  if(i >= 0){
    if(M[x][i] == M[i][x]){
      ehIgual = true;
    }
    linhaIgualColunaRec(M, x, i-1);   
  }
  return ehIgual;  
}
