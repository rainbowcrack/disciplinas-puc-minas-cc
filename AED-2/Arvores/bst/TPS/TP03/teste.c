#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define MAX_STRING_SIZE 100
#define MAX_LINE 5000
#define MAX_FIELDS 30
#define MAX_ARRAY_SIZE 30  // atores ou generos
#define MAX_SHOWS_CSV 1368 // maximo de shows lidos do CSV
#define MAX_LISTA_SIZE 200 // maximo de shows na lista alocada

/*****************
* ESTRUTURA DATA *
*****************/
typedef struct {
    char data[MAX_STRING_SIZE];
} DATE;

/*****************
* ESTRUTURA SHOW *
*****************/
typedef struct {
    int SHOW_ID;
    char TYPE[MAX_STRING_SIZE];
    char TITLE[MAX_STRING_SIZE];
    char DIRECTOR[MAX_STRING_SIZE];
    char *CAST[MAX_ARRAY_SIZE];
    int cast_size;
    char COUNTRY[MAX_STRING_SIZE];
    DATE DATA_ADDED;
    int RELEASE_YEAR;
    char RATING[MAX_STRING_SIZE];
    char DURATION[MAX_STRING_SIZE];
    char *LISTED_IN[MAX_ARRAY_SIZE];
    int listed_size;
} SHOW;

// libera memoria alocada (CAST e LISTED_IN)
void free_show_members(SHOW *s) {
    if (s == NULL) return;
    for (int i = 0; i < s->cast_size; i++) {
        free(s->CAST[i]);
        s->CAST[i] = NULL;
    }
    s->cast_size = 0;

    for (int i = 0; i < s->listed_size; i++) {
        free(s->LISTED_IN[i]);
        s->LISTED_IN[i] = NULL;
    }
    s->listed_size = 0;
}

// cria uma copia do SHOW
SHOW clone_show(SHOW original) {
    SHOW nova = original; 

    nova.cast_size = 0; 
    for (int i = 0; i < original.cast_size && i < MAX_ARRAY_SIZE; i++) {
        if (original.CAST[i] != NULL) {
            nova.CAST[nova.cast_size] = strdup(original.CAST[i]);
            if (nova.CAST[nova.cast_size] != NULL) {
                 nova.cast_size++;
            }
        }
    }

    nova.listed_size = 0;
    for (int i = 0; i < original.listed_size && i < MAX_ARRAY_SIZE; i++) {
        if (original.LISTED_IN[i] != NULL) {
            nova.LISTED_IN[nova.listed_size] = strdup(original.LISTED_IN[i]);
             if (nova.LISTED_IN[nova.listed_size] != NULL) { 
                nova.listed_size++;
            }
        }
    }
    return nova;
}

// bubble sort de strings (ordena em geral)
void bubble_sort_strings(char **vetor, int tamanho) {
    for (int i = 0; i < tamanho - 1; i++) {
        for (int j = 0; j < tamanho - 1 - i; j++) {
            if (vetor[j] && vetor[j+1] && strcmp(vetor[j], vetor[j + 1]) > 0) {
                char *tmp = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = tmp;
            }
        }
    }
}

/*********************
* MANIPULAR CSV FILE *
*********************/
int dividirCSV(char *linha, char campos[][MAX_STRING_SIZE]) {
    int i = 0, j = 0, col = 0;
    bool aspas = false;

    // limpar campos antes de usar
    for(int k=0; k<MAX_FIELDS; k++) campos[k][0] = '\0';

    while (linha[i] != '\0' && linha[i] != '\n' && col < MAX_FIELDS) {
        if (linha[i] == '\"') {

            // verificacao de aspas
            if (aspas && linha[i+1] == '\"') {
                 if (j < MAX_STRING_SIZE -1) campos[col][j++] = '\"';
                 i++; 
            } else {
                aspas = !aspas;
            }
        } else if (linha[i] == ',' && !aspas) {
            campos[col][j] = '\0';
            col++;
            if (col < MAX_FIELDS) {
                 j = 0;
            } else {
                return col; 
            }
        } else {
            if (j < MAX_STRING_SIZE - 1) {
                campos[col][j++] = linha[i];
            }
        }
        i++;
    }
    if (col < MAX_FIELDS) {
        campos[col][j] = '\0';
        return col + 1;
    }
    return col;
}

