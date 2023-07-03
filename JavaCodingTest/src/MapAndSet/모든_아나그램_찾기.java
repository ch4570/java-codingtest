package MapAndSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 모든_아나그램_찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(solution(s1, s2));
    }

    static int solution(String s1, String s2) {
        Map<Character, Integer> charMap = new HashMap<>();
        Map<Character, Integer> anaMap = new HashMap<>();
        int answer = 0;

        for (char ch : s2.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        for (int i=0; i<s2.length() - 1; i++) {
            anaMap.put(s1.charAt(i), anaMap.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int lt = 0;
        for (int rt=s2.length() - 1; rt<s1.length(); rt++) {
            anaMap.put(s1.charAt(rt), anaMap.getOrDefault(s1.charAt(rt), 0) + 1);
            if (anaMap.equals(charMap)) {
                answer++;
            }

            anaMap.put(s1.charAt(lt), anaMap.get(s1.charAt(lt)) - 1);
            if (anaMap.get(s1.charAt(lt)) == 0) {
                anaMap.remove(s1.charAt(lt));
            }
            lt++;
        }

        return answer;
    }
}
