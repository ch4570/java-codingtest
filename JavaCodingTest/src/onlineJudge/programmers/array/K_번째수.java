package onlineJudge.programmers.array;

import java.util.Arrays;

public class K_번째수 {

    public static void main(String[] args) {

        int[] array = new int[] {1, 5, 2, 6, 3, 7, 4};
        int[][] arr = new int[][]
                {
                        {2, 5, 3}, {4, 4, 1}, {1, 7, 3}
                };

        solution(array, arr);
    }

    static int[] solution(int[] array, int[][] commands) {
        // command 배열의 길이 만큼 정답 배열의 길이를 잡아준다.
        int[] answer = new int[commands.length];

        for (int i=0; i<commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int index = commands[i][2] - 1;

            int[] arr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(arr);

            answer[i] = arr[index];

        }

        return answer;
    }
}
