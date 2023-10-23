package onlineJudge.backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의_부모_찾기_11725 {

    static int[] answer;
    static boolean visit[];
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void solution() {
        visit[1] = true;
        List<Integer> graphList = graph.get(1);

        for (int i=0; i<graphList.size(); i++) {
            DFS(graphList.get(i), 1);
        }
    }

    static void DFS(int node, int prevNode) {
        answer[node] = prevNode;
        visit[node] = true;
        List<Integer> graphList = graph.get(node);

        for (int i=0; i<graphList.size(); i++) {
            if (!visit[graphList.get(i)]) DFS(graphList.get(i), node);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        visit = new boolean[nodeCount + 1];
        answer = new int[nodeCount + 1];

        for (int i=0; i<=nodeCount; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i=1; i<nodeCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        br.close();
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i=2; i<answer.length; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
