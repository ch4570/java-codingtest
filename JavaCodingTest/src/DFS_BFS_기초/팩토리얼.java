package DFS_BFS_기초;

import java.util.Scanner;

public class 팩토리얼 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(DFS(n));
    }

    static int DFS(int n) {
        if (n == 1) return 1;
        return n * DFS(n - 1);
    }
}
