#include <iostream>

using namespace std;

class AlunoTrabalho {
    
private:
    string nome, data;
    
public:
    void setNome(string nome){
        this->nome = nome;
    }
    
    string getNome(){
        return this->nome;
    }
    
    void setData(string data){
        this->data = data;
    }
    
    string getData(){
        return this->data;
    }
};

int main() {
    // Definindo o array de objetos AlunoTrabalho
    AlunoTrabalho alunos[5];
    
    // Lendo os dados de 5 alunos
    for (int i = 0; i < 5; ++i) {
        string nome, data;
        
        cout << "Digite o nome do aluno " << i + 1 << ": ";
        cin >> nome;
        alunos[i].setNome(nome);
        
        cout << "Digite a data de nascimento do aluno " << i + 1 << " (DD/MM/AAAA): ";
        cin >> data;
        alunos[i].setData(data);
    }
    
    // Contando quantos alunos têm nome com mais de 5 letras usando for-each
    int count = 0;
    for (AlunoTrabalho& aluno : alunos) {
        if (aluno.getNome().length() > 5) {
            count++;
        }
    }
    
    cout << "Quantidade de alunos com nome com mais de 5 letras: " << count << endl;

    return 0;
}
