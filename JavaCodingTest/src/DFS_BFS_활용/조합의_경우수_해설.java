package DFS_BFS_활용;

import java.util.Scanner;

public class 조합의_경우수_해설 {

    static int[][] dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        dy = new int[n+1][n+1];

        System.out.println(DFS(n, r));
    }

    static int DFS(int n, int r) {
        if (r == 0 || n == r) return 1;

        if (dy[n][r] != 0) {
            return dy[n][r];
        }


        return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
    }
}
