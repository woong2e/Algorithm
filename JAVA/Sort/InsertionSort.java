package Sort;

import java.util.Scanner;

public class InsertionSort {
    public static final int MAX_SIZE = 1000;

    public static void main(String[] args) {
        int numTestCases;
        Scanner sc = new Scanner(System.in);
        numTestCases = sc.nextInt();

        for (int i = 0; i < numTestCases; ++i) {
            int num;
            int[] a = new int[MAX_SIZE];

            num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                a[j] = sc.nextInt();
            }
            insertionSort(a, num);
        }
    }

    private static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void insertionSort(int a[], int n)
    {
        int countCmpOps = 0;
        int countSwaps = 0;

        for(int i = 1; i < n; i++){
            for(int j = i; j > 0; j--){
                if(a[j-1] > a[j]){
                    countCmpOps++;
                    swap(a, j-1, j);
                    countSwaps++;
                }else{
                    countCmpOps++;
                    break;
                }
            }
        }
        System.out.printf("%d %d \n", countCmpOps, countSwaps);
    }
}
