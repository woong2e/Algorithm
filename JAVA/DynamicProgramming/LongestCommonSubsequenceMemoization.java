package DynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubsequenceMemoization {
    static int[][] mem;
    static String X;
    static String Y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCase = sc.nextInt();

        for (int i = 0; i < numTestCase; i++) {
            X = sc.next();
            Y = sc.next();
            mem = new int[X.length() + 1][Y.length() + 1];
            for (int a = 0; a < X.length() + 1; a++) {
                for (int b = 0; b < Y.length() + 1; b++) {
                    mem[a][b] = -1;
                }
            }
            System.out.println(findLongestCommonSubsequence(0, 0));
        }
    }

    public static int findLongestCommonSubsequence(int m, int n) {
        if(m >= X.length() || n >= Y.length()) {
            return 0;
        }
        if(mem[m][n] >= 0) {
            return mem[m][n];
        }
        if(X.charAt(m) == Y.charAt(n)) {
            mem[m][n] = 1 + findLongestCommonSubsequence(m + 1, n + 1);
            return mem[m][n];
        }
        mem[m][n] = Math.max(findLongestCommonSubsequence(m + 1,n), findLongestCommonSubsequence(m, n + 1));
        return mem[m][n];
    }
}

