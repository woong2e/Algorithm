package DivideConquer;

import java.util.Scanner;

public class MergeSort {
    public static int NCOMPARISON;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numTestCase;
        numTestCase = sc.nextInt();
        for (int i = 0; i < numTestCase; i++) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for(int j = 0; j<n; j++){
                num[j] = sc.nextInt();
            }
            NCOMPARISON = 0;
            mergeSort(num, 0, n-1);
            System.out.println(NCOMPARISON);
        }
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low == high) return;

        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high){
        int[] tmp = new int[arr.length];
        for(int i = low; i<=high; i++){
            tmp[i] = arr[i];
        }
        int i = low;
        int k = low;
        int j = mid+1;
        while(i <= mid && j <= high){
            if(tmp[i] <= tmp[j]){
                arr[k++] = tmp[i++];
            }else{
                arr[k++] = tmp[j++];
            }
            NCOMPARISON++;
        }
        while(i <= mid){
            arr[k++] = tmp[i++];
        }
        while(j <= high){
            arr[k++] = tmp[j++];
        }
    }
}
