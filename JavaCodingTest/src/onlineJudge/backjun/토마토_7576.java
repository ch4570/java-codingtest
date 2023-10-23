package onlineJudge.backjun;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7576 {

    static Queue<Integer> Q = new LinkedList<>();
    static int answer = Integer.MIN_VALUE;
    static int N, M;
    static int[][] tomatoMap;
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        BFS();
        output();
    }

    static void BFS() {

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int i=0; i<4; i++) {
                int nx = x + directionX[i];
                int ny = y + directionY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && tomatoMap[nx][ny] == 0) {
                    tomatoMap[nx][ny] = tomatoMap[x][y] + 1;
                    Q.add(nx);
                    Q.add(ny);
                }
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        M = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());

        tomatoMap = new int[N][M];

        for (int i=0; i<N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                tomatoMap[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (tomatoMap[i][j] == 1) {
                    Q.add(i);
                    Q.add(j);
                }
            }
        }

        br.close();
    }

    static void output() throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i=0; i<tomatoMap.length; i++) {
            for (int j=0; j<tomatoMap[i].length; j++) {
                if (tomatoMap[i][j] == 0) {
                    bw.write(String.valueOf(-1));
                    bw.flush();
                    bw.close();
                    return;
                }

                answer = Math.max(answer, tomatoMap[i][j]);
            }
        }

        bw.write(String.valueOf(answer - 1));
        bw.flush();
        bw.close();
    }
}
