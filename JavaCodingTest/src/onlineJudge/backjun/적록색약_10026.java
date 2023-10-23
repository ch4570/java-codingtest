package onlineJudge.backjun;

import java.io.*;

public class 적록색약_10026 {


    static int[] answer = new int[2];
    static int semiAnswer, inputCount;
    static char[][] map, noColorMap;
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void solution() {

        for (int i=0; i<inputCount; i++) {
            for (int j=0; j<inputCount; j++) {
                if (noColorMap[i][j] == 'G') noColorMap[i][j] = 'R';
            }
        }

        for (int i=0; i<inputCount; i++) {
            for (int j=0; j<inputCount; j++) {
                if (map[i][j] != '#') {
                    semiAnswer++;
                    DFS(i, j, map);
                }
            }
        }

        answer[0] = semiAnswer;
        semiAnswer = 0;

        for (int i=0; i<inputCount; i++) {
            for (int j=0; j<inputCount; j++) {
                if (noColorMap[i][j] != '#') {
                    semiAnswer++;
                    DFS(i, j, noColorMap);
                }
            }
        }

        answer[1] = semiAnswer;

    }

    static void DFS(int x, int y, char[][] map) {

        char color = map[x][y];
        map[x][y] = '#';
        for (int i=0; i<4; i++) {


            int nx = x + directionX[i];
            int ny = y + directionY[i];

            if (nx >= 0 && nx < inputCount && ny >= 0 && ny < inputCount && color == map[nx][ny]) {
                DFS(nx, ny, map);
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputCount = Integer.parseInt(br.readLine());
        map = new char[inputCount][inputCount];
        noColorMap = new char[inputCount][inputCount];

        for (int i=0; i<inputCount; i++) {
            String line = br.readLine();
            for (int j=0; j<inputCount; j++) {
                map[i][j] = line.charAt(j);
                noColorMap[i][j] = line.charAt(j);
            }
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
