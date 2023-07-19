package SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class 중복_확인_해설 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(n, arr));
    }

    static String solution(int n, int[] arr) {
        String answer = "U";
        // 배열을 정렬해서 푸는방법도 있다 -> 시간 복잡도 O(n log n)
        Arrays.sort(arr);

        for (int i=0; i<n-1; i++) {
            if (arr[i] == arr[i+1]) {
                return "D";
            }
        }

        return answer;
    }
}
