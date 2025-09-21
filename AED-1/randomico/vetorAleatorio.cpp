#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

int main()
{
    int vet[10];
    srand(time(0));

    for(int i = 0; i < 10; i++){
        vet[i] = rand()%100;
        cout << vet[i] << " ";
    }
    return 0;
}
