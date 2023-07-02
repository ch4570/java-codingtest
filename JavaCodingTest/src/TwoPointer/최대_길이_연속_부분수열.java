package TwoPointer;

import java.util.Scanner;

public class 최대_길이_연속_부분수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int maxChange = sc.nextInt();
        int[] arr = new int[length];


        for (int i=0; i<length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(maxChange, arr));
    }

    static int solution(int maxChange, int[] arr) {
        int lt = 0, answer = 0, cnt = 0;

        for (int rt=0; rt<arr.length; rt++) {

            // rt가 0을 만나면 바꿀 수 있는 count의 개수를 증가 시킨다.
            if (arr[rt] == 0) {
                cnt++;
            }

            while (cnt > maxChange) {
                if (arr[lt] == 0) {
                    cnt--;
                }
                lt++;
            }


            answer = Math.max(answer, rt - lt + 1);

        }

        return answer;
    }
}
