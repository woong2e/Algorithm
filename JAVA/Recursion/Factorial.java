package Recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){
        int numTestCases;
        Scanner sc = new Scanner(System.in);
        numTestCases = sc.nextInt();

        for (int i = 0; i < numTestCases; ++i){
            int num = sc.nextInt();
            System.out.println(factorial(num)%1000);
        }
    }

    public static int factorial(int n){
        if(n<=1){
            return 1;
        }else{
            return zeroDel(n*factorial(n-1));
        }
    }

    public static int zeroDel(int n){
        if(n%10 != 0){
            return n % 100000 ;
        }else{
            return zeroDel(n/10);
        }
    }
}
