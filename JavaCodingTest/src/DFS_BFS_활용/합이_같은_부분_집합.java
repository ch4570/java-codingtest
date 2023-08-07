package DFS_BFS_활용;

import java.util.Scanner;

public class 합이_같은_부분_집합 {
    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        DFS(0, 0, arr);
        System.out.println(answer);
    }

    static void DFS(int L, int sum, int[] arr) {
        if(flag) return;
        if(sum > total / 2) return;
        if(L == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                // flag를 true로 하는 이유는 이미 답을 찾았기 때문에 나머지 재귀 함수를 확인할 필요가 없기 때문이다.
                flag = true;
            }
        } else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }


    }
}
