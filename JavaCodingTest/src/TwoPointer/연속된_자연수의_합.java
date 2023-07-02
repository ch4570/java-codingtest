package TwoPointer;

import java.util.Scanner;

public class 연속된_자연수의_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        // 연속 부분 수열로 원하는 자연수의 합으로 나타내 지는지 확인하려면 확인해야 하는 최대 값은 (N / 2 + 1) 이다.
        int[] arr = new int[number / 2 + 1];

        for (int i=0; i<arr.length; i++) {
            arr[i] = (i + 1);
        }

        System.out.println(solution(arr, number));
    }

    static int solution(int[] arr, int number) {
        int answer = 0, lt  = 0, rt = 0;
        int sum = arr[rt];

        while (lt < arr.length &&  rt < arr.length) {

            if (number == sum) {
                sum -= arr[lt++];
                answer++;
            } else if (sum > number) {
                lt++;
                rt = lt;
                sum = arr[rt];
            } else {
                rt++;
                if (!(rt == arr.length)) {
                    sum += arr[rt];
                }
            }
        }

        return answer;
    }
}
