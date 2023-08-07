package DFS_BFS_활용;

import java.util.Scanner;

public class 최대점수_구하기_DFS {
    static int N, M, answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        Problem[] arr = new Problem[N];

        for (int i=0; i<N; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            arr[i] = new Problem(score, time);
        }

        DFS(0, 0, 0, arr);

        System.out.println(answer);
    }

    static void DFS(int L, int scoreSum, int timeSum, Problem[] arr) {
        if (timeSum > M) return;
        if (L == N) {
            answer = Math.max(scoreSum, answer);
        } else {
            DFS(L+1, scoreSum+arr[L].score, timeSum+arr[L].time, arr);
            DFS(L+1, scoreSum, timeSum, arr);
        }
    }
}

class Problem {
    int score;
    int time;

    public Problem(int score, int time) {
        this.time = time;
        this.score = score;
    }
}
