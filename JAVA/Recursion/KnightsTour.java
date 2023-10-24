package Recursion;

import java.util.Scanner;

public class KnightsTour {
    private static final int MAXSIZE = 9;
    private static final boolean MARK = true;
    private static final boolean UNMARK = false;

    private static final Point[] direction = {
            new Point(1, -2), new Point(2, -1),
            new Point(2, 1), new Point(1, 2),
            new Point(-1, 2), new Point(-2, 1),
            new Point(-2, -1), new Point(-1, -2)};

    private static boolean[][] board = new boolean[MAXSIZE][MAXSIZE];
    private static int[][] path= new int[MAXSIZE][MAXSIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();

        for (int i = 0; i < numTestCases; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int s = sc.nextInt();
            int t = sc.nextInt();
            Point start = new Point(t,s);

            for (int p = 1; p <= m; p++) {
                for (int q = 1; q <= n; q++) {
                    board[p][q] = UNMARK;
                }
            }
            board[start.y][start.x] = MARK;
            path[start.y][start.x] = 1;
            if (knightTour(m, n, start, 1)) {
                System.out.println(1);
                printTour(m,n);
            } else {
                System.out.println(0);
            }

         }
    }

    public static boolean knightTour(int m, int n, Point pos, int counter) {
        if (counter == m*n) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            Point next = new Point();
            next.x = pos.x + direction[i].x;
            next.y = pos.y + direction[i].y;

            if (next.x > 0 && next.x <= n && next.y > 0 && next.y <= m && board[next.y][next.x] != MARK) {
                board[next.y][next.x] = MARK;
                path[next.y][next.x] = counter+1;

                if(knightTour(m, n, next, counter + 1)){
                    return true;
                }
                board[next.y][next.x] = UNMARK;
            }
        }
        return false;
    }

    public static void printTour(int m, int n){
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Point {
    int x, y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
