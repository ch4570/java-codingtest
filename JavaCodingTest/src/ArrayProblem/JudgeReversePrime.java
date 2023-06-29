package ArrayProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
*   뒤집혀진 소수 풀이
* */
public class JudgeReversePrime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputTime = sc.nextInt();
        int[] numArr = new int[inputTime];

        for (int i=0; i<inputTime; i++) {
            int number = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            sb.append(number);
            numArr[i] = Integer.parseInt(sb.reverse().toString());
        }
        solution(numArr);
    }

    // 내 풀이
    static void solution(int[] numArr) {
        for (int i=0; i<numArr.length; i++) {
            int divideCount = 0;

            for (int j=2; j<=numArr[i]; j++) {
                if (numArr[i] % j == 0) {
                    divideCount++;
                }
            }

            if (divideCount == 1) {
                System.out.print(numArr[i] + " ");
            }

        }
    }

    // 강의 풀이
    public List<Integer> solution() {
        Scanner sc = new Scanner(System.in);

        List<Integer> answer = new ArrayList<>();

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i=0; i<n; i++) {
            int tmp = arr[i];
            int res = 0;

            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            if (isPrime(res)) {
                answer.add(res);
            }
        }

        return answer;
    }

    static boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i=2; i<num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
