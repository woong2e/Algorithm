package Sort;

import java.util.Scanner;

public class BubbleSortHW {
    public static final int  MAX_SIZE = 1000;

    public static void main(String[] args){
        int numTestCases;
        Scanner sc = new Scanner(System.in);
        numTestCases = sc.nextInt();

        for (int i = 0; i < numTestCases; ++i){
            int num;
            int[] a = new int[MAX_SIZE];
            int[] b = new int[MAX_SIZE];

            num = sc.nextInt();
            for(int j = 0; j < num; j++) {
                b[j] = sc.nextInt();
            }

            copyArray(a, b, num);
            bubbleSort(a, num);
            copyArray(a, b, num);
            bubbleSortImproved1(a, num);
            copyArray(a, b, num);
            bubbleSortImproved2(a, num);

            System.out.println();
        }

    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bubbleSort(int a[], int n){
        int countCmpOps = 0;
        int countSwaps = 0;

        for(int pass = 1; pass < n; pass++) {
            for (int i = 1; i <= n-pass; i++){
                if(a[i-1] > a[i]) {
                    swap(a,i-1, i);
                    countSwaps++;
                }
                countCmpOps++;
            }
        }
        System.out.printf("%d %d ", countCmpOps, countSwaps);
    }

    public static void bubbleSortImproved1(int a[], int n){
        int countCmpOps = 0;
        int countSwaps = 0;

        for(int pass = 1; pass < n; pass++) {
            boolean swapped = false;
            for(int i = 1; i <= n-pass; i++) {
                if (a[i-1] > a[i]){
                    swap(a, i-1, i);
                    swapped = true;
                    countSwaps++;
                }
                countCmpOps++;
            }
            if (!swapped)
                break;
        }
        System.out.printf("%d %d ", countCmpOps, countSwaps);
    }


    public static void bubbleSortImproved2(int a[], int n){
        int countCmpOps = 0;
        int countSwaps = 0;

        int lastSwappedPos = n;
        while(lastSwappedPos>0){
            int swappedPos = 0;
            for(int i = 1; i < lastSwappedPos; i++){
                if(a[i-1]>a[i]){
                    swap(a, i-1, i);
                    swappedPos = i;
                    countSwaps++;
                }
                countCmpOps++;
            }
            lastSwappedPos = swappedPos;
        }
        System.out.printf("%d %d", countCmpOps, countSwaps);
    }

    public static void copyArray(int a[], int b[], int n){
        for(int i = 0; i < n; i++)
            a[i] = b[i];
    }

}
