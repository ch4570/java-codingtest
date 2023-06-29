package ArrayProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
*   피보나치 수열 문제
*   -> 주어진 숫자에 맞는 피보나치 수열을 생성해서 출력한다.
* */
public class FibonacciSequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        List<Integer> answer = solution(number);

        for (int result : answer) {
            System.out.print(result + " ");
        }
    }

    static List<Integer> solution(int number) {
        List<Integer> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(1);
        fibonacciNumbers.add(1);

        for (int i=0; i<number-2; i++) {
            fibonacciNumbers.add(fibonacciNumbers.get(i) + fibonacciNumbers.get(i+1));
        }



        return fibonacciNumbers;
    }

    // 강의 풀이
    static int[] solution2(int n) {
        int[] answer = new int[n];

        answer[0] = 1;
        answer[1] = 1;

        for (int i=2; i<n; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }

        return answer;
    }
}
