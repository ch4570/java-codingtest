package ArrayProblem;

import java.util.Scanner;

/*
*   에라토스테네스의 체(소수 판별) 문제
* */
public class JudgePrimeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        System.out.println(solution(number));
    }


    static int solution(int n) {
        int answer = 0;
        int[] ch = new int[n+1];

        for (int i=2; i<=n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j=i; j<=n; j=j+i) {
                    ch[j] = 1;
                }
            }
        }

        return answer;
    }
}
