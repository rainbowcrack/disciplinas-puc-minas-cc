int mesmaCor(Quadrado quadrados[][NUM_COL], string cor){
  
  int count = 0;

  for(int i=0; i < NUM_LIN; i++){
    for(int j=0; j < NUM_COL; j++){
      
      if(quadrados[i][j].getCor() == cor){
        count++;
      } // fim do if
    }
  }
  return count;
}
