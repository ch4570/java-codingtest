package MapAndSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램_해쉬_해설 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        System.out.println(solution(a, b));
    }


    static String solution(String s1, String s2) {
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();

        /*
        *   문제 해결 전략
        *   1. 첫번째 문자열을 Map에서 출현 빈도수를 Key-Value 형태로 저장한다.
        *   2. 두번째 문자열을 하나씩 쪼개서 Map을 순회하며 value를 1씩 감소 시킨다.
        *   3. value가 0인 상태에서 감소를 시킨다는 것은, 아나그램이 아니라는 뜻이므로 NO를 반환
        *   4. if 조건문을 만나서 필터링되지 않을 경우, 아나그램이며 YES를 반환
        * */

        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }
            map.put(x, map.get(x) - 1);
        }

        return answer;
    }
}
