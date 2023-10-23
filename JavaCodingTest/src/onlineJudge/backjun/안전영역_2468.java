package onlineJudge.backjun;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 안전영역_2468 {


    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visit;
    static int answer = 1;
    static int N, COUNT;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void solution() {

        for (int i=1; i<=100; i++) {
            visit = new boolean[N][N];
            COUNT = 0;

            for (int j=0; j<N; j++) {
                for (int k=0; k<N; k++) {
                    if (!visit[j][k] && map[j][k] > i) {
                        visit[j][k] = true;
                        DFS(j, k, i);
                        COUNT++;
                    }
                }
            }

            answer = Math.max(answer, COUNT);
        }
    }

    static void DFS(int x, int y, int height) {

        for (int i=0; i<4; i++) {
            int nx = x + directionX[i];
            int ny = y + directionY[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny] && map[nx][ny] > height) {
                visit[nx][ny] = true;
                DFS(nx, ny, height);
            }
        }
    }




    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
