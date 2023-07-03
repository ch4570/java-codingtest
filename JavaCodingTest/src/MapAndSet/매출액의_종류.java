package MapAndSet;

import java.util.*;

public class 매출액의_종류 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int days = sc.nextInt();

        int[] arr = new int[count];

        for (int i=0; i<count; i++) {
            arr[i] = sc.nextInt();
        }

        for (int answer : solution(arr, days, count)) {
            System.out.print(answer + " ");
        }

    }

    static List<Integer> solution(int[] arr, int days, int count) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        int lt = 0;
        int rt = days - 1;

        for (int i=0; i<=rt; i++) {
            map.put(arr[i], map.getOrDefault(arr[i] , 0) + 1);
        }

        int size = map.size();
        answer.add(size);

        while (lt < count && rt < count) {
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            lt++;
            rt++;

            if (rt == count) break;
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
        }


        return answer;
    }
}
