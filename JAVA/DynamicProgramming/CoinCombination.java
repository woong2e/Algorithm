package DynamicProgramming;

import java.util.Scanner;

public class CoinCombination {
    public static final int MAX_COINS = 101;
    public static final int MAX_CHANGE = 1001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCase = sc.nextInt();

        for (int i = 0; i < numTestCase; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[] coins = new int[n+1];
            for (int j = 1; j < n+1; j++) {
                coins[j] = sc.nextInt();
            }
            int[][] coinsCombination = new int[MAX_COINS][MAX_CHANGE];
            System.out.println(countCoinExchange(coinsCombination, coins, k, n));
        }
    }

    public static int countCoinExchange(int[][] arr, int[] coins, int change, int numDiffCoins) {
        int numComb;
        for (int i = 1; i <= numDiffCoins; i++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i <= change; i++) {
            arr[0][i] = 0;
        }

        for (int i = 1; i <=numDiffCoins; i++) {
            for (int j = 1; j <= change; j++) {
                if (j - coins[i] < 0) {
                    numComb = 0;
                } else {
                    numComb = arr[i][j - coins[i]];
                }
                arr[i][j] = arr[i-1][j] + numComb;
            }
        }

        return arr[numDiffCoins][change];
    }
}
