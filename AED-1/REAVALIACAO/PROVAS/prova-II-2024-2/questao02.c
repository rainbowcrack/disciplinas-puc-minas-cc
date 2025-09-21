# define MAX 100
int TAM;

typedef struct{
  char nome[50];
  float salario;
}Funcionario;

// --------------------------------------------------------------------------------------------------
// ITERATIVO

int contarFuncionarios(Funcionario funcionarios[], float lim_superior, float lim_inferior){
  int count = 0;
  for(int i = 0; i < TAM; i++){
    if(lim_inferior <= funcionarios[i].salario && funcionarios[i].salario <= lim_superior){
      count++;
    }
  }

  return count;  
}
  
// -------------------------------------------------------------------------------------------------
// RECURSIVO

int contarFuncionariosRec(Funcionario funcionarios[], float lim_superior, float lim_inferior, int i){
  int count = 0;
  
  if (i < 0) {  
        return 0;
    }
  
  if(lim_inferior <= funcionarios[i].salario && funcionarios[i].salario <= lim_superior){
    count = 1 + contarFuncionariosRec(funcionarios, lim_superior, lim_inferior, i-1);
  } else {
    count = contarFuncionariosRec(funcionarios, lim_superior, lim_inferior, i-1);  
  }

  return count;
}
