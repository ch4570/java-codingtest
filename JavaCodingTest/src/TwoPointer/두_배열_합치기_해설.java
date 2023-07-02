package TwoPointer;

import java.util.ArrayList;
import java.util.Scanner;

public class 두_배열_합치기_해설 {

    static ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {

        int p1=0, p2=0;
        ArrayList<Integer> answer = new ArrayList<>();
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                // 후위증감식은 참조 후에 증가하기 때문에 이렇게 작성을 할 수 있다.
                answer.add(a[p1++]);
            } else {
                answer.add(b[p2++]);
            }
        }

        while (p1 < n) {
            answer.add(a[p1++]);
        }

        while (p2 < m) {
            answer.add(b[p2++]);
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i=0; i<a.length; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];

        for (int i=0; i<b.length; i++) {
            b[i] = sc.nextInt();
        }

        for (int x : solution(n, m, a, b)) {
            System.out.print(x + " ");
        }
    }
}