// le o arquivo csv
int lerCSV(const char *nomeArquivo, SHOW vetor[], int max_shows_to_read) {
    FILE *fp = fopen(nomeArquivo, "r");
    if (!fp) {
        perror("Erro ao abrir arquivo");
        return 0;
    }

    char linha[MAX_LINE];
    if (fgets(linha, MAX_LINE, fp) == NULL) { 
        fclose(fp);
        return 0;
    }

    int count = 0;
    while (fgets(linha, MAX_LINE, fp) && count < max_shows_to_read) {
        char campos[MAX_FIELDS][MAX_STRING_SIZE];
        
        linha[strcspn(linha, "\n\r")] = 0; // remove nova linha

        int qtd = dividirCSV(linha, campos);

        if (qtd < 11) continue; 

        SHOW s;
        s.cast_size = 0;
        s.listed_size = 0;
        for(int k=0; k<MAX_ARRAY_SIZE; k++) {
            s.CAST[k] = NULL;
            s.LISTED_IN[k] = NULL;
        }

        if (sscanf(campos[0], "s%d", &s.SHOW_ID) != 1) {
            continue;
        }
        
        strncpy(s.TYPE, strlen(campos[1]) > 0 ? campos[1] : "NaN", MAX_STRING_SIZE - 1);
        s.TYPE[MAX_STRING_SIZE - 1] = '\0';
        strncpy(s.TITLE, strlen(campos[2]) > 0 ? campos[2] : "NaN", MAX_STRING_SIZE - 1);
        s.TITLE[MAX_STRING_SIZE - 1] = '\0';
        strncpy(s.DIRECTOR, strlen(campos[3]) > 0 ? campos[3] : "NaN", MAX_STRING_SIZE - 1);
        s.DIRECTOR[MAX_STRING_SIZE - 1] = '\0';
        strncpy(s.COUNTRY, strlen(campos[5]) > 0 ? campos[5] : "NaN", MAX_STRING_SIZE - 1);
        s.COUNTRY[MAX_STRING_SIZE - 1] = '\0';
        strncpy(s.DATA_ADDED.data, strlen(campos[6]) > 0 ? campos[6] : "NaN", MAX_STRING_SIZE - 1);
        s.DATA_ADDED.data[MAX_STRING_SIZE - 1] = '\0';
        
        s.RELEASE_YEAR = strlen(campos[7]) > 0 ? atoi(campos[7]) : -1;
        if (s.RELEASE_YEAR == 0 && strcmp(campos[7],"0") != 0 && strlen(campos[7]) > 0) { 
             s.RELEASE_YEAR = -1; 
        }

        strncpy(s.RATING, strlen(campos[8]) > 0 ? campos[8] : "NaN", MAX_STRING_SIZE - 1);
        s.RATING[MAX_STRING_SIZE - 1] = '\0';
        strncpy(s.DURATION, strlen(campos[9]) > 0 ? campos[9] : "NaN", MAX_STRING_SIZE - 1);
        s.DURATION[MAX_STRING_SIZE - 1] = '\0';

        char temp_buffer[MAX_LINE]; 

        if (strlen(campos[4]) == 0 || strcmp(campos[4], "NaN") == 0) {
            if (s.cast_size < MAX_ARRAY_SIZE) s.CAST[s.cast_size++] = strdup("NaN");
        } else {
            strncpy(temp_buffer, campos[4], MAX_LINE -1);
            temp_buffer[MAX_LINE-1] = '\0';
            char *token = strtok(temp_buffer, ",");
            while (token && s.cast_size < MAX_ARRAY_SIZE) {
                while (*token == ' ') token++; 
                char* end = token + strlen(token) - 1;
                while(end > token && *end == ' ') end--;
                *(end + 1) = '\0';
                if(strlen(token) > 0) {
                   s.CAST[s.cast_size++] = strdup(token);
                }
                token = strtok(NULL, ",");
            }
             if (s.cast_size == 0 && s.cast_size < MAX_ARRAY_SIZE) { 
                s.CAST[s.cast_size++] = strdup("NaN");
            }
        }

        if (strlen(campos[10]) == 0 || strcmp(campos[10], "NaN") == 0) {
            if (s.listed_size < MAX_ARRAY_SIZE) s.LISTED_IN[s.listed_size++] = strdup("NaN");
        } else {
            strncpy(temp_buffer, campos[10], MAX_LINE -1);
            temp_buffer[MAX_LINE-1] = '\0';
            char *token = strtok(temp_buffer, ",");
            while (token && s.listed_size < MAX_ARRAY_SIZE) {
                while (*token == ' ') token++;
                char* end = token + strlen(token) - 1;
                while(end > token && *end == ' ') end--;
                *(end + 1) = '\0';
                if(strlen(token) > 0) {
                    s.LISTED_IN[s.listed_size++] = strdup(token);
                }
                token = strtok(NULL, ",");
            }
            if (s.listed_size == 0 && s.listed_size < MAX_ARRAY_SIZE) {
                s.LISTED_IN[s.listed_size++] = strdup("NaN");
            }
        }
        vetor[count++] = s; 
    }

    fclose(fp);
    return count;
}

