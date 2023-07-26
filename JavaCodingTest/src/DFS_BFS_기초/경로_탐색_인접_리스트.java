package DFS_BFS_기초;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 경로_탐색_인접_리스트 {

    static int n, m, answer = 0;
    static List<List<Integer>> graph;
    static int[] ch;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        ch = new int[n+1];

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
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

        for (int nv : graph.get(v)) {
            if (ch[nv] == 0) {
                ch[nv] = 1;
                DFS(nv);
                ch[nv] = 0;
            }
        }
    }
}
