#include <iostream>

#define MAX_SIZE 1000

using namespace std;

void combSort(int arr[], int n);
void swap(int* a, int* b);

int main(){
    int numTestCase;

    cin >> numTestCase;

    for(int i = 0; i < numTestCase; i++){
        int n;
        cin >> n;
        int num[MAX_SIZE];
        for(int j = 0; j<n; j++){
            cin >> num[j];
        }
        combSort(num, n);
    }
    return 0;
}

void combSort(int arr[], int n){
    double k = 1.3;
    int gap = n/k;
    while(gap >= 1){
        for(int i = 0; i<n-gap; i++){
            if(arr[i] > arr[i+gap]){
                swap(&arr[i], &arr[i+gap]);
            }
        }
        gap /= k;
    }
    for(int i = 0; i<n; i++){
        cout << arr[i] << " ";
    }
    cout << endl;
}

void swap(int* a, int* b){
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

