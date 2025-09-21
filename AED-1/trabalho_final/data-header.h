#ifndef DATA_H_INCLUDED
#define DATA_H_INCLUDED

typedef struct{
    int dia;
    int mes;
    int ano;
}Data;

int diasMes(Data data){
    int dias[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    return dias[data.mes-1];
}

char *mesExtenso(Data data){
    char* mes[]={"janeiro","fevereiro", "marco", "abril", "maio", "junho",
    "julho", "agosto", "setembro", "outubro", "novemebro", "dezembro"};

    return mes[data.mes-1];
}

void escreveData(Data data){
    printf("\n%d/%d/%d",
           data.dia,
           data.mes,
           data.ano);
}

void leiaData(Data* data){
    printf("\ndd/mm/aaaa: ");
    scanf("%d/%d/%d",
          &data->dia,
          &data->mes,
          &data->ano);
}

#endif // DATA_H_INCLUDED
