package DynamicProgramming;

import java.util.Scanner;

public class MinCoinExchange {
    private static final int[] coins = {1, 5, 10, 21, 25};
    private static final int numDiffCoins = coins.length;
    private static int[] coinsUsed;
    private static int[] lastCoin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCase = sc.nextInt();

        for (int i = 0; i < numTestCase; i++) {
            int change = sc.nextInt();
            coinsUsed = new int[change+1];
            lastCoin = new int[change+1];
            coinExchange(change);
            System.out.println(coinsUsed[change]);
            reconstruct(change);
            System.out.println();
        }
    }

    public static void coinExchange(int change) {
        coinsUsed[0] = 0;
        lastCoin[0] = 0;

        int minCoins;
        int newCoin;

        for (int cents = 1; cents <= change; cents++) {
            minCoins = cents;
            newCoin = 1;
            for (int i = 0; i<numDiffCoins; i++) {
                if (coins[i] > cents) {
                    continue;
                }
                if (coinsUsed[cents - coins[i]] + 1 < minCoins) {
                    minCoins = coinsUsed[cents - coins[i]] + 1;
                    newCoin = coins[i];
                }
                coinsUsed[cents] = minCoins;
                lastCoin[cents] = newCoin;
            }
        }
    }

    public static void reconstruct(int change) {
        if (change > 0) {
            reconstruct(change - lastCoin[change]);
            System.out.printf("%d ", lastCoin[change]);
        }
    }
}
