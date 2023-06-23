package StringProblem;

import java.util.Scanner;

/*
*   문자 찾기 문제
* */
public class FindLetter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 문자열 입력 받는다.
        String sentence = in.next();
        // 찾을 문자(한개)를 입력 받는다.
        String word = in.next();

        solution(sentence, word);
    }

    static void solution(String sentence, String word) {
        // 문자의 등장 횟수를 담는 카운트 변수
        int count = 0;

        //
        for (int i=0; i<sentence.length(); i++) {
            if (String.valueOf(sentence.charAt(i)).equalsIgnoreCase(word)) {
                count++;
            }
        }
        System.out.println(count);
    }
}