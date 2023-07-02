package onlineJudge.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의_합_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");

        int number = Integer.parseInt(arr[0]);
        int number2 = Integer.parseInt(arr[1]);

        int[] numArr = new int[number];

        for (int i=0; i<number; i++) {
            numArr[i] = Integer.parseInt(arr2[i]);
        }


        int lt = 0;
        int rt = 0;
        int sum = numArr[rt];
        int answer = 0;

        while (lt < number && rt <number) {

            if (sum == number2) {
                answer++;
                sum = sum + numArr[rt++]
            }

            if (sum < number2) {
               if (!(rt + 1 == number)) {
                   rt++;
                   sum += numArr[rt] - numArr[lt];
               }
            }
        }
    }
}
