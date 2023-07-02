package TwoPointer;

import java.util.Scanner;

public class 연속_부분수열_해설 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b =  sc.nextInt();

        int[] arr = new int[a];

        for (int i=0; i<a; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(a, b, arr));
    }

    static int solution(int a, int b, int[] arr) {
        int answer = 0, sum = 0, lt = 0;

        for (int rt=0; rt<a; rt++) {
            sum += arr[rt];

            if (sum == b) {
                answer++;
            }

            while (sum >= b) {
                sum -= arr[lt++];
                if (sum == b) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
