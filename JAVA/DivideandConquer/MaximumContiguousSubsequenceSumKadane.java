package DivideConquer;

import java.util.Scanner;

public class MaximumContiguousSubsequenceSumKadane {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();
        for (int i = 0; i < TestCase; i++) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int j = 0; j < n; j++) {
                num[j] = sc.nextInt();
            }
            maxSubsequenceSum(num);
        }
    }

    public static void maxSubsequenceSum(int[] arr) {
        int idx = 0;
        int thisSum = 0;
        int maxSum = 0;
        int start = -1;
        int end = -1;
        for(int i = 0; i< arr.length; i++){
            thisSum +=arr[i];
            if(thisSum > maxSum) {
                maxSum = thisSum;
                start = idx;
                end = i;
            }else if(thisSum <= 0){
                idx = i+1;
                thisSum = 0;
            }
        }
        System.out.printf("%d %d %d\n",maxSum, start, end);
    }
}