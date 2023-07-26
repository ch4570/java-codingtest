package DFS_BFS_기초;

import java.util.Scanner;

public class 경로_탐색_인접행렬 {

    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1];
        ch = new int[n+1];

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a][b] = 1;
        }

        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }

    static void DFS(int v) {
        if (v == n) {
            answer++;
            return;
        }

        for (int i=1; i<=n; i++) {
            if (graph[v][i] == 1 && ch[i] == 0) {
                ch[i] = 1;
                DFS(i);
                ch[i] = 0;
            }
        }


    }


}
