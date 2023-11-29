package DynamicProgramming;

import java.util.Scanner;

public class ChainedMatrixMultiplicationBottomUpDP {
    static final int MIN_INT = Integer.MAX_VALUE;
    static final String MATRIX = "M";
    static int[][] s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestCase = sc.nextInt();
        for (int i = 0; i < numTestCase; i++) {
            int n = sc.nextInt();
            int[] num = new int[n+1];
            s = new int[n+1][n+1];
            for (int j = 0; j < n+1; j++) {
                num[j] = sc.nextInt();
            }
            System.out.println(findMinimumChainedMatrixMultiplication(num, n));
        }
    }

    static int findMinimumChainedMatrixMultiplication(int[] num, int n) {
        int[][] memo = new int[n+1][n+1];
        for (int l = 1; l < n; l++) {
            for (int i = 1; i < n-l+1; i++) {
                int m = i + l;
                memo[i][m] = MIN_INT;
                for (int k = i; k < m; k++) {
                    int sum =  memo[i][k] + memo[k+1][m] + num[i-1]*num[k]*num[m];
                    if (memo[i][m] > sum) {
                        memo[i][m] = sum;
                        s[i][m] = k;
                    }

                }
            }
        }
        printMulOrder(1,n);
        System.out.println();
        return memo[1][n];
    }

    static void printMulOrder(int start, int end) {
        if (start == end) {
            System.out.print(MATRIX);
            System.out.print(start);
            return;
        }
        int k = s[start][end];
        System.out.print("(");
        printMulOrder(start, k);
        printMulOrder(k+1, end);
        System.out.print(")");
    }
}
