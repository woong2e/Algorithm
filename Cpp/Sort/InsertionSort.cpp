#include <iostream>

#define MAX_SIZE 100

using namespace std;

void insertionSort(int arr[], int n);
void swap(int* a, int* b);

int main(){
    int numTestCase;
    cin >> numTestCase;
    for(int i = 0; i<numTestCase; i++){
        int n;
        cin >> n;
        int num[MAX_SIZE];
        for(int j = 0; j<n; j++){
            cin >> num[j];
        }
        insertionSort(num, n);  
    }
    return 0;
}

void insertionSort(int arr[], int n){
    for(int i = 1; i<n; i++){
        int tmp = arr[i];
        for(int j = i-1; j>=0; j--){
            if(tmp < arr[j]){
                arr[j+1] = arr[j];
                if(j == 0){
                    arr[j] = tmp;
                }
            }else{
                arr[j+1] = tmp;
                break;
            }
        }
    }
    for(int k = 0; k<n; k++){
        cout << arr[k] << " ";
    }
    cout << endl;
}

void swap(int* a, int* b){
    int tmp = *a;
    *a = *b;
    *b = tmp;
}