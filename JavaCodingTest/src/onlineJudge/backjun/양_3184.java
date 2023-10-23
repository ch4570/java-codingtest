package onlineJudge.backjun;

import java.io.*;
import java.util.StringTokenizer;

public class 양_3184 {

    static int WOLF, SHEEP, ANSWER_WOLF, ANSWER_SHEEP, HEIGHT, WIDTH;
    static char[][] map;
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void solution() {

        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                if (map[i][j] != '#') {
                    DFS(i, j);
                    writeAnswer();
                }
            }
        }
    }

    static void writeAnswer() {
        if (SHEEP > WOLF) {
            WOLF = 0;
        } else {
            SHEEP = 0;
        }

        ANSWER_SHEEP += SHEEP;
        ANSWER_WOLF += WOLF;

        SHEEP = 0;
        WOLF = 0;
    }

    static void DFS(int x, int y) {
        if (map[x][y] == 'o') SHEEP++;
        if (map[x][y] == 'v') WOLF++;

        map[x][y] = '#';

        for (int i=0; i<4; i++) {
            int nx = x + directionX[i];
            int ny = y + directionY[i];

            if (nx >= 0 && nx < HEIGHT && ny >= 0 && ny < WIDTH && map[nx][ny] != '#') {
                DFS(nx, ny);
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        HEIGHT = Integer.parseInt(tokenizer.nextToken());
        WIDTH = Integer.parseInt(tokenizer.nextToken());

        map = new char[HEIGHT][WIDTH];

        for (int i=0; i<HEIGHT; i++) {
            String line = br.readLine();
            for (int j=0; j<WIDTH; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        br.close();
    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ANSWER_SHEEP));
        bw.write(" ");
        bw.write(String.valueOf(ANSWER_WOLF));
        bw.flush();

        bw.close();
    }
}
