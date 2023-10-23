#include <iostream>

using namespace std;

int fCP(int x, int n);

int main(){
    int numTestCases;
    cin >> numTestCase;
    for (int i = 0; i < numTestCases; ++i){
        int x, n;
        cin >> x >> n;
        cout << fCP(x, n)%1000 << endl;
    }
}

int fCP(int x, int n){
    if(n == 0){
        return 1;
    }else if(n%2 == 0){
        int y = fCP(x, n/2);
        return (y*y)%1000;
    }else{
        int z = fCP(x,(n-1)/2);
        return (x*z*z)%1000;
    }
}