/********************
* IMPRESSAO (print) *
********************/

void print_show(SHOW s) {
    printf("=> s%d", s.SHOW_ID);
    printf(" ## %s", s.TITLE[0] == '\0' ? "NaN" : s.TITLE);
    printf(" ## %s", s.TYPE[0] == '\0' ? "NaN" : s.TYPE);
    printf(" ## %s", s.DIRECTOR[0] == '\0' ? "NaN" : s.DIRECTOR);

    printf(" ## [");

    if (s.cast_size > 0) {
        char **cast_sorted = malloc(s.cast_size * sizeof(char *));
        int current_sorted_size = 0;
        if (cast_sorted) { 
            for (int i = 0; i < s.cast_size; i++) {
                if (s.CAST[i] != NULL) { 
                     cast_sorted[current_sorted_size] = strdup(s.CAST[i]);
                     if(cast_sorted[current_sorted_size] != NULL) current_sorted_size++;
                }
            }

            // ordena as strings nome
            bubble_sort_strings(cast_sorted, current_sorted_size);
            for (int i = 0; i < current_sorted_size; i++) {
                printf("%s%s", cast_sorted[i], (i < current_sorted_size - 1 ? ", " : ""));
                free(cast_sorted[i]);
            }

            // libera memoria
            free(cast_sorted);
        }
    } else {
        printf("NaN");
    }
    printf("]");

    printf(" ## %s", s.COUNTRY[0] == '\0' ? "NaN" : s.COUNTRY);
    printf(" ## %s", s.DATA_ADDED.data[0] == '\0' ? "NaN" : s.DATA_ADDED.data);
    printf(" ## %d", s.RELEASE_YEAR);
    printf(" ## %s", s.RATING[0] == '\0' ? "NaN" : s.RATING);
    printf(" ## %s", s.DURATION[0] == '\0' ? "NaN" : s.DURATION);

    printf(" ## [");
    if (s.listed_size > 0) {
        char **list_sorted = malloc(s.listed_size * sizeof(char *));
        int current_sorted_size = 0;
        if (list_sorted) { 
            for (int i = 0; i < s.listed_size; i++) {
                 if (s.LISTED_IN[i] != NULL) { 
                    list_sorted[current_sorted_size] = strdup(s.LISTED_IN[i]);
                    if(list_sorted[current_sorted_size] != NULL) current_sorted_size++;
                 }
            }
            bubble_sort_strings(list_sorted, current_sorted_size);
            for (int i = 0; i < current_sorted_size; i++) {
                printf("%s%s", list_sorted[i], (i < current_sorted_size - 1 ? ", " : ""));
                free(list_sorted[i]);
            }
            free(list_sorted);
        }
    } else {
        printf("NaN");
    }
    printf("] ##\n");
}

/*************************
* INSERCAO/REMOCAO LISTA *
*************************/

// insere no inicio da lista
// II
void inserirInicio(SHOW lista[], int *tamanho, SHOW s_original) {
    if (*tamanho >= MAX_LISTA_SIZE) {
        fprintf(stderr, "ERROR: Lista cheia, nao pode inserir no inicio.\n");
        return;
    }

    // pega o objeto clonado no novo array
    SHOW s_cloned = clone_show(s_original); 
    for (int i = *tamanho; i > 0; i--) {
        lista[i] = lista[i - 1]; 
    }
    lista[0] = s_cloned; 
    (*tamanho)++;
}

