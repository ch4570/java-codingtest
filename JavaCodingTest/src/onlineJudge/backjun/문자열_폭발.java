package onlineJudge.backjun;

import java.io.*;
import java.util.Stack;

public class 문자열_폭발 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        String word = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String answer = solution(sentence, word);

        bw.write(answer);
        bw.flush();

        bw.close();
        br.close();

    }

    static String solution(String sentence, String word) {

        /*
        *   문제 해결 아이디어
        *   폭발 문자열에 있는 단어가 포함되어 있는지 확인해서 아니라면 스택에 담아준다.
        * */

        /*
        *   메모리 초과 발생시 동적으로 할당되는 변수 이외의 변수는 미리 값을 만들어주고,
        *   반복문을 돌때, 특정 조건이 만족하지 않을 경우 탐색의 필요가 없다면 break 진행하여 메모리를 아껴줄 것!
        * */
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int regexLength = word.length();

        for (char x : sentence.toCharArray()) {
            stack.push(x);

            if (stack.size() >= regexLength) {
                boolean isEqual = true;

                for (int i=stack.size() - regexLength, j=0; i < stack.size(); i++, j++) {
                    if (stack.get(i) != word.charAt(j)) {
                        isEqual = false;
                        break;
                    }
                }

                if (isEqual) {
                    for (int i=0; i<regexLength; i++) {
                        stack.pop();
                    }

                }
            }
        }

        if (stack.isEmpty()) {
            return "FRULA";
        }

        for (int i=0; i<stack.size(); i++) {
            answer.append(stack.get(i));
        }


        return answer.toString();
    }
}
