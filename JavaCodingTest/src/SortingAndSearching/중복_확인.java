package SortingAndSearching;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 중복_확인 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }

    static String solution(int[] arr) {

        // Set을 이용한 풀이(내풀이) -> 시간 복잡도 O(n)
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<arr.length; i++) {
            set.add(arr[i]);
        }

        return set.size() == arr.length ? "U" : "D";
    }
}
