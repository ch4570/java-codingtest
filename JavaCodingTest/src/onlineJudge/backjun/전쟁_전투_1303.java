package onlineJudge.backjun;

import java.io.*;
import java.util.StringTokenizer;

public class 전쟁_전투_1303 {

    static char[][] warMap;
    static int[] answer = new int[2];
    static int wCnt, bCnt, N, M, wSum, bSum;
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void solution() {

        // 내 아군 세기
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (warMap[i][j] == 'W') {
                    warMap[i][j] = 'X';
                    WDFS(i, j);
                    wSum += (wCnt * wCnt);
                    wCnt = 0;
                }
            }
        }

        answer[0] = wSum;

        // 내 아군 세기
        for (int i=0; i<M; i++) {
            for (int j=0; j<N; j++) {
                if (warMap[i][j] == 'B') {
                    warMap[i][j] = 'X';
                    BDFS(i, j);
                    bSum += (bCnt * bCnt);
                    bCnt = 0;
                }
            }
        }

        answer[1] = bSum;
    }

    static void WDFS(int x, int y) {
        wCnt++;

        for (int i=0; i<4; i++) {
            int nx = x + directionX[i];
            int ny = y + directionY[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && warMap[nx][ny] == 'W') {
                warMap[nx][ny] = 'X';
                WDFS(nx, ny);
            }
        }
    }

    static void BDFS(int x, int y) {
        bCnt++;

        for (int i=0; i<4; i++) {
            int nx = x + directionX[i];
            int ny = y + directionY[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && warMap[nx][ny] == 'B') {
                warMap[nx][ny] = 'X';
                BDFS(nx, ny);
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        warMap = new char[M][N];

        for (int i=0; i<M; i++) {
            String sentence = br.readLine();
            for (int j=0; j<N; j++) {
                warMap[i][j] = sentence.charAt(j);
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
