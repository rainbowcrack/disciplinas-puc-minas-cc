// esse codigo contem modularizacoes (funcoes atomicas) dos exercicios dos slides de Pilha

/*
 * RETORNE O MAIOR ELEMENTO (ITERATIVO)
 */
int maiorElemento(){
  int maior = topo.elemento; // cria um tmp de comparacao

  for(Celula i = topo; i != null; i = i.prox){
    if(i.elemento > maior){
      maior = i.elemento;
    }
  }
  return maior;
}

 /*
 * RETORNE O MAIOR ELEMENTO (RECURSIVO)
 */
int maiorElemento(Celula i) {
  if (i != null) {
    int maiorResto = maiorElemento(i.prox);
  
    if (i.elemento > maiorResto) {
      return i.elemento;
    } else {
      return maiorResto;
  }
}

int maior(){
  return maiorElemento(topo);
}

 /*
 * RETORNE A SOMA DOS ELEMENTOS (ITERATIVO)
 */
int soma(){
    int resp = 0;

    for(Celula i = topo; i != NULL; i = i.prox){
        resp += i.elemento;
    }
    return resp;
}

/*
 * RETORNE A SOMA DOS ELEMENTOS (RECURSIVO)
 */
int soma(Celula i){
  int resp = 0;

  if(i != NULL){
    resp = i.elemento + soma(i.prox);
  }

  return resp;
}

int somar(){
  return soma(topo);
}