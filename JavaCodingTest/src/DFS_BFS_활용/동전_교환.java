package DFS_BFS_활용;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class 동전_교환 {

    static int N, M, ANSWER = Integer.MAX_VALUE;
    static Integer[] COIN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        COIN = new Integer[N];

        String[] arr = br.readLine().split(" ");

        for (int i=0; i<arr.length; i++) {
            COIN[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(COIN, Collections.reverseOrder());

        M = Integer.parseInt(br.readLine());

        DFS(0, 0);

        bw.write(String.valueOf(ANSWER));
        bw.flush();

        br.close();
        bw.close();
    }

    // 문제 해결 아이디어 -> 가장 큰 동전부터 소비하게 해서 트리의 깊이가 너무 깊어지지 않게 해야 시간초과를 피할 수 있다.
    static void DFS(int L, int sum) {
        if (M == sum) {
            ANSWER = Math.min(L, ANSWER);
            return;
        }
        if (L >= ANSWER) return;
        if (M < sum) return;

        for (int i=0; i<N; i++) {
            DFS(L+1, sum+COIN[i]);
        }
    }
}
