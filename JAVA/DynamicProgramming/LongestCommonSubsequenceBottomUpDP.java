package DynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubsequenceBottomUpDP {
    static String X, Y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTestCase = sc.nextInt();
        for (int i = 0; i< numTestCase; i++) {
            X = sc.next();
            Y = sc.next();
            findLongestCommonSubsequence(X.length(), Y.length());
            System.out.println();
        }
    }

    static void findLongestCommonSubsequence(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        int[][] trace = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            memo[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            memo[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i-1) == Y.charAt(j-1)) {
                    memo[i][j] = memo[i-1][j-1] + 1;
                    trace[i][j] = 0;
                } else {
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                    if (memo[i][j] == memo[i][j-1]) {
                        trace[i][j] = 1;
                    } else {
                        trace[i][j] = 2;
                    }
                }
            }
        }
        System.out.print(memo[m][n] + " ");
        printLongestCommonSubsequence(trace, m, n);
    }
     static void printLongestCommonSubsequence(int[][] trace, int m, int n) {
        if (m == 0 || n == 0) {
            return;
        }
        if (trace[m][n] == 0) {
            printLongestCommonSubsequence(trace, m-1, n-1);
            System.out.print(X.charAt(m-1));
        } else if (trace[m][n] == 1) {
            printLongestCommonSubsequence(trace, m, n-1);
        } else if (trace[m][n] == 2) {
            printLongestCommonSubsequence(trace, m-1, n);
        }
     }
}
