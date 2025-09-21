#include <iostream>
using namespace std;

class B {
private:
    float Y;  // Herdado por A

public:
    // Setters e Getters para Y
    void setY(float y) {
        this->Y = y;  // Acessando o atributo Y da classe B
    }

    float getY() const {
        return this->Y;  // Acessando o atributo Y da classe B
    }
};

// Classe A que herda de B
class A : public B {
private:
    float X;
    static int quantidade;  // Contador estático para o número de instâncias

public:
    // Construtor padrão
    A() {
        this->X = 0.0;
        setY(0.0);  // Inicializa Y chamando o setter da classe B
        quantidade++;  // Incrementa o contador de instâncias
    }

    // Construtor com parâmetros
    A(float x, float y) {
        setX(x);  // Utiliza o setter de X para inicializar
        setY(y);  // Utiliza o setter de Y da classe B
        quantidade++;  // Incrementa o contador de instâncias
    }

    // Destruidor
    ~A() {
        quantidade--;  // Decrementa o contador de instâncias quando o objeto é destruído
    }

    // Método para configurar X e Y
    void setA(float x, float y) {
        setX(x);  // Configura X usando o setter de A
        setY(y);  // Configura Y usando o setter de B
    }

    // Método para escrever os valores de X e Y
    void escreve() const {
        cout << "X: " << getX() << ", Y: " << getY() << endl;  // Usando getX e getY para acessar X e Y
    }

    // Método estático para obter a quantidade de instâncias
    static int quantidadeInstancias() {
        return quantidade;  // Retorna o contador de instâncias
    }

    // Método para comparar o valor de X entre dois objetos
    float maior(A* outro) const {
        if (this->getX() > outro->getX()) {
            return this->getX();  // Retorna o maior X
        } else {
            return outro->getX();  // Retorna o maior X
        }
    }

    // Métodos para acessar X
    void setX(float x) {
        this->X = x;  // Configura o valor de X
    }

    float getX() const {
        return this->X;  // Retorna o valor de X
    }
};

// Inicialização do contador estático
int A::quantidade = 0;
