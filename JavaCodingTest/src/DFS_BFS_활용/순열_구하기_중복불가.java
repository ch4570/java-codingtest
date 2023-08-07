package DFS_BFS_활용;

import java.util.Scanner;

public class 순열_구하기_중복불가 {

    static int[] NUM_ARR, CHECK_ARR, ANSWER;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        ANSWER = new int[M];
        NUM_ARR = new int[N];
        CHECK_ARR = new int[N];

        for (int i=0; i<N; i++) {
            NUM_ARR[i] = sc.nextInt();
        }

        DFS(0);
    }

    static void DFS(int L) {
        if (L == M) {
            for (int x : ANSWER) System.out.print(x + " ");
            System.out.println();
            return;
        }

        for (int i=0; i<N; i++) {
            if (CHECK_ARR[i] == 0) {
                CHECK_ARR[i] = 1;
                ANSWER[L] = NUM_ARR[i];
                DFS(L+1);
                CHECK_ARR[i] = 0;
            }


        }
    }
}
