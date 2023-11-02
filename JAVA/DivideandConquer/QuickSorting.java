package DivideConquer;

import java.util.Scanner;

public class QuickSorting {
    public static int nSwapHoare;
    public static int nSwapLomuto;
    public static int nComparisonHoare;
    public static int nComparisonLomuto;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for(int i = 0; i < numTestCases; ++i) {
            nSwapHoare = 0;
            nSwapLomuto = 0;
            nComparisonHoare = 0;
            nComparisonLomuto = 0;

            int testCases = sc.nextInt();
            int[] num = new int[testCases];
            for (int j = 0; j < testCases; j++) {
                num[j] = sc.nextInt();
            }
            int[] numCopy = copy(num, testCases);
            quickSort_Lomuto(numCopy, 0, testCases-1);
            numCopy = copy(num, testCases);
            quickSort_Hoare(numCopy, 0, testCases-1);
            System.out.printf("%d %d %d %d\n", nSwapHoare, nSwapLomuto,
                    nComparisonHoare,nComparisonLomuto);
        }
    }

    public static void quickSort_Hoare(int[] num, int low, int high){
        int p;
        if(low >= high) {
            return;
        }
        p = partition_Hoare(num, low, high);
        quickSort_Hoare(num, low, p);
        quickSort_Hoare(num, p+1, high);

    }

    public static void quickSort_Lomuto(int[] num, int low, int high){
        int p;
        if(low >= high) {
            return;
        }
        p = partition_Lomuto(num, low, high);
        quickSort_Lomuto(num, low, p-1);
        quickSort_Lomuto(num, p+1, high);

    }

    public static int partition_Hoare(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low-1;
        int j = high+1;
        while(true){
            do{
                nComparisonHoare++;
                i++;
            }while(arr[i] < pivot);

            do{
                nComparisonHoare++;
                j--;
            }while(arr[j] > pivot);

            if(i < j){
                swap(arr, i, j);
                nSwapHoare++;
            }else{
                return j;
            }
        }
    }

    public static int partition_Lomuto(int[] arr, int low, int high){
        int pivot = arr[low];
        int j = low;
        for(int i = low +1; i <= high; i++){
            if(arr[i] < pivot){
                j++;
                swap(arr, j, i);
                nSwapLomuto++;
            }
            nComparisonLomuto++;
        }
        int pivotPos = j;
        swap(arr, low, pivotPos);
        nSwapLomuto++;
        return pivotPos;
    }

    public static void swap(int[] a, int m, int n){
        int tmp = a[m];
        a[m] = a[n];
        a[n] = tmp;
    }

    public static int[] copy(int[] a, int n){
        int[] b = new int[n];
        for(int i = 0; i<n; i++){
            b[i] = a[i];
        }
        return b;
    }
}
