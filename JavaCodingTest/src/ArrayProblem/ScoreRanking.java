package ArrayProblem;

import java.util.*;

/*
*   N명의 학생의 국어점수를 구하는 예제
* */
public class ScoreRanking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] scoreArr = new int[num];

        for (int i=0; i<num; i++) {
            scoreArr[i] = sc.nextInt();
        }

        int[] result = solution(scoreArr, num);

        for (int answer : result) {
            System.out.print(answer + " ");
        }
    }

    // 내 풀이
    static int[] solution(int[] scoreArr, int num) {

        // 점수를 순서대로 정렬한 배열 만들기
        Integer[] reverseSortedArr = new Integer[num];
        int[] result = new int[num];

        for (int i=0; i<num; i++) {
            reverseSortedArr[i] = scoreArr[i];
        }

        // 점수 역순 정렬 -> 최대 점수 순으로
        Arrays.sort(reverseSortedArr, Collections.reverseOrder());

        for (int i=0; i<num; i++) {
            int score = scoreArr[i];
            for (int j=0; j<num; j++) {
                if (score == reverseSortedArr[j]) {
                    result[i] = (j + 1);
                    break;
                }
            }
        }

        return result;
    }

    // 강의 풀이
    static int[] solution2(int n, int[] arr) {
        int[] answer = new int[n];

        for (int i=0; i<n; i++) {
            int cnt = 1;
            for (int j=0; j<n; j++) {
                if (arr[j] > arr[i]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }
}
