#include <iostream>
#include <stdexcept>
#include <stdbool.h>

using namespace std;

int divisao(int a, int b){
    if(b==0) throw runtime_error("\n\aErro: divisao por zero\n");
    else return a/b;
}


int main(){
    int a, b;
    bool excecao = true;


    do{
        cin >> a >> b;
        try{
            cout << divisao(a,b);
        }

        catch(runtime_error e){
            cout << e.what();
        }
    }while(excecao);



    cout << "\nSempre executado, ainda que divisor igual a zero";

    return 0;
}
