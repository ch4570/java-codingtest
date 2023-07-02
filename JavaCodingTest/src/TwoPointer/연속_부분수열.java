package TwoPointer;

import java.util.Scanner;

public class 연속_부분수열 {
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
        int lt = 0;
        int rt = 0;
        int sum = arr[rt];
        int answer = 0;
        while (lt < a && rt < a) {

            // 같을때
            if (sum == b) {
                // 카운팅 변수 증가
                answer++;
                sum = sum - arr[lt++];
                // sum의 범위가 초과 했을때
            } else if(sum > b) {
                lt++;
                rt = lt;
                sum = arr[rt];
            } else {
                rt++;
                if (rt != a) {
                    sum += arr[rt];
                }
            }
        }

        return answer;
    }
}
