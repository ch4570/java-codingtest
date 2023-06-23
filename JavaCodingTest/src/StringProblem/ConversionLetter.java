package StringProblem;

import java.util.Scanner;

/*
 *  대소문자 변환 문제
 * */
public class ConversionLetter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자를 입력받고, Character 배열로 변환
        char[] words = sc.next().toCharArray();

        System.out.println(solution(words));
    }

    static String solution(char[] words) {
        for (int i=0; i<words.length; i++) {

            // 문자가 소문자 -> 대문자로, 대문자 -> 소문자로 변환
            if (Character.isLowerCase(words[i])) {
                words[i] = Character.toUpperCase(words[i]);
            } else {
                words[i] = Character.toLowerCase(words[i]);
            }
        }

        return new String(words);
    }
}
