package SortingAndSearching;

import java.io.*;
import java.util.Arrays;

public class 마구간 {

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

        Arrays.sort(intArr);

        wr.write(String.valueOf(solution(N, K, intArr)));
        wr.flush();
        wr.close();
        br.close();
    }

    static int solution(int N, int K, int[] arr) {
        int answer = 0;
        int lt = 1;
        int rt = arr[N - 1];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= K) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }

        }

        return answer;
    }

    static int count(int[] arr, int capacity) {
        int count = 1;
        int endPosition = arr[0];

        for (int x : arr) {
            if (x - endPosition >= capacity) {
                count++;
                endPosition = x;
            }
        }

        return count;
    }
}
