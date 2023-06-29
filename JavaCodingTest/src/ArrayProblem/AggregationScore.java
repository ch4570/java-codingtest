package ArrayProblem;

import java.util.Scanner;

/*
*   시험 점수 채점 문제
*   -> 연속적으로 정답일 경우 가산점 1점씩 부여
* */
public class AggregationScore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int[] answerArr = new int[number];

        for (int i=0; i<number; i++) {
            answerArr[i] = sc.nextInt();
        }

        System.out.println(solution(answerArr));
    }

    // 내 풀이
    static int solution(int[] answerArr) {

        int score = 0;
        int result = 0;

        for (int i=0; i<answerArr.length; i++) {
            if (answerArr[i] == 1) {
                score++;
            } else {
                score = 0;
            }
            result += score;
        }

        return result;
    }

    // 강의 풀이
    static int solution2(int[] arr, int n) {
        int answer = 0, cnt = 0;

        for (int i=0; i<n; i++) {
            if (arr[i] == 1) {
                cnt++;
                answer += cnt;
            } else {
                cnt = 0;
            }
        }

        return answer;
    }


}
