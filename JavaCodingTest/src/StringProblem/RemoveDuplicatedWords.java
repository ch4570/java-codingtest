package StringProblem;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
*   문자의 중복을 제거하는 문제
* */
public class RemoveDuplicatedWords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        solution(next);
    }

    // 내풀이 -> LinkedHashSet을 이용한 순서유지 중복제거 방문
    static void solution(String word) {
        // 문자를 char 배열로 반환
        char[] words = word.toCharArray();

        // 순서 유지를 위해 LinkedHashSet을 생성
        Set<Character> characters = new LinkedHashSet<>();

        // Set에 문자를 순서대로 넣어준다(이미 중복된 문자는 안들어가서 자동으로 중복이 제거된다)
        for (char ch : words) {
            characters.add(ch);
        }


        StringBuilder sb = new StringBuilder();

        // 중복이 제거된 Set에서 문자를 꺼내서 넣어준다.
        for (char ch : characters) {
            sb.append(ch);
        }


        System.out.println(sb);
    }

    // indexOf를 이용한 풀이
    static void solution2(String word) {

        StringBuilder sb = new StringBuilder();

        /*
        *  indexOf는 문자열에서 가장 먼저 등장하는 단어를 기준으로 인덱스 위치를 반환해주기 때문에,
        *  현재 위치(i)와 indexOf가 반환하는 위치가 다르다면 중복 문자열로 판단할 수 있다.
        * */
        for (int i=0; i<word.length(); i++) {
            if (word.indexOf(word.charAt(i)) == i) {
                sb.append(word.charAt(i));
            }
        }

        System.out.println(sb);
    }
}
