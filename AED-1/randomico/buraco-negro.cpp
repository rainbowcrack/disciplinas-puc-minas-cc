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

    // esse buraco negro pega o num por ser generico
    catch(...){
        cout << "\nEntrei no bloco Catch padrao" << endl;
    }

    catch(int x){
        cout << "\nEntrei no bloco Catch de inteiro" << endl;
    }

    cout << "\nSai da instrucao Try" << endl;

    return 0;
}
