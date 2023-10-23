package onlineJudge.backjun;

import java.io.*;
import java.util.*;

public class 나이트의_이동_7562 {

    static List<Object> CHESS_MAP_LIST = new ArrayList<>();
    static List<Integer> ANSWER = new ArrayList<>();
    static List<Queue<Integer>> bfsQ = new ArrayList<>();
    static List<Queue<Integer>> pinQ = new ArrayList<>();
    static int caseCnt;

    static int[] directionX = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] directionY = {-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }


    static void solution() {

        for (int i=0; i<caseCnt; i++) {
            int[][] map = (int[][]) CHESS_MAP_LIST.get(i);

            Queue<Integer> Q = bfsQ.get(i);

            Queue<Integer> finalQ = pinQ.get(i);
            int finalX = finalQ.poll();
            int finalY = finalQ.poll();

            int cnt = 0;

            while (!Q.isEmpty()) {
                int x = Q.poll();
                int y = Q.poll();

                if (cnt == 0 && finalX == x && finalY == y) break;

                for (int j=0; j<8; j++) {
                    int nx = x + directionX[j];
                    int ny = y + directionY[j];

                    if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length && map[nx][ny] == 0) {
                        map[nx][ny] = map[x][y] + 1;
                        Q.offer(nx);
                        Q.offer(ny);
                    }
                }


                cnt++;
            }



            ANSWER.add(map[finalX][finalY]);
        }
    }



    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        caseCnt = Integer.parseInt(br.readLine());

        for (int i=0; i<caseCnt; i++) {
            int mapSize = Integer.parseInt(br.readLine());
            int[][] chessMap = new int[mapSize][mapSize];
            CHESS_MAP_LIST.add(chessMap);

            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            Queue<Integer> Q = new LinkedList<>();

            Q.offer(x);
            Q.offer(y);

            bfsQ.add(Q);

            Queue<Integer> Q2 = new LinkedList<>();

            tokenizer = new StringTokenizer(br.readLine());

            int nx = Integer.parseInt(tokenizer.nextToken());
            int ny = Integer.parseInt(tokenizer.nextToken());

            Q2.add(nx);
            Q2.add(ny);

            pinQ.add(Q2);
        }
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int x : ANSWER) bw.write(x + "\n");

        bw.flush();
        bw.close();
    }
}
