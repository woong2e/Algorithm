package DivideConquer;

import java.util.Scanner;

public class BinarySearching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for(int i = 0; i < numTestCases; ++i) {
            int testCases = sc.nextInt();
            int K = sc.nextInt();
            int[] num = new int[testCases];
            for (int j = 0; j < testCases; j++) {
                num[j] = sc.nextInt();
            }
            System.out.println(binarySearch(K, num, 0, testCases-1));
        }
    }

    public static int binarySearch(int K, int[] arr, int start, int end){
        int mid;
        if(start > end){
            return -1;
        }else{
            mid = (start+end)/2;
            if(K == arr[mid]) {
                return mid;
            }else if(K < arr[mid]){
                return binarySearch(K, arr, start, mid-1);
            }else{
                return binarySearch(K, arr, mid + 1, end);
            }
        }
    }
}
