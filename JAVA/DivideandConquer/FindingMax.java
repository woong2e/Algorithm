package DivideConquer;

import java.util.Scanner;

public class FindingMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TestCase = sc.nextInt();
        for(int i = 0; i < TestCase; i++){
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int j = 0; j < n; j++) {
                num[j] = sc.nextInt();
            }
            System.out.println(findmaxnum(num, 0, num.length-1));
        }
    }

    public static int findmaxnum(int[] arr, int left, int right){
        int half;
        if(left == right) {
            return arr[left];
        }else{
            half = (left+right)/2;
            return Math.max(findmaxnum(arr, left, half),
                    findmaxnum(arr, half+1, right));
        }
    }
}
