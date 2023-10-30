package DivideConquer;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for(int i = 0; i < numTestCases; ++i){
            int testCases = sc.nextInt();
            int[] num = new int[testCases];
            for(int j = 0; j <testCases; j++){
                num[j] = sc.nextInt();
            }
            findSubsequence(num);
        }
    }

    public static void findSubsequence(int[] arr){
        int maxlen = 1;
        int len = 1;
        int idx = 0;
        for(int i = 1; i<arr.length;i++){
            if(arr[i] >= arr[idx]){
                len++;
            }else{
                if(maxlen < len){
                    maxlen = len;
                }
                len = 1;
                idx = i;
            }
        }
        if(maxlen < len){
            maxlen = len;
        }
        System.out.println(maxlen);
    }
}
