package DFS_BFS_활용;

import java.util.Scanner;

public class 순열_구하기_중복불가_해설 {

    static int[] pm, ch, arr;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        ch = new int[n];
        pm = new int[m];

        DFS(0);
    }

    static void DFS(int L) {
        if (L == m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();
            return;
        }

        for (int i=0; i<n; i++) {
            if (ch[i] == 0) {
                pm[L] = arr[i];
                ch[i] = 1;
                DFS(L + 1);
                ch[i] = 0;
            }
        }
    }
}
