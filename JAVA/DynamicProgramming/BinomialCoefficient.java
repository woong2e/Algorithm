package DynamicProgramming;

import java.util.Scanner;

public class BinomialCoefficient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCase = sc.nextInt();

        for (int i = 0; i < numTestCase; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] biCoefficient = new int[n+1][n+1];
            System.out.println(inputBiCoefficient(biCoefficient, n, k));
        }
    }

    public static int inputBiCoefficient(int[][] arr, int n, int k) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) {
                    arr[i][j] =  1;
                } else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }

        return arr[n][k];
    }
}
