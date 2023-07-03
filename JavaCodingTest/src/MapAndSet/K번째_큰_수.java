package MapAndSet;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class K번째_큰_수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cardConut = sc.nextInt();
        int K = sc.nextInt();

        int[] cardArr = new int[cardConut];
        for (int i=0; i<cardConut; i++) {
            cardArr[i] = sc.nextInt();
        }

        System.out.println(solution(cardArr, K, cardConut));
    }

    static int solution(int[] arr, int K, int cardCount) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int answer = -1;

        /*
        *   카드를 3장 뽑을 때 조합하는 방법 -> K개 일때는 K개의 for문
        * */
        for (int i=0; i<cardCount; i++) {
            for (int j=i+1; j<cardCount; j++) {
                for (int p=j+1; p<cardCount; p++) {
                    set.add(arr[i] + arr[j] + arr[p]);
                }
            }
        }

        int count = 0;

        for (int x : set) {
            count++;
            if (count == K) {
                return x;
            }
        }
        return answer;
    }
}
