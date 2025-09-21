#include <iostream>
#include <stdexcept>

using namespace std;

int main()
{
    cout << "Hello World!" << endl;
    int a;

    try{
        a = 10;

        cout << "\nEntrei no bloco Try" << endl;
        if(a == 10) throw 'a'; // protegido por if

        cout << "\nDory disse: Me escolhe, me escolhe!" << endl; // muda de mundo depois do throw, nao eh executado
    }

    // lembra o default (...) todas as excecoes entram
    catch(int x){
        cout << "\nEntrei no bloco Catch de inteiro com x = " << x << endl;
    }

    catch(double x){
        cout << "\nEntrei no bloco Catch de real com x = " << x << endl;
    }

    catch(...){ // esse controle em Java eh o except
        cout << "\nEntrei no bloco Catch padrao" << endl;
    }

    cout << "\nEsta msg serah executada??" << endl;

    return 0;
}
