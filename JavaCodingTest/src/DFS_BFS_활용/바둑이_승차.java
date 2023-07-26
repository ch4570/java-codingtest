package DFS_BFS_활용;

import java.util.Scanner;

public class 바둑이_승차 {
    static int C ,N,answer = 0;
    static boolean flag = false;

    static void DFS(int L, int sum, int[] arr) {
        if (flag) return;
        if (sum > C) return;
        // L(깊이)가 N(최대 수열의 길이)와 같아야 부분집합이 완성 된 것
        if (L == N) {
            answer = Math.max(sum, answer);
        } else {
            DFS(L+1, sum, arr);
            DFS(L+1, sum+arr[L], arr);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        N = sc.nextInt();
        int[] arr = new int[N];


        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0, 0, arr);

        System.out.println(answer);
    }
}
