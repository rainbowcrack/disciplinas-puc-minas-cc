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
        if(a > 10) throw 7.0; // protegido por if

        cout << "\nDory disse: Me escolhe, me escolhe!" << endl; // muda de mundo depois do throw, nao eh executado
    }

    // lembra o default (...) todas as excecoes entram
    catch(int x){
        cout << "\nEntrei no bloco Catch de inteiro com x = " << x << endl;
    }

    catch(double x){
        cout << "\nEntrei no bloco Catch de real com x = " << x << endl;
    }

    catch(...){
        cout << "\nEntrei no bloco Catch padrao" << endl;
    }

    cout << "\nSai da instrucao Try" << endl;

    return 0;
}
