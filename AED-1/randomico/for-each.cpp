#include <iostream>

using namespace std;

int main()
{
    // o for-each nasce para ler do primeiro ao ultimo
    
    string array[] = {"Lucas", "Gabriel", "Any", "Mateus"};

    for(string nome : array){
        cout << endl << nome;
    }

    return 0;
}
