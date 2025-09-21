/********************
* Bibliotecas e MAX *
********************/
/*
/\_/\
( o.o) ......><)))º>.....
  >^<
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>
#include <ctype.h> // Para isspace

#define MAX_SHOWS 1368
#define MAX_LINE 2048 // Aumentado para segurança com campos longos
#define MAX_FIELDS 20
#define MAX_ARRAY_SIZE 100
#define MAX_STRING_SIZE 250 // Aumentado ligeiramente para segurança

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
    char **CAST; // Agora ponteiro para ponteiro
    int cast_size;
    char COUNTRY[MAX_STRING_SIZE];
    DATE DATA_ADDED;
    int RELEASE_YEAR;
    char RATING[MAX_STRING_SIZE];
    char DURATION[MAX_STRING_SIZE];
    char **LISTED_IN; // Agora ponteiro para ponteiro
    int listed_size;
} SHOW;

// Função para liberar a memória alocada dinamicamente em um SHOW
void free_show(SHOW *s) {
    if (s->CAST) {
        for (int i = 0; i < s->cast_size; i++) {
            free(s->CAST[i]); // Libera cada string duplicada
        }
        free(s->CAST); // Libera o array de ponteiros
        s->CAST = NULL; // Boa prática: zerar ponteiro após free
    }
    s->cast_size = 0;

    if (s->LISTED_IN) {
        for (int i = 0; i < s->listed_size; i++) {
            free(s->LISTED_IN[i]); // Libera cada string duplicada
        }
        free(s->LISTED_IN); // Libera o array de ponteiros
        s->LISTED_IN = NULL; // Boa prática
    }
    s->listed_size = 0;
}


// Compara duas strings por ASCII
int comparar_ascii(const void *a, const void *b) {
    // Adaptado para qsort (embora estejamos usando bubble sort)
    // Para bubble sort, o original está ok, mas esta forma é útil
    const char *str_a = *(const char **)a;
    const char *str_b = *(const char **)b;
    return strcmp(str_a, str_b);
}

// Ordena vetor de strings com Bubble Sort
void bubble_sort_ascii(char **vetor, int tamanho) {
    if (!vetor || tamanho <= 1) return; // Verifica se o vetor é válido
    for (int i = 0; i < tamanho - 1; i++) {
        for (int j = 0; j < tamanho - 1 - i; j++) {
            // Verifica se os ponteiros são válidos antes de comparar
            if (vetor[j] && vetor[j + 1] && strcmp(vetor[j], vetor[j + 1]) > 0) {
                char *tmp = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = tmp;
            }
        }
    }
}

// Função auxiliar para remover espaços em branco no início da string
char* trim_start(char *str) {
    while (isspace((unsigned char)*str)) {
        str++;
    }
    return str;
}


// Divide linha CSV respeitando aspas, usando matriz
int dividirCSV(char *linha, char campos[][MAX_STRING_SIZE]) {
    int i = 0, j = 0, col = 0;
    bool aspas = false;
    int len = strlen(linha);

    // Zera os campos para evitar lixo
    for(int c = 0; c < MAX_FIELDS; ++c) {
        campos[c][0] = '\0';
    }

    while (i < len && col < MAX_FIELDS) {
        if (linha[i] == '\"') {
            aspas = !aspas;
            // Não incluir a aspa no campo
        } else if (linha[i] == ',' && !aspas) {
            campos[col][j] = '\0'; // Termina o campo atual
            col++;
            if (col >= MAX_FIELDS) break; // Evita overflow de colunas
            j = 0; // Reinicia índice do caractere para o próximo campo
        } else {
            // Adiciona caractere se houver espaço no buffer do campo
            if (j < MAX_STRING_SIZE - 1) {
                campos[col][j++] = linha[i];
            }
            // Se não houver espaço, o caractere é ignorado (truncamento)
        }
        i++;
    }
    // Termina o último campo (ou o campo atual se MAX_FIELDS foi atingido)
    if (col < MAX_FIELDS) {
         campos[col][j] = '\0';
         return col + 1; // Retorna número de campos preenchidos
    }
    return MAX_FIELDS; // Retorna o máximo se estourou
}


// Le arquivo CSV
int lerCSV(const char *nomeArquivo, SHOW vetor[], int max_shows) {
    FILE *fp = fopen(nomeArquivo, "r");
    if (!fp) {
        perror("Erro ao abrir arquivo"); // Usar perror para mais detalhes
        return 0;
    }

    char linha[MAX_LINE];
    // Pula cabeçalho
    if(fgets(linha, MAX_LINE, fp) == NULL) {
        fclose(fp);
        return 0; // Arquivo vazio ou erro de leitura
    }

    int count = 0;
    while (fgets(linha, MAX_LINE, fp) && count < max_shows) {
        // Remove newline no final da linha, se existir
        linha[strcspn(linha, "\r\n")] = 0;

        char campos[MAX_FIELDS][MAX_STRING_SIZE];
        int qtd = dividirCSV(linha, campos);

        // Verifica se tem o número mínimo esperado de campos (ajuste conforme necessidade)
        // O código original esperava 11 (índices 0 a 10)
        if (qtd < 11) {
             //fprintf(stderr, "Aviso: Linha ignorada (campos insuficientes): %s\n", linha);
             continue;
        }

        // Inicializa ponteiros para evitar problemas em free_show caso algo falhe
        SHOW s = {0}; // Inicializa toda a struct com zeros/NULLs
        s.RELEASE_YEAR = -1; // Valor padrão caso atoi falhe

        if (sscanf(campos[0], "s%d", &s.SHOW_ID) != 1) {
             //fprintf(stderr, "Aviso: ID inválido na linha: %s\n", linha);
             continue; // Pula linha se ID não puder ser lido
        }

        // Copia os campos fixos, verificando o tamanho (embora MAX_STRING_SIZE deva ser suficiente)
        strncpy(s.TYPE, strlen(campos[1]) > 0 ? campos[1] : "NaN", MAX_STRING_SIZE - 1); s.TYPE[MAX_STRING_SIZE - 1] = '\0';
        strncpy(s.TITLE, strlen(campos[2]) > 0 ? campos[2] : "NaN", MAX_STRING_SIZE - 1); s.TITLE[MAX_STRING_SIZE - 1] = '\0';
        strncpy(s.DIRECTOR, strlen(campos[3]) > 0 ? campos[3] : "NaN", MAX_STRING_SIZE - 1); s.DIRECTOR[MAX_STRING_SIZE - 1] = '\0';
        strncpy(s.COUNTRY, strlen(campos[5]) > 0 ? campos[5] : "NaN", MAX_STRING_SIZE - 1); s.COUNTRY[MAX_STRING_SIZE - 1] = '\0';
        strncpy(s.DATA_ADDED.data, strlen(campos[6]) > 0 ? campos[6] : "NaN", MAX_STRING_SIZE - 1); s.DATA_ADDED.data[MAX_STRING_SIZE - 1] = '\0';
        if (strlen(campos[7]) > 0) s.RELEASE_YEAR = atoi(campos[7]);
        strncpy(s.RATING, strlen(campos[8]) > 0 ? campos[8] : "NaN", MAX_STRING_SIZE - 1); s.RATING[MAX_STRING_SIZE - 1] = '\0';
        strncpy(s.DURATION, strlen(campos[9]) > 0 ? campos[9] : "NaN", MAX_STRING_SIZE - 1); s.DURATION[MAX_STRING_SIZE - 1] = '\0';

        // Processar CAST (campo 4)
        s.cast_size = 0;
        s.CAST = NULL;
        if (strlen(campos[4]) == 0) {
            s.CAST = malloc(sizeof(char *)); // Aloca espaço para 1 ponteiro
            if (s.CAST) {
                s.CAST[0] = strdup("NaN");
                if (s.CAST[0]) {
                    s.cast_size = 1;
                } else {
                    free(s.CAST); s.CAST = NULL; // Falha no strdup
                    fprintf(stderr, "Erro: Falha ao alocar memória para CAST 'NaN'.\n");
                    // Decide se quer continuar ou abortar
                }
            } else {
                 fprintf(stderr, "Erro: Falha ao alocar memória para array CAST (1 elemento).\n");
            }
        } else {
            // Primeiro conta quantos tokens existem para alocar o tamanho exato
            int num_tokens = 0;
            char *temp_copy = strdup(campos[4]); // strtok modifica a string, usa cópia
            if (!temp_copy) { fprintf(stderr, "Erro: Falha ao duplicar string CAST para contagem.\n"); continue; }
            char *token_count = strtok(temp_copy, ",");
            while (token_count) {
                num_tokens++;
                token_count = strtok(NULL, ",");
            }
            free(temp_copy);

            if (num_tokens > 0) {
                s.CAST = malloc(num_tokens * sizeof(char *));
                //a array CAST (%d elementos).\n"); continue; }

                char *token = strtok(campos[4], ","); // Usa a string original agora
                while (token && s.cast_size < num_tokens) {
                    token = trim_start(token); // Remove espaços iniciais
                    // Remove espaços finais (mais complexo, opcional)
                    s.CAST[s.cast_size] = strdup(token);
                    if (!s.CAST[s.cast_size]) {
                        fprintf(stderr, "Erro: Falha ao duplicar token CAST '%s'. Liberando alocados.\n", token);
                        free_show(&s); // Libera o que foi alocado até agora para este show
                        goto next_line; // Pula para a próxima linha do CSV
                    }
                    s.cast_size++;
                    token = strtok(NULL, ",");
                }
            } else { // String não vazia mas sem tokens? (Ex: ",")
                 s.CAST = malloc(sizeof(char *));
                 if (s.CAST) {
                    s.CAST[0] = strdup("NaN");
                    if (s.CAST[0]) s.cast_size = 1; else { free(s.CAST); s.CAST = NULL; }
                 }
            }
        }

        // Processar LISTED_IN (campo 10) - Lógica similar ao CAST
        s.listed_size = 0;
        s.LISTED_IN = NULL;
         if (strlen(campos[10]) == 0) {
            s.LISTED_IN = malloc(sizeof(char *));
            if (s.LISTED_IN) {
                s.LISTED_IN[0] = strdup("NaN");
                 if (s.LISTED_IN[0]) s.listed_size = 1; else { free(s.LISTED_IN); s.LISTED_IN = NULL; }
            }
         } else {
            int num_tokens = 0;
            char *temp_copy = strdup(campos[10]);
             if (!temp_copy) { fprintf(stderr, "Erro: Falha ao duplicar string LISTED_IN para contagem.\n"); free_show(&s); goto next_line; }
            char *token_count = strtok(temp_copy, ",");
            while (token_count) { num_tokens++; token_count = strtok(NULL, ","); }
            free(temp_copy);

            if (num_tokens > 0) {
                s.LISTED_IN = malloc(num_tokens * sizeof(char *));
                 if (!s.LISTED_IN) { fprintf(stderr, "Erro: Falha ao alocar memória para array LISTED_IN.\n"); free_show(&s); goto next_line; }

                char *token = strtok(campos[10], ",");
                while (token && s.listed_size < num_tokens) {
                    token = trim_start(token);
                    s.LISTED_IN[s.listed_size] = strdup(token);
                    if (!s.LISTED_IN[s.listed_size]) {
                        fprintf(stderr, "Erro: Falha ao duplicar token LISTED_IN. Liberando alocados.\n");
                        free_show(&s);
                        goto next_line;
                    }
                    s.listed_size++;
                    token = strtok(NULL, ",");
                }
            } else {
                s.LISTED_IN = malloc(sizeof(char *));
                if (s.LISTED_IN) {
                    s.LISTED_IN[0] = strdup("NaN");
                    if (s.LISTED_IN[0]) s.listed_size = 1; else { free(s.LISTED_IN); s.LISTED_IN = NULL;}
                }
            }
        }

        vetor[count++] = s; // Copia a struct (shallow copy dos ponteiros CAST/LISTED_IN)

    next_line:; // Label para pular para a próxima linha em caso de erro de alocação
    } // end while fgets

    fclose(fp);
    return count;
}


// Impressao do objeto SHOW
void print_show(const SHOW *s) { // Receber ponteiro constante é mais eficiente
    if (!s) return;

    printf("=> s%d ## %s ## %s ## %s ## [", s->SHOW_ID, s->TITLE, s->TYPE, s->DIRECTOR);

    // Ordenar e imprimir CAST
    if (s->CAST && s->cast_size > 0) {
        // Alocar memória para cópias dos ponteiros para ordenar
        char **cast_sorted = malloc(s->cast_size * sizeof(char *)); // CORRIGIDO sizeof
        if (cast_sorted) {
            for (int i = 0; i < s->cast_size; i++) {
                cast_sorted[i] = s->CAST[i]; // Apenas copia ponteiros para ordenar
            }
            // Usar qsort que é mais eficiente que bubble sort para arrays maiores
            qsort(cast_sorted, s->cast_size, sizeof(char *), comparar_ascii);

            for (int i = 0; i < s->cast_size; i++) {
                printf("%s%s", cast_sorted[i] ? cast_sorted[i] : "NULL_PTR", (i < s->cast_size - 1 ? ", " : ""));
            }
            free(cast_sorted); // Libera o array de ponteiros copiados
        } else {
            printf("Erro ao alocar memoria para ordenar CAST");
        }
    } else {
        printf("NaN"); // Se não houver cast
    }
    printf("] ## %s ## %s ## %d ## %s ## %s ## [", s->COUNTRY, s->DATA_ADDED.data, s->RELEASE_YEAR, s->RATING, s->DURATION);

    // Ordenar e imprimir LISTED_IN
    if (s->LISTED_IN && s->listed_size > 0) {
        char **list_sorted = malloc(s->listed_size * sizeof(char *)); // CORRIGIDO sizeof
         if (list_sorted) {
            for (int i = 0; i < s->listed_size; i++) {
                 list_sorted[i] = s->LISTED_IN[i];
            }
            qsort(list_sorted, s->listed_size, sizeof(char *), comparar_ascii);

            for (int i = 0; i < s->listed_size; i++) {
                printf("%s%s", list_sorted[i] ? list_sorted[i] : "NULL_PTR", (i < s->listed_size - 1 ? ", " : ""));
            }
            free(list_sorted);
        } else {
             printf("Erro ao alocar memoria para ordenar LISTED_IN");
        }
    } else {
        printf("NaN");
    }
    printf("] ##\n");
}


// Verifica se o primeiro caractere eh um digito
bool comeca_com_digito(const char *str) {
    if (!str || str[0] == '\0') return false; // Trata string nula ou vazia
    return str[0] >= '0' && str[0] <= '9';
}

// Comparacao correta: primeiro títulos com digitos, depois letras
int comparar_title(const void *a, const void *b) {
    // Função de comparação para qsort (ou pode ser adaptada para o seu sort)
    const SHOW *show_a = (const SHOW *)a;
    const SHOW *show_b = (const SHOW *)b;

    bool a_dig = comeca_com_digito(show_a->TITLE);
    bool b_dig = comeca_com_digito(show_b->TITLE);

    if (a_dig && !b_dig) return -1; // a vem antes
    if (!a_dig && b_dig) return 1;  // b vem antes

    // Se ambos começam com dígito ou ambos com letra, usa strcmp
    return strcmp(show_a->TITLE, show_b->TITLE);
}

// --- ATENÇÃO: SELECTION SORT RECURSIVO ---
// Embora funcional, a recursão profunda PODE causar stack overflow
// para entradas MUITO grandes (muito além de MAX_SHOWS=1368).
// Uma versão iterativa seria mais segura contra stack overflow.
// Mantendo a versão recursiva conforme o original, mas ciente do risco.
// -----------------------------------------
void selection_sort_recursive(SHOW arr[], int n, int index, long *comparacoes, long *movimentacoes) {
    if (index >= n - 1) return;

    int min_index = index;
    for (int i = index + 1; i < n; i++) {
        (*comparacoes)++;
        // Usar a lógica de comparar_title diretamente aqui
        const char *title_i = arr[i].TITLE;
        const char *title_min = arr[min_index].TITLE;
        bool i_dig = comeca_com_digito(title_i);
        bool min_dig = comeca_com_digito(title_min);

        int cmp_res;
        if (i_dig && !min_dig) cmp_res = -1;
        else if (!i_dig && min_dig) cmp_res = 1;
        else cmp_res = strcmp(title_i, title_min);

        if (cmp_res < 0) {
            min_index = i;
        }
    }

    if (min_index != index) {
        // Troca (swap) - shallow copy é suficiente aqui
        SHOW temp = arr[index];
        arr[index] = arr[min_index];
        arr[min_index] = temp;
        (*movimentacoes)++; // Uma troca = 1 movimentação complexa (ou 3 simples)
                           // O critério de contar 3 é comum, mantendo.
        (*movimentacoes) += 2; // Para totalizar 3
    }

    selection_sort_recursive(arr, n, index + 1, comparacoes, movimentacoes);
}

// Geração do log
void gravar_log_selection(const char *matricula, long comparacoes, long movimentacoes, double tempo_execucao) {
    FILE *log = fopen("866767_selecaoRecursiva.txt", "w");
    if (log) {
        fprintf(log, "%s\t%ld\t%ld\t%.5f\n", matricula, comparacoes, movimentacoes, tempo_execucao);
        fclose(log);
    } else {
        perror("Erro ao abrir arquivo de log");
    }
}


int main() {
    // Alocar dinamicamente poderia ser mais seguro para arrays grandes,
    // mas vamos manter na stack por enquanto, assumindo MAX_SHOWS não é GIGANTE.
    SHOW vetor[MAX_SHOWS];
    // Inicializar para evitar ponteiros inválidos se lerCSV retornar 0
    for(int i=0; i<MAX_SHOWS; ++i) {
        vetor[i].CAST = NULL;
        vetor[i].LISTED_IN = NULL;
        vetor[i].cast_size = 0;
        vetor[i].listed_size = 0;
    }


    int total = lerCSV("disneyplus.csv", vetor, MAX_SHOWS);
    if (total <= 0) {
        fprintf(stderr, "Erro ao ler CSV ou arquivo vazio.\n");
         // Liberar memória se algo foi parcialmente alocado (embora lerCSV deva ter cuidado disso)
        for (int i = 0; i < MAX_SHOWS; i++) {
             free_show(&vetor[i]);
        }
        return 1;
    }
    //printf("Total de shows lidos: %d\n", total); // Debug

    // Usar alocação dinâmica para 'selecionados' seria mais robusto,
    // mas vamos limitar ao MAX_SHOWS por simplicidade.
    SHOW selecionados[MAX_SHOWS]; // Poderia ser SHOW* selecionados[MAX_SHOWS] para evitar cópias grandes
    int qtd_selecionados = 0;

    char entrada[MAX_STRING_SIZE];
    int ids_desejados[MAX_SHOWS]; // Armazena os IDs numéricos
    int qtd_ids = 0;

    // Leitura dos IDs de entrada - CORRIGIDO com fgets
    //printf("Digite os IDs dos shows (ex: s123), um por linha, e FIM para terminar:\n");
    while (qtd_ids < MAX_SHOWS) { // Limita a quantidade de IDs
        if (fgets(entrada, MAX_STRING_SIZE, stdin) == NULL) {
            // Fim de arquivo (EOF) ou erro de leitura
            break;
        }
        // Remove newline no final, se existir
        entrada[strcspn(entrada, "\r\n")] = 0;

        if (strcmp(entrada, "FIM") == 0) {
            break;
        }

        if (entrada[0] == 's' && entrada[1] != '\0') { // Verifica se tem algo após 's'
             char *endptr;
             long id_long = strtol(entrada + 1, &endptr, 10);
             // Verifica se a conversão foi bem sucedida e consumiu toda a string após 's'
             if (*endptr == '\0' && id_long > 0 && id_long <= 2147483647) { // Checa limites de int
                 ids_desejados[qtd_ids++] = (int)id_long;
             } else {
                 //fprintf(stderr, "ID inválido ignorado: %s\n", entrada);
             }
        } else {
             //fprintf(stderr, "Entrada inválida ignorada: %s\n", entrada);
        }
    }

     //printf("Quantidade de IDs lidos: %d\n", qtd_ids); // Debug

    // Filtra os registros com os IDs informados
    for (int i = 0; i < qtd_ids; i++) {
        for (int j = 0; j < total; j++) {
            if (vetor[j].SHOW_ID == ids_desejados[i]) {
                if (qtd_selecionados < MAX_SHOWS) {
                    // Copia a struct. É uma shallow copy para CAST e LISTED_IN.
                    // Isso é OK porque a memória original em 'vetor' será mantida
                    // até o fim e liberada lá.
                    selecionados[qtd_selecionados++] = vetor[j];
                } else {
                    fprintf(stderr, "Aviso: Limite de shows selecionados atingido.\n");
                    goto end_filter; // Sai dos loops se o array 'selecionados' estiver cheio
                }
                break; // Encontrou o ID, vai para o próximo ID desejado
            }
        }
    }
end_filter:;

    //printf("Quantidade de shows selecionados: %d\n", qtd_selecionados); // Debug

    // Ordenação dos registros selecionados
    long comparacoes = 0, movimentacoes = 0;
    clock_t inicio = clock();
    if (qtd_selecionados > 0) {
       selection_sort_recursive(selecionados, qtd_selecionados, 0, &comparacoes, &movimentacoes);
       // Alternativa mais segura para stack:
       // qsort(selecionados, qtd_selecionados, sizeof(SHOW), comparar_title);
       // (comparar_title já está no formato qsort) - precisaria ajustar contadores
    }
    clock_t fim = clock();
    double tempo_exec = (double)(fim - inicio) / CLOCKS_PER_SEC;

    // Impressão dos registros ordenados
    for (int i = 0; i < qtd_selecionados; i++) {
        print_show(&selecionados[i]); // Passa ponteiro
    }

    gravar_log_selection("866767", comparacoes, movimentacoes, tempo_exec);

    // LIBERAR MEMÓRIA ALOCADA EM lerCSV
    //printf("Liberando memória...\n"); // Debug
    for (int i = 0; i < total; i++) {
        free_show(&vetor[i]);
    }
    //printf("Memória liberada.\n"); // Debug

    return 0;
}
