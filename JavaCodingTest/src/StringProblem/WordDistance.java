package StringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*   한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 구하기
*
* */
public class WordDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] keyword = br.readLine().split(" ");
        String sentence = keyword[0];
        char word = keyword[1].charAt(0);


        System.out.println(solution(sentence, word));

    }

    static String solution(String sentence, char word) {
        StringBuilder answerBuilder = new StringBuilder();

        /*
        *   현재 문자를 기준으로, 왼쪽과 오른쪽을 나눠서 문자를 찾아보고
        *   가장 작은 거리값을 StringBuilder에 append 해준다.
        * */
        for (int i=0; i<sentence.length(); i++) {
            if (sentence.charAt(i) == word) {
                answerBuilder.append(0);
                answerBuilder.append(' ');
            } else {
                int count = Math.min(findLeft(sentence, word, i), findRight(sentence, word, i));
                answerBuilder.append(count);
                answerBuilder.append(' ');
            }
        }

        return answerBuilder.toString();
    }

    static int findLeft(String sentence, char word, int maxIndex) {
        /*
        *   현재 위치가 가장 첫번째 문자라면, Integer 범위에서 가장 큰 값을 반환한다.
        *   현재 위치의 단어가 주어진 단어와 같았다면 이 함수 호출이 되지 않았을 것이기 때문에 결과적으로 다르기 때문이다.
        * */
        if (maxIndex == 0) {
            return Integer.MAX_VALUE;
        } else {
            for (int i=maxIndex; i>=0; i--) {
                // 현재 위치에서 왼쪽으로 탐색하며 단어를 찾고, 단어를 찾았다면 현재 위치부터 얼마나 떨어져있는지 반환한다.
                if (sentence.charAt(i) == word) {
                    return maxIndex - i;
                }
            }
        }

        // 단어를 찾지 못한 경우 Integer 범위에서 가장 큰 값을 반환한다.
        return Integer.MAX_VALUE;

    }

    static int findRight(String sentence, char word, int startIndex) {
        /*
        *   현재 위치가 가장 마지막 문자라면, Integer 범위에서 가장 큰 값을 반환한다.
        *   현재 위치의 단어가 주어진 단어와 같았다면 이 함수 호출이 되지 않았을 것이기 때문에 결과적으로 다르기 때문이다.
        * */
        if (startIndex == (sentence.length() - 1)) {
            return Integer.MAX_VALUE;
        } else {
            for (int i=startIndex; i<sentence.length(); i++) {
                // 현재 위치에서 오른쪽으로 탐색하며 단어를 찾고, 단어를 찾았다면 현재 위치부터 얼마나 떨어져있는지 반환한다.
                if (sentence.charAt(i) == word) {
                    return i - startIndex;
                }
            }
        }

        // 단어를 찾지 못한 경우 Integer 범위에서 가장 큰 값을 반환한다.
        return Integer.MAX_VALUE;
    }
}
