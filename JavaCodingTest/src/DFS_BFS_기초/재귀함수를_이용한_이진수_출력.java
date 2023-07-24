package DFS_BFS_기초;

import java.util.Scanner;

public class 재귀함수를_이용한_이진수_출력 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DFS(n);
    }

    static void DFS(int n) {
        if (n == 0) return;

        DFS(n / 2);
        System.out.print(n % 2);

    }
}
