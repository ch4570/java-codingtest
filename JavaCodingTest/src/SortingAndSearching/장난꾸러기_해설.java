package SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 장난꾸러기_해설 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

    static List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();

        Arrays.sort(tmp);

        for (int i=0; i<n; i++) {
            if (arr[i] != tmp[i]) {
                answer.add(i+1);
            }
        }
        return answer;
    }
}
