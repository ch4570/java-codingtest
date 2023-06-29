package ArrayProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
*   N * N의 격자판이 주어졌을때
*   각 행의 합, 각 열의 합, 대각선의 합 중 가장 큰 값을 출력하는 문제
* */
public class MaxSumProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[][] board = new int[num][num];

        for (int i=0; i<num; i++) {
            for (int j=0; j<board[i].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(board));

    }

    // 내 풀이
    static int solution(int[][] board) {

        // 행, 열, 대각선의 각 합을 저장할 배열을 선언한다.
        List<Integer> sumList = new ArrayList<>();

        // 행의 합 모두 구하기
        for (int i=0; i<board.length; i++) {
            int sum = 0;
            for (int j=0; j<board[i].length; j++) {
                sum += board[i][j];
            }

            sumList.add(sum);
        }

        // 열의 합 모두 구하기
        for (int i=0; i<board.length; i++) {
            int sum = 0;
            for (int j=0; j<board[i].length; j++) {
                sum += board[j][i];
            }
            sumList.add(sum);
        }

        // 오른쪽으로 가는 대각선 합 구하기
        int sum1 = 0;
        for (int i=0; i<board.length; i++) {
            sum1 += board[i][i];
        }
        sumList.add(sum1);

        // 왼쪽으로 가는 대각선 합 구하기
        int sum2 = 0;
        for (int i=board.length - 1; i>=0; i--) {
            sum2 += board[i][i];
        }
        sumList.add(sum2);

        return Collections.max(sumList);
    }

    static int solution2(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;

        for (int i=0; i<n; i++) {
            sum1 = sum2 = 0;
            for (int j=0; j<n; j++) {
                // 행의 합
                sum1 += arr[i][j];
                // 열의 합
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = sum2 = 0;

        for (int i=0; i<n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }

        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }
}
