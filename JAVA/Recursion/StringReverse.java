package Recursion;

import java.util.Scanner;

public class StringReverse {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int numTestCases = sc.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            String s = sc.next();
            char[] c = s.toCharArray();
            reverseString(c, 0, c.length-1);
            s = new String(c);
            System.out.println(s);
        }
    }
    public static void swap(char c[], int k, int m){
        char tmp = c[k];
        c[k] = c[m];
        c[m] = tmp;
    }

    public static void reverseString(char c[], int i, int j){
        if(i < j){
            swap(c, i, j);
            reverseString(c, i+1, j-1);
        }
    }
}
