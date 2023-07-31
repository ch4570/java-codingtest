package DFS_BFS_활용;

import java.util.Scanner;

public class 중복순열_구하기 {

    static int N, M;
    static int[] pm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        pm = new int[M];

        DFS(0);
    }

    // 내 풀이
    static void DFS(int L) {
        if (L == M) {
            for (int x : pm) System.out.print(x  + " ");
            System.out.println();
            return;
        }

        for (int i=1; i<=N; i++) {
            pm[L] = i;
            DFS(L+1);
        }
    }
}
