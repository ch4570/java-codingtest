package StringProblem;

import java.util.Scanner;

/*
*  단어 뒤집기 문제
* */
public class FlipString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받을 문자의 개수를 입력받는다.
        int inputCount = sc.nextInt();
        String[] words = new String[inputCount];

        // 입력받을 문자 개수만큼 문자를 입력 받는다.
        for (int i=0; i<inputCount; i++) {
            words[i] = sc.next();
        }

        solution(words);
    }

    /*
    *  문자를 직접 뒤집는 방식의 풀이 -> 내방식
    * */
    static void solution(String[] words) {

        for (int i=0; i<words.length; i++) {
            StringBuilder sb = new StringBuilder();
            /*
            *  문자의 순서를 거꾸로 뒤집어서 역순으로 만든다는 것은,
            *  기존 문자의 맨 뒤 문자부터 하나씩 더하면 되는 것이므로 charAt을 이용해서
            *  마지막 인덱스부터 문자열을 만들어준다.
            * */
            for (int j = words[i].length() - 1; j >= 0; j--) {
                sb.append(words[i].charAt(j));
            }
            words[i] = sb.toString();
        }

        for (String s : words) {
            System.out.println(s);
        }
    }

    /*
    *   StringBuilder의 reverse 메서드를 이용한 방법
    * */
    static void solution2(String[] words) {
        for (int i = 0; i<words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            // StringBuilder의 reverse 메서드로 문자를 역순으로 반환받을 수 있다.
            words[i] = sb.reverse().toString();
        }

        for (String s : words) {
            System.out.println(s);
        }
    }
}
