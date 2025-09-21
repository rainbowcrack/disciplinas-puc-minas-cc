/********************
* Bibliotecas e MAX *
********************/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define MAX_SHOWS 1368
#define MAX_LINE 1000
#define MAX_FIELDS 20
#define MAX_ARRAY_SIZE 100
#define MAX_STRING_SIZE 200

/**************
* Classe DATE *
**************/
typedef struct {
    char data[MAX_STRING_SIZE];
} DATE;

/**************
* Classe SHOW *
**************/
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

// Compara duas strings por ASCII, por diferenca
int comparar_ascii(const char *a, const char *b) {
    int i = 0;
    while (a[i] != '\0' && b[i] != '\0') {
        if (a[i] != b[i]) {
            return a[i] - b[i];
        }
        i++;
    }
    return a[i] - b[i];
}

// Ordena vetor de strings com Bubble Sort
void bubble_sort_ascii(char **vetor, int tamanho) {
    for (int i = 0; i < tamanho - 1; i++) {
        for (int j = 0; j < tamanho - 1 - i; j++) {
            if (comparar_ascii(vetor[j], vetor[j + 1]) > 0) {
                char *tmp = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = tmp;
            }
        }
    }
}

// Divide linha CSV respeitando aspas, usando uma matriz
int dividirCSV(char *linha, char campos[][MAX_STRING_SIZE]) {
    int i = 0, j = 0, col = 0;
    bool aspas = false;

    while (linha[i] != '\0' && linha[i] != '\n') {
        if (linha[i] == '\"') {
            aspas = !aspas;
        } else if (linha[i] == ',' && !aspas) {
            campos[col][j] = '\0';
            col++;
            j = 0;
        } else {
            campos[col][j++] = linha[i];
        }
        i++;
    }
    campos[col][j] = '\0';
    return col + 1;
}

// Le arquivo CSV
int lerCSV(const char *nomeArquivo, SHOW vetor[]) {
    FILE *fp = fopen(nomeArquivo, "r");
    if (!fp) {
        printf("Erro ao abrir arquivo.\n");
        return 0;
    }

    char linha[MAX_LINE];
    fgets(linha, MAX_LINE, fp); 

    int count = 0;
    while (fgets(linha, MAX_LINE, fp) && count < MAX_SHOWS) {
        char campos[MAX_FIELDS][MAX_STRING_SIZE];
        int qtd = dividirCSV(linha, campos);

        if (qtd < 11) continue;

        SHOW s;
        if (sscanf(campos[0], "s%d", &s.SHOW_ID) != 1) continue;

        // condicao de campo vazio = "NaN"
        strcpy(s.TYPE, strlen(campos[1]) > 0 ? campos[1] : "NaN");
        strcpy(s.TITLE, strlen(campos[2]) > 0 ? campos[2] : "NaN");
        strcpy(s.DIRECTOR, strlen(campos[3]) > 0 ? campos[3] : "NaN");
        strcpy(s.COUNTRY, strlen(campos[5]) > 0 ? campos[5] : "NaN");
        strcpy(s.DATA_ADDED.data, strlen(campos[6]) > 0 ? campos[6] : "NaN");
        s.RELEASE_YEAR = strlen(campos[7]) > 0 ? atoi(campos[7]) : -1;
        strcpy(s.RATING, strlen(campos[8]) > 0 ? campos[8] : "NaN");
        strcpy(s.DURATION, strlen(campos[9]) > 0 ? campos[9] : "NaN");

        // CAST, formatacao
        s.cast_size = 0;
        if (strlen(campos[4]) == 0) {

            // duplica a string
            s.CAST[0] = strdup("NaN");
            s.cast_size = 1;
        } else {
            char *token = strtok(campos[4], ",");
            while (token && s.cast_size < MAX_ARRAY_SIZE) {
                while (*token == ' ') token++;
                s.CAST[s.cast_size++] = strdup(token);
                token = strtok(NULL, ",");
            }
        }

        // LISTED_IN
        s.listed_size = 0;
        if (strlen(campos[10]) == 0) {
            s.LISTED_IN[0] = strdup("NaN");
            s.listed_size = 1;
        } else {
            
            // delimita
            char *token = strtok(campos[10], ",");
            while (token && s.listed_size < MAX_ARRAY_SIZE) {
                while (*token == ' ') token++;
                s.LISTED_IN[s.listed_size++] = strdup(token);
                token = strtok(NULL, ",");
            }
        }

        vetor[count++] = s;
    }

    fclose(fp);
    return count;
}

/**************************
* Classe IMPRIMIR (print) *
**************************/
void print_show(SHOW s) {
    printf("=> s%d", s.SHOW_ID);
    printf(" ## %s", s.TITLE);
    printf(" ## %s", s.TYPE);
    printf(" ## %s", s.DIRECTOR);

    // Ordena e imprime elenco por ordem alfabetica usando bubble-sort em ascii
    char **cast_sorted = malloc(s.cast_size * sizeof(char *));
    for (int i = 0; i < s.cast_size; i++) {
        cast_sorted[i] = strdup(s.CAST[i]);
    }
    bubble_sort_ascii(cast_sorted, s.cast_size);
    printf(" ## [");
    for (int i = 0; i < s.cast_size; i++) {
        printf("%s%s", cast_sorted[i], (i < s.cast_size - 1 ? ", " : ""));
        free(cast_sorted[i]);
    }
    printf("]");
    free(cast_sorted);

    printf(" ## %s", s.COUNTRY);
    printf(" ## %s", s.DATA_ADDED.data);
    printf(" ## %d", s.RELEASE_YEAR);
    printf(" ## %s", s.RATING);
    printf(" ## %s", s.DURATION);

    // Ordena e imprime categorias
    char **list_sorted = malloc(s.listed_size * sizeof(char *));
    for (int i = 0; i < s.listed_size; i++) {
        list_sorted[i] = strdup(s.LISTED_IN[i]);
    }
    bubble_sort_ascii(list_sorted, s.listed_size);
    printf(" ## [");
    for (int i = 0; i < s.listed_size; i++) {
        printf("%s%s", list_sorted[i], (i < s.listed_size - 1 ? ", " : ""));
        free(list_sorted[i]);
    }
    printf("] ##\n");
    free(list_sorted);
}

/**************
* Classe MAIN *
**************/
int main() {
    // cria um array de objetor
    SHOW shows[MAX_SHOWS];

    // le o arquivo CSV e faz a leitura
    int total = lerCSV("/tmp/disneyplus.csv", shows);

    char entrada[20];
    fgets(entrada, sizeof(entrada), stdin);
    entrada[strcspn(entrada, "\n")] = 0;

    while (strcmp(entrada, "FIM") != 0) {
        for (int i = 0; i < total; i++) {
            char id_formatado[10];

            // condicao de saida formatada, verificacao
            sprintf(id_formatado, "s%d", shows[i].SHOW_ID);
            if (strcmp(entrada, id_formatado) == 0) {
                print_show(shows[i]);
                break;
            }
        }

        fgets(entrada, sizeof(entrada), stdin);
        entrada[strcspn(entrada, "\n")] = 0;
    }

    return 0;
}
