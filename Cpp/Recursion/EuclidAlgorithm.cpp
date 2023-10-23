#include <iostream>
#include <stdio.h>
using namespace std;

int gcd(int a, int b){
    if(b == 0){
        return a;
    }else{
        return gcd(b, a%b);
    }
}

int main(){
    int numTestCases;
    cin >> numTestCases;

    for(int i = 0; i<numTestCases; i++){
        int m,n;
        cin >> m >> n;
        cout << gcd(m,n) << endl;
    }
    return 0;
}