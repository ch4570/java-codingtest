package TwoPointer;

import java.util.Scanner;

public class 최대_매출_해설 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = new int[a];

        for (int i=0; i<a; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print(solution(a, b, arr));
    }

    static int solution(int a, int b, int[] arr) {
        // Sliding Window 알고리즘으로 해결 -> O(n)
        int answer = 0, sum = 0;

        for (int i=0; i<b; i++) {
            sum += arr[i];
        }

        answer = sum;

        for (int i=b; i<a; i++) {
            sum += (arr[i] - arr[i-b]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