// insere no final da lista
// IF
void inserirFim(SHOW lista[], int *tamanho, SHOW s_original) {
    if (*tamanho >= MAX_LISTA_SIZE) {
        fprintf(stderr, "ERROR: Lista cheia, nao pode inserir no fim.\n");
        return;
    }
    lista[(*tamanho)++] = clone_show(s_original); 
}

// insere na posicao da lista
// I*
void inserirPosicao(SHOW lista[], int *tamanho, int pos, SHOW s_original) {
    if (*tamanho >= MAX_LISTA_SIZE) {
        fprintf(stderr, "ERROR: Lista cheia, nao pode inserir na posicao.\n");
        return;
    }
    if (pos < 0 || pos > *tamanho) { 
        fprintf(stderr, "Erro: Posicao de insercao invalida.\n");
        return;
    }
    SHOW s_cloned = clone_show(s_original); 
    for (int i = *tamanho; i > pos; i--) {
        lista[i] = lista[i - 1];
    }
    lista[pos] = s_cloned;
    (*tamanho)++;
}

// remove no inicio da lista
// RI
void removerInicio(SHOW lista[], int *tamanho) {
    if (*tamanho <= 0) {
        return;
    }

    // retorna o elemento excluido no inicio
    printf("(R) %s\n", lista[0].TITLE);

    // libera espaco na memoria free()
    free_show_members(&lista[0]); 
    for (int i = 0; i < *tamanho - 1; i++) {
        lista[i] = lista[i + 1];
    }
    if(*tamanho > 0) (*tamanho)--; // decrementa o tamanho
    if (*tamanho > 0 && *tamanho < MAX_LISTA_SIZE) { // preenche com o tamanho da lista, memset() preenche
         memset(&lista[*tamanho], 0, sizeof(SHOW)); 
    } else if (*tamanho == 0) { 
         memset(&lista[0], 0, sizeof(SHOW));
    }
}

// remove no fim da lista
// RF
void removerFim(SHOW lista[], int *tamanho) {
    if (*tamanho <= 0) {
        return;
    }

    // retorna o elemento excluido e libera espaco na memoria free()
    printf("(R) %s\n", lista[*tamanho - 1].TITLE);
    free_show_members(&lista[*tamanho - 1]); 

    if(*tamanho > 0) (*tamanho)--;
    if (*tamanho < MAX_LISTA_SIZE) {
         memset(&lista[*tamanho], 0, sizeof(SHOW));
    }
}

// remove na posicao
// R*
void removerPosicao(SHOW lista[], int *tamanho, int pos) {
    if (pos < 0 || pos >= *tamanho || *tamanho <= 0) {
        return;
    }

    // retorna o elemento excluido e libera espaco na memoria free()
    printf("(R) %s\n", lista[pos].TITLE);
    free_show_members(&lista[pos]); 

    for (int i = pos; i < *tamanho - 1; i++) {
        lista[i] = lista[i + 1];
    }
    if(*tamanho > 0) (*tamanho)--;
    if (*tamanho < MAX_LISTA_SIZE && *tamanho >=0) { 
         memset(&lista[*tamanho], 0, sizeof(SHOW));
    }
}

/**************************
* MAPEIA PARA SWITCH CASE *
**************************/
int mapear_comando(const char *comando) {
    if (strcmp(comando, "II") == 0) return 1;
    if (strcmp(comando, "IF") == 0) return 2;
    if (strcmp(comando, "I*") == 0) return 3;
    if (strcmp(comando, "RI") == 0) return 4;
    if (strcmp(comando, "RF") == 0) return 5;
    if (strcmp(comando, "R*") == 0) return 6;
    return 0; 
}

