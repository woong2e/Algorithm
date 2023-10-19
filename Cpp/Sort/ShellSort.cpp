#include <iostream>

using namespace std;

void shellSort(int[], int);

int main(){
    int numTestCase;
    cin >> numTestCase;
    for(int i = 0; i<numTestCase; i++){
        int n;
        cin >> n;
        int num[n];
        for(int j = 0; j<n; j++){
            cin >>  num[j];
        }
        shellSort(num, n);
        for(int k : num){
            cout << k << " ";
        }
        cout << endl;
    }
}

void shellSort(int arr[], int n){
    int shrinkRatio = 2;
    int gap = n/shrinkRatio;
    while(gap > 0){
        for(int i = gap; i<n; i++){
            int tmp = arr[i];
            int j;
            for(j = i; j>=gap && arr[j-gap]>tmp; j-=gap){
                arr[j] = arr[j-gap];
            }
            arr[j] = tmp;
        }
        gap /= shrinkRatio;
    }
}
