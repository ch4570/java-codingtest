package StringProblem;

import java.util.Scanner;

/*
*   특정 문자열 뒤집기 문제
*
*   요구사항
*   1. 앞이나 뒤의 문자가 특수문자라면 교환하지 않는다.
*   2. 앞과 뒤의 모든 문자가 알파벳일때만 문자 위치를 교환한다.
* */
public class FlipSpecificWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        solution(word);
    }

    static void solution(String word) {
        // 문자열을 문자 배열(char[])로 변환한다.
        char[] wordList = word.toCharArray();

        // 배열의 첫번째 인덱스
        int lt = 0;
        // 배열의 마지막 인덱스
        int gt = wordList.length - 1;

        while (lt < gt) {
            // 앞의 문자가(wordList[lt] 특수문자인경우 lt를 증가시킨다.
            if (!Character.isAlphabetic(wordList[lt])) {
                lt++;
            // 뒤의 문자가(wordList[gt] 특수문자인경우 gt를 감소시킨다.
            } else if(!Character.isAlphabetic(wordList[gt])) {
                gt--;
            // 앞과 뒤의 모든 문자가 알파벳일때만 위치를 교환하고, lt는 증가 gt는 감소 시킨다.
            } else {
                char temp = wordList[lt];
                wordList[lt] = wordList[gt];
                wordList[gt] = temp;
                lt++;
                gt--;
            }

        }

        System.out.println(String.valueOf(wordList));
    }
}
