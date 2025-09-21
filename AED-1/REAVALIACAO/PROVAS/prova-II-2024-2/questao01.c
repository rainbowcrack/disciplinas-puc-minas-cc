float calculeMinmax(float M[][MAX_COL]){
  float menor = M[0][0];
  int linha;

  for(int i=0; i<MAX_LIN; i++){
    for(int j=0; j<MAX_COL; j++){
      if(M[i][j] < menor){
        menor = M[i][j];
        linha = i;
      }
    }
  }

  float minmax = M[linha][0];

  for(int k=0; k<MAX_COL; k++){
    if(M[linha][k] > minmax){
      minmax = M[linha][k];
    }
  }

  return minmax;
}
