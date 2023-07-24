package DFS_BFS_기초;

import java.util.Scanner;

public class 재귀_함수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DFS(n);
    }

    static void DFS(int n) {
        if (n == 0) return;

        DFS(n - 1);
        System.out.print(n + " ");
    }
}
