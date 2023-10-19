package Recursion;

import java.util.Scanner;

public class FastComputingPowers {
    public static void main(String[] args){
        int numTestCases;
        Scanner sc = new Scanner(System.in);
        numTestCases = sc.nextInt();

        for (int i = 0; i < numTestCases; ++i){
            int x = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(fCP(x, n)%1000);
        }
    }

    public static int fCP(int x, int n){
        if(n == 0){
            return 1;
        }else if(n%2 == 0){
            int y = fCP(x, n/2);
            return (y*y)%1000;
        }else{
            int z = fCP(x,(n-1)/2);
            return (x*z*z)%1000;
        }
    }
}
