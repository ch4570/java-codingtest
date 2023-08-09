package DFS_BFS_활용;

import java.util.Scanner;

public class 섬나라_아일랜드 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int n, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {

                arr[i][j] = sc.nextInt();
            }
        }

        solution(arr);

        System.out.print(answer);
    }

    static void DFS(int x, int y, int [][] board) {
        for (int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx, ny, board);
            }
        }
    }

    static void solution(int[][] board) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    // 출발점을 0으로 바꿔준뒤에 DFS 수행 -> 출발점이 1로 되어있으면 안된다.
                    board[i][j] = 0;
                    DFS(i, j, board);
                }
            }
        }
    }
}
