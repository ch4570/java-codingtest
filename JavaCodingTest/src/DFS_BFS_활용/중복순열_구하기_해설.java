package DFS_BFS_활용;

import java.util.Scanner;

public class 중복순열_구하기_해설 {

    static int[] pm;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];

        DFS(0);
    }

    static void DFS(int L) {
        if (L == m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();
            return;
        }

        for (int i=1; i<=n; i++) {
            pm[L] = i;
            DFS(L + 1);
        }
    }


}
