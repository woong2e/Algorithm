package Sort;

import java.util.Scanner;

public class CombSortHW {
    public static final int MAX_SIZE = 1000;

    public static void main(String[] args){
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
            combSort(a, num);
        }
    }

    private static void swap(int a[], int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void combSort(int a[], int n){
        int countCmpOps = 0;
        int countSwaps = 0;

        double shrink = 1.3;
        int gap = n;
        boolean sorted = false;

        while(sorted == false){
            gap = (int)(gap/shrink);
            if(gap<=1){
                gap = 1;
                sorted = true;
            }
            int i =0;
            while(i+gap < n){
                if(a[i] > a[i+gap]){
                    swap(a,i, i+gap );
                    sorted = false;
                    countSwaps++;
                }
                i++;
                countCmpOps++;
            }
        }
        System.out.printf("%d %d \n", countCmpOps, countSwaps);
    }
}
