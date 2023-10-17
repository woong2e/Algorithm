#include <iostream>

#define MAX_SIZE 1000

using namespace std;

void selectionSort(int arr[], int n);
void swap(int* a, int* b);

int main(){
    int numTestCase;
    cin >>  numTestCase;
    for(int i = 0; i<numTestCase; i++){
        int n;
        cin >> n;
        int num[MAX_SIZE];
        for(int j = 0; j<n; j++){
            cin >> num[j];
        }
        selectionSort(num, n);
    }

}

void selectionSort(int arr[], int n){
    int idx;
    for(int start = 0; start<n-1; start++){
        idx = start;
        for(int i = start+1; i<n; i++){
            if(arr[i] < arr[idx]){
                idx = i;
            }
        }
        if(idx != start){
            swap(&arr[idx], &arr[start]);
        }
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