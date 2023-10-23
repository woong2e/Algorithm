#include <iostream>

using namespace std;

int fibonacci(int);

int main(){
    int numTestCase;
    cin >> numTestCase;
    for(int i = 0; i < numTestCase; i++){
        int n;
        cin >> n;
        cout << fibonacci(n) << endl;
    }
}

int fibonacci(int n){
    if(n <= 1){
        return n;
    }else{
        return fibonacci(n-1)+fibonacci(n-2);
    }

}