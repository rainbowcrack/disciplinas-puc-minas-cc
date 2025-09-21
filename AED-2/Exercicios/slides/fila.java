// esse codigo contem modularizacoes (funcoes atomicas) dos exercicios dos slides de Pilha

/*
 * FUNCAO MOSTRAR
 */
void mostrar(){
    System.out.print("[");

    for(Celula i = primeiro.prox; i != null; i = i.prox){ // ultimo ja sera null
        System.out.print(i.elemento + " ");
    }

    System.out.print("]");
}

/*
 * FUNCAO MAIOR ELEMENTO (ITERATIVO)
 */
int maiorElemento(){
    int maior = primeiro.prox.elemento;

    for(Celula i = primeiro.prox; i != null; i = i.prox){
        if(maior < i.elemento){
            maior = i.elemento;
        }
    }
    return maior;
}

/*
 * FUNCAO MAIOR ELEMENTO (RECURSIVO)
 */
int maiorReq(Celula i){

    if(i != null){
        int maiorElemento = maiorReq(i.prox);

        if(i.elemento > maiorElemento){
            return i.elemento;
        } else{
            return maiorElemento;
        }
    }
}

int maiorReqIndireito(){
    return maiorReq(primeiro.prox);
}
/*
 * RETORNA O TERCEIRO ELEMENTO
 */
int terceiroElemento(){
    return primeiro.prox.prox.prox.elemento;
}

/*
 * RETORNA A SOMA DE ELEMENTOS
 */
int somaElementos(){
    int resp = 0;

    for(Celula i = primeiro.prox; i != null; i = i.prox){
        resp += i.elemento;
    }
    return resp;
}

/*
 * CONTA AS DIVISOES POR 5 E POR 2
 */
int contar(){
    int count = 0;

    for(Celula i = primeiro.prox; i != null; i = i.prox){
        if(i.elemento % 10 == 0){
            count++;
        }
    }

    return count;
}