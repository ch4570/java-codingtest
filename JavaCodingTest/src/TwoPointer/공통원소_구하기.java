package TwoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 공통원소_구하기 {

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

        List<Integer> answerList = solution(arr1, arr2);

        for (int number : answerList) {
            System.out.print(number + " ");
        }
    }

    static List<Integer> solution(int[] arr1, int[] arr2) {

        List<Integer> answerList = new ArrayList<>();

        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    answerList.add(arr1[i]);
                }
            }
        }

        Collections.sort(answerList);

        return answerList;
    }
}
