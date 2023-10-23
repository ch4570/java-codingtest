package onlineJudge.backjun;

import java.io.*;
import java.util.*;

public class 결혼식_5567 {

    static List<List<Integer>> graph = new ArrayList<>();
    static int answer = 0;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        input();
        visit[1] = true;
        DFS(1, 0);
        output();
    }

    static void DFS(int start, int depth) {
        if (depth == 2) {
            return;
        }

        List<Integer> graphList = graph.get(start);

        for (int i=0; i<graphList.size(); i++) {
                visit[graphList.get(i)] = true;
                DFS(graphList.get(i), depth + 1);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int memberNum = Integer.parseInt(br.readLine());

        visit = new boolean[memberNum + 1];

        for (int i=0; i<=memberNum; i++) {
            graph.add(new ArrayList<>());
        }

        int graphNum = Integer.parseInt(br.readLine());

        for (int i=0; i<graphNum; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        br.close();
    }

    static void output() throws IOException {

        for (boolean isVisit : visit) {
            if (isVisit) answer++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer - 1));
        bw.flush();
        bw.close();
    }
}
