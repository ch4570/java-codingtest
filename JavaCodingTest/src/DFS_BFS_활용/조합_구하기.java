package DFS_BFS_활용;

import java.util.Scanner;

public class 조합_구하기 {

    static int[] answer;
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        answer = new int[k];



        DFS(0, 1);
    }

    static void DFS(int L, int start) {
        if (L == k) {
            for (int x : answer) System.out.print(x + " ");
            System.out.println();
            return;
        }

        for (int i=start; i<=n; i++) {
            answer[L] = i;
            DFS(L+1, i+1);
        }


    }
}
