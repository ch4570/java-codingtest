package onlineJudge.backjun;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연결_요소의_개수_11724 {

    static int M, ANSWER;
    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean visit[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void solution() {
        for (int i=1; i<=N; i++) {
            if (!visit[i]) {
                ANSWER++;
                DFS(i);
            }
        }
    }

    static void DFS(int vertex) {

        visit[vertex] = true;

        List<Integer> graphList = graph.get(vertex);

        for (int i=0; i<graphList.size(); i++) {
            int goVertex = graphList.get(i);
            if (visit[goVertex]) continue;
            DFS(goVertex);
        }
    }


    static void input() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        visit = new boolean[N + 1];
        for (int i=0; i<M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        br.close();
    }

    static void output() throws IOException {
        bw.write(String.valueOf(ANSWER));
        bw.flush();
    }
}
