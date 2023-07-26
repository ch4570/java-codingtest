package DFS_BFS_기초;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그래프_최단거리_BFS {

    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        ch = new int[n+1];
        dis = new int[n+1];

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b= sc.nextInt();

            graph.get(a).add(b);
        }

        BFS(1);
        for (int i=2; i<=n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;

        queue.offer(v);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int nv : graph.get(currentVertex)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[currentVertex] + 1;
                }
            }
        }
    }


}
