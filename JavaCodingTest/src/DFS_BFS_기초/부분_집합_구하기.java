package DFS_BFS_기초;

import java.util.Scanner;

public class 부분_집합_구하기 {
    static int n;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch = new int[n + 1];

        DFS(1);
    }

    static void DFS(int L) {
        if (L == n+1) {
            StringBuilder builder = new StringBuilder();
            for (int i=1; i<=n; i++) {
                if (ch[i] == 1) builder.append(i).append(" ");
            }
            if (builder.length() > 0) System.out.println(builder);

            return;
        }

        // 왼쪽 -> 원소를 사용
        ch[L] = 1;
        DFS(L+1);

        // 오른쪽 -> 원소를 사용하지 않음
        ch[L] = 0;
        DFS(L+1);


    }


}
