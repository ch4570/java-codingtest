package StringProblem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*   유효한 팰린드롬 문제(회문 문자열 검사)
*
*   요구사항
*   1. 회문을 검사할 때 알파벳만 이용한다(숫자나 특수문자는 무시한다)
*   2. 대문자와 소문자는 구분하지 않는다.
* */
public class IsPalindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        System.out.println(solution(word));
    }

    // 내 풀이 -> 알파벳만 뽑아서 새로운 문자열을 구성하고 비교한다.
    static String solution(String word) {

        char[] wordArr = word.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<wordArr.length; i++) {
            // 특수문자와 숫자를 무시하고 회문을 검사하므로, 알파벳인경우에만 StringBuilder에 담아준다.
            if (Character.isAlphabetic(wordArr[i])) {
                sb.append(wordArr[i]);
            }
        }

        String originalWord = sb.toString();
        String reverseWord = sb.reverse().toString();

        // 대소문자 구분 없이 회문 문자열인지 검사한 결과를 돌려준다.
        return originalWord.equalsIgnoreCase(reverseWord) ? "YES" : "NO";
    }

    // replaceAll을 이용한 풀이
    static String solution2(String word) {
        // ^[A-Z] -> 알파벳이 아니면 전부 정규식에 걸린다.
        String originalWord = word.toUpperCase().replaceAll("^[A-Z]", "");
        String reverseWord = new StringBuilder(word).reverse().toString();

        return originalWord.equals(reverseWord) ? "YES" : "NO";
    }
}
