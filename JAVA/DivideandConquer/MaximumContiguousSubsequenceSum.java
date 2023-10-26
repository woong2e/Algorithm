package DivideConquer;

import java.util.Scanner;

public class MaximumContiguousSubsequenceSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();
        for (int i = 0; i < TestCase; i++) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int j = 0; j < n; j++) {
                num[j] = sc.nextInt();
            }
            System.out.println(maximumContiguousSubsequenceSum(num,0, n-1));
        }
    }

    public static int maximumContiguousSubsequenceSum(int[] arr, int start, int end){
        if(start == end){
            return Math.max(0, arr[start]);
        }
        int mid = (start+end)/2;
        int leftSum = maximumContiguousSubsequenceSum(arr, start, mid);
        int rightSum = maximumContiguousSubsequenceSum(arr, mid + 1, end);

        int maxSumMid = maxSubsequenceSumMid(arr, start, end);


        return Math.max(Math.max(leftSum,rightSum),maxSumMid);
    }


    public static int maxSubsequenceSumMid(int[] arr, int start, int end){
        int maxSumDown = 0;
        int maxSumUp = 0;
        int thisSum = 0;
        int maxSum;
        int mid = (start+end)/2;
        for(int i = mid; i>=start; i--){
            thisSum +=arr[i];
            if(thisSum >=maxSumDown) {
                maxSumDown = thisSum;
            }
        }
        thisSum = 0;
        for(int i = mid+1; i<=end; i++){
            thisSum +=arr[i];
            if(thisSum >maxSumUp) {
                maxSumUp = thisSum;
            }
        }
        maxSum = maxSumDown + maxSumUp;
        return maxSum;
    }
}
