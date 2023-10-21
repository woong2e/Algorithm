package Recursion;

import java.util.Scanner;

public class StringPermutation {
    public static int wnum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCase;
        TestCase = sc.nextInt();
        for(int i = 0; i<TestCase; i++){
            String s = sc.next();
            permuteString(s, 0, s.length()-1);
            System.out.println(wnum);
            wnum = 0;
        }
    }
    public static int weight(String s, int x, int y){
        int w = 0;
        char c[] = s.toCharArray();
        for(int i = x; i<=y; i++){
            w += Math.pow(-1,i)*(int)(c[i] - 'a');
        }
        return w;
    }

    public static void swap(char a[], int m, int n){
        char tmp = a[m];
        a[m] = a[n];
        a[n] = tmp;
    }

    public static void permuteString(String s, int start, int end){
        int range = end - start;
        if(range == 0){
            if(weight(s,0, s.length()-1)>0){
                wnum++;
            }
        }else{
            permuteString(s, start+1, end);
            for(int i = start;i<end; i++){
                char c[] = s.toCharArray();
                for(int j = i+1; j>start; j--){
                    swap(c,j, j-1);
                }
                String s1 = String.valueOf(c);
                permuteString(s1, start+1, end);
            }
        }
    }
}
