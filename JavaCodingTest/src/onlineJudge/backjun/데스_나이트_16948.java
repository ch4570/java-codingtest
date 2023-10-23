package onlineJudge.backjun;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 데스_나이트_16948 {

    static int N;
    static int[][] map;
    static Queue<Integer> nightQ = new LinkedList<>();
    static Queue<Integer> finalQ = new LinkedList<>();

    static int[] directionX = {-2, -2, 0, 0, 2, 2};
    static int[] directionY = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        input();
        BFS();
        output();
    }

    static void BFS() {

        while (!nightQ.isEmpty()) {
            int x = nightQ.poll();
            int y = nightQ.poll();

            for (int i=0; i<6; i++) {
                int nx = x + directionX[i];
                int ny = y + directionY[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
                    map[nx][ny] = map[x][y] + 1;
                    nightQ.offer(nx);
                    nightQ.offer(ny);
                }
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(tokenizer.nextToken());
        int c1 = Integer.parseInt(tokenizer.nextToken());

        map = new int[N][N];

        nightQ.offer(r1);
        nightQ.offer(c1);

        int r2 = Integer.parseInt(tokenizer.nextToken());
        int c2 = Integer.parseInt(tokenizer.nextToken());

        finalQ.offer(r2);
        finalQ.offer(c2);

        br.close();
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int r2 = finalQ.poll();
        int c2 = finalQ.poll();

        if (map[r2][c2] != 0) {
            bw.write(String.valueOf(map[r2][c2]));
        } else {
            bw.write(String.valueOf(-1));
        }

        bw.flush();
        bw.close();
    }
}
