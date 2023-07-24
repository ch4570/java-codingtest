package DFS_BFS_기초;

import java.util.Scanner;

public class 피보나치_재귀 {

    static int[] fibo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n+1];
        DFS(n);

        for (int i=1; i<=n; i++) System.out.print(fibo[i] + " ");
    }

    // N번째 항의 값을 리턴받는 함수
    static int DFS(int n) {
        if (fibo[n] > 0) return fibo[n];
        if (n == 1) return fibo[n] = 1;
        else if (n == 2) return fibo[n] = 1;
        // 이미 찾아놓은 값이 있다면 탐색하지 않고 return 해서 메서드 실행 시간을 줄일 수 있다.
        // 모두 탐색해서 fibo 배열에 넣는 것보다 8배 이상 성능 향상 8초 -> 1초 미만
        return fibo[n] = DFS(n - 2) + DFS(n - 1);
    }
}
