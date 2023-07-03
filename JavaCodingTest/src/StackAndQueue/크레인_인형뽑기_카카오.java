package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class 크레인_인형뽑기_카카오 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[][] board = new int[count][count];
        for (int i=0; i<count; i++) {
            for (int j=0; j<count; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int cnt = sc.nextInt();
        int[] move = new int[cnt];

        for (int i=0; i<cnt; i++) {
            move[i] = sc.nextInt();
        }

        System.out.println(solution(board, move));
    }

    static int solution(int[][] board, int[] move) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int pos : move) {
            for (int i=0; i<board.length; i++) {
                if (board[i][pos-1] != 0) {
                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;
                    if (!stack.empty() && tmp == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
