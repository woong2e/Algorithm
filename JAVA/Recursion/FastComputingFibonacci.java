package Recursion;

import java.util.Scanner;
public class FastComputingFibonacci {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();
        for(int i = 0; i < numTestCases; i++){
            int n = sc.nextInt();
            int result = cFibonacci(n);
            System.out.println(result);
        }

    }
    public static int[][] matMul(int[][] x, int[][] y){
        int[][] f = new int[2][2];
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < y.length; j++){
                for(int k = 0; k < y[0].length; k++){
                    f[i][j] += (x[i][k]%1000)*(y[k][j]%1000);
                    f[i][j] = f[i][j]%1000;
                }
            }
        }
        return f;
    }

    public static int[][] matPow(int[][] a, int n) {
        if (n <= 1) {
            return a;
        } else if (n % 2 == 0) {
            int[][] halfPow = matPow(a, n / 2);
            return matMul(halfPow, halfPow);
        } else {
            int[][] halfPow = matPow(a, (n - 1) / 2);
            return matMul(a, matMul(halfPow, halfPow));
        }
    }

    public static int cFibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        int[][] baseMatrix = {{1, 1}, {1, 0}};
        int[][] resultMatrix = matPow(baseMatrix, n - 1);
        return resultMatrix[0][0] % 1000;
    }
}
