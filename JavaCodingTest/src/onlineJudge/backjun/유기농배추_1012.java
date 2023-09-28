package onlineJudge.backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 유기농배추_1012 {

    static List<Integer> answer = new ArrayList<>();
    static List<Object> mapList = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void solution() {
        for (int i=0; i<mapList.size(); i++) {
            answer.add(0);
            int[][] map = (int[][]) mapList.get(i);
            int maxWidth = map.length;
            int maxHeight = map[0].length;

            for (int k=0; k<map.length; k++) {
                for (int n=0; n<map[k].length; n++) {
                    if (map[k][n] == 1) {
                        answer.set(i, answer.get(i) + 1);
                        DFS(k, n, maxWidth, maxHeight, map);
                    }
                }
            }
        }
    }

    static void DFS(int k, int n, int maxWidth, int maxHeight, int[][] map) {

        map[k][n] = 0;

        for (int i=0; i<4; i++) {
            int kx = k + directionX[i];
            int nx = n + directionY[i];

            if (kx >= 0 && kx < maxWidth && nx >= 0 && nx < maxHeight && map[kx][nx] == 1) {
                DFS(kx, nx, maxWidth, maxHeight, map);
            }
        }
    }

    static void input() throws IOException {
        int caseCount = Integer.parseInt(br.readLine());

        for (int i=0; i<caseCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(tokenizer.nextToken());
            int height = Integer.parseInt(tokenizer.nextToken());
            int pinCount = Integer.parseInt(tokenizer.nextToken());

            int[][] map = new int[width][height];

            for (int j=0; j<pinCount; j++) {
                tokenizer = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                map[x][y] = 1;
            }

            mapList.add(map);
        }
    }

    static void output() throws IOException {
        for (int i=0; i<answer.size(); i++) {
            bw.write(String.valueOf(answer.get(i)));
            bw.write("\n");
        }

        bw.flush();
    }
}
