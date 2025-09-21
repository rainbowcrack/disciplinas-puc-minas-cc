#include <iostream>
#include <stdexcept>

using namespace std;

int main()
{
    cout << "Hello World!" << endl;

    try{
        cout << "\nEntrei no bloco Try" << endl;
        throw 1;
    }

    // lembra o default (...) todas as excecoes entram
    catch(int x){
        cout << "\nEntrei no bloco Catch de inteiro" << endl;
    }

    catch(...){
        cout << "\nEntrei no bloco Catch padrao" << endl;
    }

    cout << "\nSai da instrucao Try" << endl;

    return 0;
}
