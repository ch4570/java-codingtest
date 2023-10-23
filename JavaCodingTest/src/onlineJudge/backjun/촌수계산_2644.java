package onlineJudge.backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산_2644 {

    static int from, to;
    static int answer = -1;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        input();
        visit[from] = true;
        DFS(from, 0);
        output();
    }

    static void DFS(int start, int depth) {
        if (start == to) {
            answer = depth;
            return;
        }


        List<Integer> graphList = graph.get(start);

        for (int i=0; i<graphList.size(); i++) {
            if (!visit[graphList.get(i)]) {
                visit[graphList.get(i)] = true;
                DFS(graphList.get(i), depth + 1);
                visit[graphList.get(i)] = false;
            }
        }
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int personCount = Integer.parseInt(br.readLine());

        for (int i=0; i<=personCount; i++) {
            graph.add(new ArrayList<>());
        }

        visit = new boolean[personCount + 1];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        from = Integer.parseInt(tokenizer.nextToken());
        to = Integer.parseInt(tokenizer.nextToken());

        int graphCount = Integer.parseInt(br.readLine());

        for (int i=0; i<graphCount; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }
    }
}
