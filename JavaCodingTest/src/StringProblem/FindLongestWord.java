package StringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*   문장에서 가장 긴 단어 찾기 문제
*   가장 긴 단어가 여러개라면 가장 앞에 있는 단어가 우선한다.
* */
public class FindLongestWord {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문장을 입력받고, 문자 단위로 분할해준다.
        String[] wordList = br.readLine().split(" ");

        System.out.println(solution(wordList));

    }

    static String solution(String[] wordList) {

        // 가장 첫번째 문자를 최대값으로 초기화해준다.
        String answer = wordList[0];

        for (int i = 0; i < wordList.length-1; i++) {
            // 순서대로 문자를 비교하면서 최대길이를 가지는 문자열을 찾는다.
            if (wordList[i].length() < wordList[i+1].length()) {
                answer = wordList[i+1];
            }

        }

        return answer;
    }
}
