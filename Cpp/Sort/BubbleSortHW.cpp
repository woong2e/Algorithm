#include <iostream>

using namespace std;

#define MAX_SIZE 1000

void bubbleSort(int a[], int n);
void bubbleSortImproved1(int a[], int n);
void bubbleSortImproved2(int a[], int n);
void copyArray(int a[], int b[], int n);

int main() {
    int numTestCases;
    cin >> numTestCases;

    for (int i = 0; i < numTestCases; ++i) {
        int num;
        int a[MAX_SIZE];
        int b[MAX_SIZE];

        cin >> num;
        for (int j = 0; j < num; j++) {
            cin >> b[j];
        }

        copyArray(a, b, num);
        bubbleSort(a, num);
        copyArray(a, b, num);
        bubbleSortImproved1(a, num);
        copyArray(a, b, num);
        bubbleSortImproved2(a, num);

        cout << endl;
    }

    return 0;
}

void swap(int* a, int* b){ 
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

void bubbleSort(int a[], int n) {
    int countCmpOps = 0;
    int countSwaps = 0;

    for (int pass = 1; pass < n; pass++) {
        for (int i = 1; i <= n - pass; i++) {
            if (a[i - 1] > a[i]) {
                swap(&a[i-1], &a[i]);
                countSwaps++;
            }
            countCmpOps++;
        }
    }
    cout << countCmpOps << " " << countSwaps << " ";
}

void bubbleSortImproved1(int a[], int n) {
    int countCmpOps = 0;
    int countSwaps = 0;

    for (int pass = 1; pass < n; pass++) {
        bool swapped = false;
        for (int i = 1; i <= n - pass; i++) {
            if (a[i - 1] > a[i]) {
                swap(&a[i - 1], &a[i]);
                swapped = true;
                countSwaps++;
            }
            countCmpOps++;
        }
        if (!swapped)
            break;
    }
    cout << countCmpOps << " " << countSwaps << " ";
}

void bubbleSortImproved2(int a[], int n) {
    int countCmpOps = 0;
    int countSwaps = 0;

    int lastSwappedPos = n;
    while (lastSwappedPos > 0) {
        int swappedPos = 0;
        for (int i = 1; i < lastSwappedPos; i++) {
            if (a[i - 1] > a[i]) {
                swap(&a[i - 1], &a[i]);
                swappedPos = i;
                countSwaps++;
            }
            countCmpOps++;
        }
        lastSwappedPos = swappedPos;
    }
    cout << countCmpOps << " " << countSwaps << " ";
}

void copyArray(int a[], int b[], int n) {
    for (int i = 0; i < n; i++)
        a[i] = b[i];
}