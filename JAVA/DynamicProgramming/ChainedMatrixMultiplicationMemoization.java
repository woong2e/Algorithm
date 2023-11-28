package DynamicProgramming;

import java.util.Scanner;

public class ChainedMatrixMultiplicationMemoization {
    static int[][] mem;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestCase = sc.nextInt();
        for (int i = 0; i < numTestCase; i++) {
            int n = sc.nextInt();
            int dArr[] = new int[n+1];
            mem = new int[n+1][n+1];
            for (int a = 0; a < n+1; a++) {
                for (int b = 0; b < n+1; b++) {
                    mem[a][b] = -1;
                }
            }
            for (int j = 0; j < n + 1; j++) {
                dArr[j] = sc.nextInt();
            }
            System.out.println(findMinimumChainedMatrixMultiplicationNumber(dArr, 1, n));
        }
    }

    static int findMinimumChainedMatrixMultiplicationNumber(int[] dArr, int start, int end) {
        if (start == end) {
            return 0;
        }
        if (mem[start][end] >= 0) {
            return mem[start][end];
        }
        mem[start][end] = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int count = findMinimumChainedMatrixMultiplicationNumber(dArr, start, i) +
                    findMinimumChainedMatrixMultiplicationNumber(dArr, i + 1, end)
                    + dArr[start-1]*dArr[i]*dArr[end];
            mem[start][end] = Math.min(mem[start][end], count);
        }

        return mem[start][end];
    }
}
