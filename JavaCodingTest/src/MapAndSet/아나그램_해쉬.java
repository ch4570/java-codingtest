package MapAndSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class 아나그램_해쉬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));
    }

    static String solution(String s1, String s2) {

        String answer = "YES";

        Set<Character> set = new LinkedHashSet<>();
        // 아나그램 여부를 판별하기 위해 각 문자를 중복없이 Set에 저장
        for (int i=0; i<s1.length(); i++) {
            set.add(s1.charAt(i));
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for (int i=0; i<s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for (int i=0; i<s2.length(); i++) {
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (char key : set) {
            if(!s1Map.get(key).equals(s2Map.get(key))) {
                return "NO";
            }
        }

        return answer;
    }
}
