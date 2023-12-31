package onlineJudge.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의_합_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");

        int numberCount = Integer.parseInt(arr[0]);
        int compositionNumber = Integer.parseInt(arr[1]);

        int[] numArr = new int[numberCount + 1];

        for (int i=0; i<numberCount; i++) {
            numArr[i] = Integer.parseInt(arr2[i]);
        }


        System.out.println(solution(compositionNumber, numberCount, numArr));
    }

    static int solution(int compositionNumber, int numberCount, int[] numArr) {
        int lt = 0, rt = 0, cnt = 0;
        int sum = numArr[rt];

        while (lt < numberCount && rt < numberCount) {

            if (sum == compositionNumber) {
                cnt++;
                rt++;
                sum += numArr[rt];
            } else if (sum > compositionNumber) {
                sum -= numArr[lt++];
            } else {
                rt++;
                sum += numArr[rt];
            }
        }

        return cnt;
    }
}