/*****************
* MAIN           *
*****************/
int main() {

    // le o caminho do arquivo
    SHOW shows_csv[MAX_SHOWS_CSV]; 
    int total_csv = lerCSV("/tmp/disneyplus.csv", shows_csv, MAX_SHOWS_CSV);

    // lista alocada
    SHOW lista_manipulada[MAX_LISTA_SIZE]; 
    int tamanho_lista = 0;

    char entrada[MAX_LINE]; 
    char ids_iniciais[MAX_LISTA_SIZE][10]; 
    int qtd_ids_iniciais = 0;

    // primeira leitura com FLAG = "FIM"
    while (qtd_ids_iniciais < MAX_LISTA_SIZE) {
        if (fgets(entrada, sizeof(entrada), stdin) == NULL) break; 
        entrada[strcspn(entrada, "\n\r")] = 0; 
        if (strcmp(entrada, "FIM") == 0) break;
        if (strlen(entrada) < 10) { 
            strcpy(ids_iniciais[qtd_ids_iniciais++], entrada);
        }
    }
    
    // preenche o array com os ID's do input
    for (int i = 0; i < qtd_ids_iniciais; i++) {
        bool encontrado = false;
        for (int j = 0; j < total_csv; j++) {
            char id_formatado_csv[10];
            sprintf(id_formatado_csv, "s%d", shows_csv[j].SHOW_ID);
            if (strcmp(ids_iniciais[i], id_formatado_csv) == 0) {
                if (tamanho_lista < MAX_LISTA_SIZE) {
                    lista_manipulada[tamanho_lista++] = clone_show(shows_csv[j]);
                }
                encontrado = true;
                break;
            }
        }
    }

    int num_comandos = 0;
    
    char buffer_clear[10]; // para consumir o \n
    fgets(buffer_clear, sizeof(buffer_clear), stdin);


    for (int k = 0; k < num_comandos; k++) {
        if (fgets(entrada, sizeof(entrada), stdin) == NULL) {
            break; 
        }
        entrada[strcspn(entrada, "\n\r")] = 0;

        char comando_str[5];
        char id_arg[10];
        int pos_arg;

        if (sscanf(entrada, "%4s", comando_str) != 1) { 
            continue;
        }
        
        // mapeia o switch-case
        int comando_val = mapear_comando(comando_str);
        SHOW show_para_inserir; 
        bool buscar_show_para_inserir = (comando_val >= 1 && comando_val <= 3);
        bool show_encontrado_para_inserir = false;

        if (buscar_show_para_inserir) {
            if (comando_val == 3) { 
                if (sscanf(entrada, "%*s %d %9s", &pos_arg, id_arg) != 2) {
                     continue;
                }
            } else { 
                 if (sscanf(entrada, "%*s %9s", id_arg) != 1) {
                     continue;
                 }
            }
            for (int j = 0; j < total_csv; j++) {
                char id_formatado_csv[10];
                sprintf(id_formatado_csv, "s%d", shows_csv[j].SHOW_ID);
                if (strcmp(id_arg, id_formatado_csv) == 0) {
                    show_para_inserir = shows_csv[j]; 
                    show_encontrado_para_inserir = true;
                    break;
                }
            }
            if (!show_encontrado_para_inserir) {
                continue; 
            }
        }

        // switch-case para remocao/insercao na lista
        switch (comando_val) {
            case 1: 
                if(show_encontrado_para_inserir) inserirInicio(lista_manipulada, &tamanho_lista, show_para_inserir);
                break;
            case 2: 
                if(show_encontrado_para_inserir) inserirFim(lista_manipulada, &tamanho_lista, show_para_inserir);
                break;
            case 3: 
                if(show_encontrado_para_inserir) inserirPosicao(lista_manipulada, &tamanho_lista, pos_arg, show_para_inserir);
                break;
            case 4: 
                removerInicio(lista_manipulada, &tamanho_lista);
                break;
            case 5: 
                removerFim(lista_manipulada, &tamanho_lista);
                break;
            case 6: { 
                if (sscanf(entrada, "%*s %d", &pos_arg) != 1) {
                    continue;
                }
                removerPosicao(lista_manipulada, &tamanho_lista, pos_arg);
                break;
            }
            default:
                break; 
        }
    }

    // imprime a lista
    for (int i = 0; i < tamanho_lista; i++) {
        print_show(lista_manipulada[i]);
    }

    // libera espacos na memoria
    for (int i = 0; i < tamanho_lista; i++) {
        free_show_members(&lista_manipulada[i]);
    }

    for (int i = 0; i < total_csv; i++) {
        free_show_members(&shows_csv[i]);
    }

    return 0;
}