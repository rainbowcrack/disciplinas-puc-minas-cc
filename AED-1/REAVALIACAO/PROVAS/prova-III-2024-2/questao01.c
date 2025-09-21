// ----------------------------------------------------------------------
// ITERATIVO

int ehEquilateros(Triangulo *triangulos[], int tamanho){
  int count = 0;
  
  for(int i=0; i < tamanho; i++){
    if(triangulos[i]->equilatero()){
      count++;
    }
  }
  return count;
}

bool Triangulo::equilatero(){
  return A == B && B == C;
}

// ------------------------------------------------------------------------
// RECURSIVO

int ehEquilaterosRec(Triangulo *triangulos[], int tamanho){
  int count = 0;
  if(N > 0){
    if(triangulos[i]->equilatero()){
      count = 1 + ehEquilaterosRec(triangulos, tamanho-1);
    } else {
      count = ehEquilateros(triangulos, tamanho-1);
    }
  }
}

bool Triangulo::equilatero(){
  return A==B && B==C;
}
