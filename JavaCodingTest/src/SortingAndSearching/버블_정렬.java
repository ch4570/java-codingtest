package SortingAndSearching;

import java.util.Scanner;

public class 버블_정렬 {

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

    static int[] solution(int n, int[] arr) {

        /*
        *   문제 해결 아이디어
        *   1. 이웃한 두 원소를 비교해서 뒤쪽으로 밀어낸다 -> 버블 정렬
        * */
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        return arr;
    }
}
