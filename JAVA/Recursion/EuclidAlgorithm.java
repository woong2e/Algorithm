package Recursion;

import java.util.Scanner;

public class EuclidAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases;
        numTestCases = sc.nextInt();

        for (int i = 0; i < numTestCases; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(gcd(m, n));
        }
    }
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
}
