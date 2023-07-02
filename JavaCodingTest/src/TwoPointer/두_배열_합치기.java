package TwoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 두_배열_합치기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1Length = sc.nextInt();
        int[] arr1 = new int[arr1Length];

        for (int i=0; i<arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int arr2Length = sc.nextInt();
        int[] arr2 = new int[arr2Length];

        for (int i=0; i<arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        List<Integer> answer = solution(arr1, arr2);

        for (int number : answer) {
            System.out.print(number + " ");
        }
    }

    static List<Integer> solution(int[] arr1, int[] arr2) {

        // 두 배열의 길이를 합친 정답 리스트 생성
        List<Integer> answerList = new ArrayList<>();

       for (int number : arr1) {
           answerList.add(number);
       }

       for (int number : arr2) {
           answerList.add(number);
       }

       // 정렬을 진행하면 O(n log n)의 시간 복잡도를 가지게 된다
        Collections.sort(answerList);

       return answerList;
    }
}
