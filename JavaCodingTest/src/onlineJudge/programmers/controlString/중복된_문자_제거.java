package onlineJudge.programmers.controlString;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class 중복된_문자_제거 {

    public static void main(String[] args) {
        System.out.println(solution("We arthwold"));
    }

    static String solution(String s) {
        String answer = "";

        Set<Character> set = new LinkedHashSet<>();

        for (int i=0; i<s.length(); i++) {
            set.add(s.charAt(i));
        }

        Iterator<Character> iterator = set.iterator();

        while (iterator.hasNext()) {
            answer += iterator.next();
        }

        return answer;
    }
}
