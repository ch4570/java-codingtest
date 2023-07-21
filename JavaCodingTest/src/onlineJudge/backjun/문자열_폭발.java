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

        StringBuilder builder = new StringBuilder();


        return builder.toString();
    }
}
