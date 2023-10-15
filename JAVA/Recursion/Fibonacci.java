package Recursion;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        int numTestCases;
        Scanner sc = new Scanner(System.in);
        numTestCases = sc.nextInt();

        for (int i = 0; i < numTestCases; ++i){
            int num = sc.nextInt();
            System.out.println(fibonacci(num));
        }
    }

    public static int fibonacci(int n){
        if(n<=1){
            return n;
        }else{
            return fibonacci(n-2)+fibonacci(n-1);
        }
    }
}
