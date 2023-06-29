package StringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
*   문자열 암호 풀이 문제
* */
public class SolveString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        String sentence = br.readLine();
        System.out.println(solution(sentence, number));
    }

    // 내 풀이
    static String solution(String sentence, int number) {

        StringBuilder builder = new StringBuilder(sentence);
        List<String> sentenceList = new ArrayList<>();
        String answer = "";
        for (int i=0; i<number; i++) {
            String word = builder.substring(0, 7);
            sentenceList.add(word);
            builder.delete(0, 7);
        }

        for (int i=0; i< sentenceList.size(); i++) {
            String word = sentenceList.get(i);
            String binary = "";
            for(int j=0; j<word.length(); j++) {
                if (word.charAt(j) == '#') {
                    binary += "1";
                } else {
                    binary += "0";
                }
            }

            answer += (char) Integer.parseInt(binary, 2);
        }

        return answer;
    }

    // 강의 풀이
    static String solution2(String sentence, int number) {
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<number; i++) {
            // 문자열을 잘라내고 이진수 형태로 변경
            String tmp = sentence.substring(0, 7).replace('#', '1')
                    .replace('*', '0');
            // 이진수를 10진수로 변환
            int binaryNum = Integer.parseInt(tmp, 2);

            // StringBuilder에 결과를 append
            builder.append((char) binaryNum);

            // 잘라낸 문자 부분은 제외하고 substring 해서 문자열을 갱신한다.
            sentence = sentence.substring(7);
        }

        return builder.toString();
    }
}
