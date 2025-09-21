#include <iostream>
#include <new>

using namespace std;
using std::bad_alloc;

int main(){

    double *ptr[200];

    try{
        // aloca memoria para ptr
        for(int i = 0; i < 200; i++){
            ptr[i] = new double[50000000];
            cout << "Alocado 50.000.000 doubles in ptr[" << i << "]\n";
        }
    }// fim do try

    catch(bad_alloc memoryAllocationException){
        cout << "Exveption occurred: " << memoryAllocationException.what() << endl;
        cout << "\Memoria insuficiente";
    }// fim do catch

    return 0;

}
