package SortingAndSearching;

import java.io.*;
import java.util.Arrays;

public class 뮤직_비디오 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputArr = br.readLine().split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int K = Integer.parseInt(inputArr[1]);

        String[] elementArr = br.readLine().split(" ");

        int[] intArr = Arrays.stream(elementArr)
                        .mapToInt(Integer::parseInt)
                                .toArray();

        wr.write(String.valueOf(solution(N, K, intArr)));
        wr.flush();
        wr.close();
        br.close();
    }

    static int solution(int N, int K, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr)
                .max().getAsInt();
        int rt = Arrays.stream(arr)
                .sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= K) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    static int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;

        for (int x : arr) {
            if (sum + x > capacity) {
                sum = x;
                cnt++;
            } else {
                sum += x;
            }
        }

        return cnt;
    }
}
