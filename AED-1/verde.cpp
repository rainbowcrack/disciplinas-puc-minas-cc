#include <iostream>
#include <string>

using namespace std;

// variáveis globais
const int _MAX = 100;
int TAM = 0;

// Classe Candidato
class Candidato {
private:
    string nome;
    double nota;

public:
    void setNome(const string& nome) {
        this->nome = nome;  // passagem por referencia
    }

    void setNota(double nota) {
        this->nota = nota; 
    }

    string getNome() const {
        return this->nome; 
    }

    double getNota() const {
        return this->nota; 
    }
};

// número de candidatos
void numCandidato() {
    cin >> TAM;  
}

// armazenar os candidatos no vetor com alocação dinâmica
void vetorCandidatos(Candidato* CANDIDATO[], int TAM) {
    cin.ignore();  // Limpa o buffer do cin 

    for (int i = 0; i < TAM; i++) {
        CANDIDATO[i] = new Candidato();  // Aloca dinamicamente o objeto Candidato

        string nome;
        double nota;
        
        cin >> nome >> nota;

        CANDIDATO[i]->setNome(nome);
        CANDIDATO[i]->setNota(nota);

        cin.ignore();  // Limpa o buffer do cin
    }
}

// Função para calcular a média das notas
float media(Candidato* CANDIDATO[], int TAM) {
    double soma = 0;
    for (int i = 0; i < TAM; i++) {
        soma += CANDIDATO[i]->getNota();  // Soma as notas dos candidatos
    }
    return soma / TAM;  // Retorna a média das notas
}

int main() {
    Candidato* CANDIDATO[_MAX];  // Vetor de ponteiros para objetos Candidato

    numCandidato(); 
    vetorCandidatos(CANDIDATO, TAM); 
    float mediaNota = media(CANDIDATO, TAM);

    // candidatos com nota acima da média
    for (int i = 0; i < TAM; i++) {
        if (CANDIDATO[i]->getNota() > mediaNota) {
            cout << CANDIDATO[i]->getNome() << " " << CANDIDATO[i]->getNota() << endl;
        }
    }

    return 0;
}
