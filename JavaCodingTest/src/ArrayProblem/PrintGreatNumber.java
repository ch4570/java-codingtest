package ArrayProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
*   큰 수 출력하기 문제
*   -> N개의 정수를 입력받고 자신의 바로 앞 수보다 큰 수만 출력하는 문제
* */
public class PrintGreatNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        int[] numArr = new int[number];
        String[] numbers = br.readLine().split(" ");

        for (int i=0; i<numArr.length; i++) {
            numArr[i] = Integer.parseInt(numbers[i]);
        }

        solution(numArr);
    }

    // 내 풀이
    static void solution(int[] numArr) {
        StringBuilder builder = new StringBuilder();
        builder.append(numArr[0]);
        builder.append(" ");

        for (int i=1; i<numArr.length; i++) {
            if (numArr[i] > numArr[i - 1]) {
                builder.append(numArr[i]);
                builder.append(" ");
            }
        }

        System.out.println(builder);
    }

    // 강의 풀이
    static void solution2(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 첫번째 원소는 무조건 출력이므로 추가
        answer.add(arr[0]);

        for (int i=1; i<n; i++) {
            if (arr[i] > arr[i-1]) {
                answer.add(arr[i]);
            }
        }

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
