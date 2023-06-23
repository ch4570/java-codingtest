package StringProblem;

import java.util.Scanner;

/*
*   회문 문자열 판단문제
*   영어 대소문자에 상관없이 앞으로 읽어도 같고 뒤로 읽어도 같은
*   회문 문자열인지 판단하는 문제
* */
public class JudgeIsPalindromeString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        solution(word);
    }

    static void solution(String word) {

        int lt = 0;
        int gt = word.length() - 1;

        // 회문 문자열인지 판단하는 flag 변수의 기본 값을 true로 설정
        boolean isTrue = true;

        while (lt < gt) {

            /*
            *   대소문자 비교를 위해서 모두 소문자로 변환 후, 같은 문자인지 비교한다.
            *   ex) taraT -> 회문 문자열
            *   ex) tataa -> 회문 문자열이 아니다.
            * */
            if (!(Character.toLowerCase(word.charAt(lt)) == Character.toLowerCase(word.charAt(gt)))) {
                // 앞과 뒤에서 서로 쌍을 이뤄 비교했을때 한번이라도 불일치하면 회문 문자열이 아니다.
                isTrue = false;
            }

            lt++;
            gt--;
        }

        // Flag 변수의 값에 따라서 결과를 출력한다.
        String result = isTrue ? "YES" : "NO";

        System.out.println(result);
    }
}
