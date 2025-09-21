void contarVogais(char str[], int qt[]){
  for(int i = 0; i < 5; i++){
    qt[i] = 0;
  }

  char letra;
  char vogais = {'a','e','i','o','u'};
  int i = 0;

  while(str[i] != '\0'){
    letra = toupper(str[i]);
    for(int j=0; j <5; j++){
      if(letra == vogais[j]{
        qt[j]++;
      }
    }
  i++
  }


}
