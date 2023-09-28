package onlineJudge.backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 섬의_개수_4963 {

    static List<Integer> answer = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] world;
    static int[] directionX = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] directionY = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int ANSWER;

    public static void main(String[] args) throws IOException {
        solution();
        output();
    }

    static void solution() throws IOException {
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(tokenizer.nextToken());
            int h = Integer.parseInt(tokenizer.nextToken());

            world = new int[h][w];

            for (int i=0; i<h; i++) {
                tokenizer = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    world[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            DFSSolution(world);

            if (w == 0 && h == 0) break;

            answer.add(ANSWER);

            ANSWER = 0;


        }

        br.close();
    }

    static void DFSSolution(int[][] world) {


        for (int i=0; i<world.length; i++) {
            for (int j=0; j<world[i].length; j++) {
                if (world[i][j] == 1) {
                    ANSWER++;
                    DFS(i, j, world, world.length, world[i].length);
                }
            }
        }
    }

    static void DFS(int w, int y, int[][] world, int maxHeight, int maxWidth) {
        world[w][y] = 0;
        for (int i=0; i<8; i++) {
            int newW = w + directionX[i];
            int newY = y + directionY[i];

            if (newW >= 0 && newW < maxHeight && newY >= 0 && newY < maxWidth && world[newW][newY] == 1) {
                DFS(newW, newY, world, maxHeight, maxWidth);
            }
        }
    }

    static void output() throws IOException {
        for (int x : answer) {
            bw.write(String.valueOf(x));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
