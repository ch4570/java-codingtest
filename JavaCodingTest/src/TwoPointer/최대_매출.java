package TwoPointer;

import java.util.Scanner;

public class 최대_매출 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int day = sc.nextInt();
        int option = sc.nextInt();

        int[] arr = new int[day];

        for (int i=0; i<day; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr, day, option));
    }

    // 이중 for 문 -> 시간 초과
    static int solution(int[] arr, int day, int option) {

        // 현재 위치를 잡을 포인터를 지정
        int pointer = 0;

        int answer = 0;

        while (pointer + option < day) {
            int max = 0;
            for (int i=pointer; i<pointer + option; i++) {
                max += arr[i];
            }

            if (max > answer) {
                answer = max;
            }

            pointer++;
        }

        return answer;
    }
}
