#include <iostream>

using namespace std;

int factorial(int);
int deletZero(int);

int main(){
    int numTestCase;
    cin >> numTestCase;
    for(int i = 0; i < numTestCase; i++){
        int n;
        cin >> n;
        cout << factorial(n)%1000 << endl;
    }
}

int factorial(int n){
    if(n <= 1){
        return 1;
    }else{
        int tmp = deletZero(n*factorial(n-1));
        return tmp;
    }
}

int deletZero(int k){
    if(k % 10 != 0){
        return k%10000;
    }else{
        return deletZero(k/10);
    }
}