package onlineJudge.backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 암호_만들기_1759 {

    static List<String> answer = new ArrayList<>();
    static String[] answerWords;
    static String[] answerList;
    static int answerSize, answerMax;



    public static void main(String[] args) throws IOException {
        input();
        DFS(0, 0);
        output();
    }



    static void DFS(int start, int depth) {

        if (depth == answerSize) {
            validate();
            return;
        }

        for (int i=start; i<answerMax; i++) {
            answerList[depth] = answerWords[i];
            DFS(i + 1, depth + 1);
        }



    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        answerSize = Integer.parseInt(tokenizer.nextToken());
        answerMax = Integer.parseInt(tokenizer.nextToken());

        answerWords = new String[answerMax];
        answerList = new String[answerSize];

        tokenizer = new StringTokenizer(br.readLine());

        for (int i=0; i<answerMax; i++) {
            answerWords[i] = tokenizer.nextToken();
        }

        Arrays.sort(answerWords);

        br.close();
    }

    static void validate() {

        int verbCount = 0;
        int verbCount2 = 0;

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<answerList.length; i++) {

            if (answerList[i].equals("a") || answerList[i].equals("e") || answerList[i].equals("i") || answerList[i].equals("o") || answerList[i].equals("u")) {
                verbCount++;
            } else {
                verbCount2++;
            }
        }

        if (verbCount > 0 && verbCount2 > 1) {
            for (String x : answerList) sb.append(x);
            answer.add(sb.toString());
        }

    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : answer) bw.write(s + "\n");

        bw.flush();
        bw.close();
    }


}
