package SortingAndSearching;

import java.util.Scanner;

public class 선택_정렬 {

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
        *   1. idx 변수를 활용해서 가장 작은 값을 찾아 현재 i 인덱스의 원소와 교환한다.
        *   2. i 값이 증가하면서 각 원소가 오름차순으로 자리를 잡게 만들어준다.
        * */
        for (int i=0; i<n-1; i++) {
            int idx = i;
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        return arr;
    }
}
