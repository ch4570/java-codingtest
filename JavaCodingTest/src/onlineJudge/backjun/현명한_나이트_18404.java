package onlineJudge.backjun;

import java.io.*;
import java.util.*;

public class 현명한_나이트_18404 {

    static Queue<Integer> Q = new LinkedList<>();
    static Queue<Integer> pinQ = new LinkedList<>();
    static List<Integer> answer = new ArrayList<>();
    static int[][] map;
    static int[] directionX = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] directionY = {-1, 1, 2, 2, 1, -1, -2, -2};
    public static void main(String[] args) throws IOException {
        input();
        BFS();
        output();
    }

    static void BFS() {

        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();

            for (int i=0; i<8; i++) {
                int nx = x + directionX[i];
                int ny = y + directionY[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length && map[nx][ny] == 0) {
                    map[nx][ny] = map[x][y] + 1;
                    Q.offer(nx);
                    Q.offer(ny);
                }
            }
        }

        while (!pinQ.isEmpty()) {
            int x = pinQ.poll();
            int y = pinQ.poll();

            answer.add(map[x][y]);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        map = new int[N + 1][N + 1];

        int M = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(tokenizer.nextToken());
        int y = Integer.parseInt(tokenizer.nextToken());

        Q.offer(x);
        Q.offer(y);

        for (int i=0; i<M; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int nx = Integer.parseInt(tokenizer.nextToken());
            int ny = Integer.parseInt(tokenizer.nextToken());

            pinQ.offer(nx);
            pinQ.offer(ny);
        }

        br.close();
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int x : answer) bw.write(x + " ");
        bw.flush();
        bw.close();
    }
}
