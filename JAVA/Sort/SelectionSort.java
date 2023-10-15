package Sort;

import java.util.Scanner;

public class SelectionSortHW {
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
            selectionSort(a, num);
        }
    }

    private static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void selectionSort(int a[], int n){
        int countCmpOps = 0;
        int countSwaps = 0;


        for(int i = 0; i < n-1; i++){
            int minidx = i;

            for(int j = i+1; j < n; j++){
                if(a[j] < a[minidx]){
                    minidx = j;
                }
                countCmpOps++;
            }
            if(minidx !=i){
                swap(a, i, minidx);
                countSwaps++;
            }
        }


        System.out.printf("%d %d \n", countCmpOps, countSwaps);

    }
}
