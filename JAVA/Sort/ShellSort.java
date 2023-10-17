package Sort;

import java.util.Scanner;

public class ShellSort {
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
            shellSort(a, num);
        }
    }

    private static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void shellSort(int a[], int n) {
        int countCmpOps = 0;
        int countSwaps = 0;

        int shrinkRatio = 2;
        int gap = (int)(n/shrinkRatio);
        int tmp;
        while(gap>0){
            for(int i = gap; i < n; i++){
                for(int j = i; j >= gap; j -= gap){
                    if(a[j-gap] > a[j]){
                        countCmpOps++;
                        swap(a, j-gap, j);
                        countSwaps++;
                    }else{
                        countCmpOps++;
                        break;
                    }
                }
            }
            gap /= shrinkRatio;
        }


        System.out.printf("%d %d \n", countCmpOps, countSwaps);
    }
}
