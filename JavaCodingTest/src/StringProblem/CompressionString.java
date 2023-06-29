package StringProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*   반복되는 문자열 압축 문
* */
public class CompressionString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        String answer = solution(sentence);
        System.out.println(answer);
    }

    // 내풀이
    static String solution(String sentence) {
        // 문자열을 만들 Builder 클래스 생성
        StringBuilder builder = new StringBuilder();
        int count = 1;

        for (int i=0; i<sentence.length() - 1; i++) {
            if (sentence.charAt(i) == sentence.charAt(i + 1)) {
                count++;
                if ((i+1) == sentence.length() - 1) {
                    builder.append(sentence.charAt(i));

                    if (count > 1) {
                        builder.append(count);
                    }
                }
            } else {
                builder.append(sentence.charAt(i));
                if (count > 1) {
                    builder.append(count);
                }
                if ((i+1) == sentence.length() - 1) {
                    builder.append(sentence.charAt(i+1));
                }
                count = 1;
            }
        }

        return builder.toString();
    }

    // 강의 풀이
    static String solution2(String sentence) {
        // 현재 위치의 문자와 다음 문자를 비교하면 마지막 문자일경우 이슈가 생기기 때문에, 빈 문자열을 하나 더해줘서 쉽게 해결할 수 있다.
        String answer = sentence + " ";

        int cnt = 1;

        for (int i=0; i< sentence.length() - 1; i++) {
            if (sentence.charAt(i) == sentence.charAt(i+1)) {
                cnt++;
            } else {
                answer += sentence.charAt(i);
                if (cnt > 1) {
                    answer += cnt;
                }
                cnt = 1;
            }
        }

        return answer;
    }
}
