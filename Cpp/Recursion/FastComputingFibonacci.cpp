#include <iostream>

using namespace std;

int fastComputeFibonacci(int);
void powMat(int, int[2][2]);
void mulMat(int[2][2], int[2][2]);

int main(){
    int numTestCase;
    cin >> numTestCase;
    for(int i = 0; i < numTestCase; i++){
        int n;
        cin >> n;
        cout << fastComputeFibonacci(n) << endl;
    }
}

int fastComputeFibonacci(int n){
    int result[2][2] = {{1,1},{1,0}};
    if(n <= 1){
        return n;
    }
    powMat(n-1, result);
    return result[0][0];
}

void powMat(int n, int result[2][2]){
    int base[2][2] = {{1,1},{1,0}};
    if(n <= 1){
        return;
    }

    if(n % 2 == 0){
        powMat(n/2, result);
        mulMat(result, result);
    }else{
        powMat(n/2, result);
        mulMat(result, result);
        mulMat(result, base);
    }
}

void mulMat(int result[2][2], int y[2][2]){
    int f[2][2] = {{0, 0}, {0, 0}};
    for(int i = 0; i<2; i++){
        for(int j = 0; j<2; j++){
            for(int k = 0; k<2; k++){
            f[i][j] += result[i][k] * y[k][j];
            f[i][j] %= 1000;
            }
        }
    }
    for(int i = 0; i<2; i++){
        for(int j = 0; j<2; j++){
            result[i][j]= f[i][j];
        }
    }
}
