package onlineJudge.backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 바이러스_2606 {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        input();
        DFS(1);
        output();
    }

    static void DFS(int graphNum) {
        visit[graphNum] = true;

        List<Integer> graphList = graph.get(graphNum);

        for (int i=0; i<graphList.size(); i++) {
            int from = graphList.get(i);
            if (visit[from]) continue;

            DFS(from);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        visit = new boolean[computerCount + 1];
        int graphCount = Integer.parseInt(br.readLine());

        for (int i=0; i<=computerCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=1; i<=graphCount; i++) {
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
        int answer = 0;

        for (boolean isVisit : visit) {
            if (isVisit) answer++;
        }

        bw.write(String.valueOf(answer - 1));
        bw.flush();
        bw.close();
    }
}
