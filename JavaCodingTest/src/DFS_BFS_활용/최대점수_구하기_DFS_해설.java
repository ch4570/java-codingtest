package DFS_BFS_활용;

import java.util.Scanner;

public class 최대점수_구하기_DFS_해설 {

    static int answer = Integer.MIN_VALUE;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }

    static void DFS(int L, int sum, int time, int[] ps, int[] pt) {
        if (time > m) return;
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L+1, sum+ps[L], time+pt[L], ps, pt);
            DFS(L+1, sum, time, ps, pt);
        }
    }
}
