package Recursion;

import java.util.Scanner;

public class NarayanaPandit {
    private static boolean R;
    private static int I;
    private static int J;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();
        for (int i = 0; i < TestCase; i++) {
            int len = sc.nextInt();
            String s = sc.next();
            findNextPermutation(s,len-1);
        }
    }

    public static void findNextPermutation(String s,int idx) {
        R = false;
        I = 0;
        if (idx == 0) {
            System.out.println(s);
        } else {
            findRij(s, idx);
        }
    }

    public static void findRij(String s,int idx) {
        char[] c = s.toCharArray();
        if (!R) {
            if (idx >0 && c[idx]<c[idx-1]) {
                findRij(s, idx-1);
            } else {
                if (idx == 0) {
                    reverseString(c, I, s.length()-1);
                    String np  = new String(c);
                    System.out.println(np);
                } else {
                    R = true;
                    I = idx-1;
                    findRij(s, idx);
                }
            }
        } else {
            if (idx < s.length() && c[idx]>c[I]) {
                findRij(s, idx+1);
            } else {
                J = idx-1;
                swap(c,I,J);
                reverseString(c, I+1, s.length()-1);
                String np = new String(c);
                System.out.println(np);
            }
        }
    }

    public static void reverseString(char c[], int i, int j){
        if(i < j){
            swap(c, i, j);
            reverseString(c, i+1, j-1);
        }
    }

    public static void swap(char a[], int m, int n){
        char tmp = a[m];
        a[m] = a[n];
        a[n] = tmp;
    }
}
