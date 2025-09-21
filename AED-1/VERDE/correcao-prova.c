#include <stdio.h>
#include <stdlib.h>

void cadastrarRespostas(int n_alunos, int n_questoes, char **respostas) {
    for (int i = 0; i < n_alunos; i++) {
        for (int j = 0; j < n_questoes; j++) {
            scanf(" %c", &respostas[i][j]);
        }
    }
}

void cadastrarGabarito(int n_questoes, char *gabarito) {
    for (int i = 0; i < n_questoes; i++) {
        scanf(" %c", &gabarito[i]);
    }
}

int* calcularPontuacao(int n_alunos, int n_questoes, char **respostas, char *gabarito) {
    int *pontuacoes = (int *)malloc(n_alunos * sizeof(int));  // Aloca memória para as pontuações

    for (int i = 0; i < n_alunos; i++) {
        int pontuacao = 0;
        for (int j = 0; j < n_questoes; j++) {
            if (respostas[i][j] == gabarito[j]) {
                pontuacao++;
            }
        }
        pontuacoes[i] = pontuacao;
    }

    return pontuacoes;
}

int main() {
    int n_alunos, n_questoes;

    // Leitura de N e M
    scanf("%d %d", &n_alunos, &n_questoes);

    // Aloca memória para as respostas dos alunos
    char **respostas = (char **)malloc(n_alunos * sizeof(char *));

    for (int i = 0; i < n_alunos; i++) {
        respostas[i] = (char *)malloc(n_questoes * sizeof(char));
    }

    // aloca memória para o gabarito, dinamicamente
    char *gabarito = (char *)malloc(n_questoes * sizeof(char));

    // Cadastro das respostas dos alunos
    cadastrarRespostas(n_alunos, n_questoes, respostas);
    cadastrarGabarito(n_questoes, gabarito);

    // calculo das pontuações em variáveis
    int *pontuacoes = calcularPontuacao(n_alunos, n_questoes, respostas, gabarito);

    // mostra pontuacoes
    for (int i = 0; i < n_alunos; i++) {
        printf("%d ", pontuacoes[i]);
    }

    // libera a memoria
    free(respostas);
    free(gabarito);
    free(pontuacoes);

    return 0;
}
