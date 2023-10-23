package onlineJudge.backjun;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 연산자_끼워넣기_14888 {

    static int N;
    static int[] numArr;
    static String[] operationArr;
    static List<String> answerOperation = new ArrayList<>();
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    static boolean check[];

    public static void main(String[] args) throws IOException {
        input();
        DFS(0);
        output();
    }

    static void DFS(int L) {
        if (L == N - 1) {
            int operatedValue = 0;
            for (int i=0; i<N-1; i++) {
                if (i == 0) {
                    operatedValue = calculateNumber(numArr[i], numArr[i + 1], operationArr[i]);
                } else {
                    operatedValue = calculateNumber(operatedValue, numArr[i + 1], operationArr[i]);
                }
            }


            MIN = Math.min(MIN, operatedValue);
            MAX = Math.max(MAX, operatedValue);
            return;
        }

        for (int i=0; i<N - 1; i++) {
            if (!check[i]) {
                check[i] = true;
                operationArr[L] = answerOperation.get(i);
                DFS(L + 1);
                check[i] = false;
            }
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        operationArr = new String[N - 1];
        check = new boolean[N - 1];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            numArr[i] = Integer.parseInt(tokenizer.nextToken());
        }


        tokenizer = new StringTokenizer(br.readLine());

        int plus = Integer.parseInt(tokenizer.nextToken());
        int minus = Integer.parseInt(tokenizer.nextToken());
        int multiply = Integer.parseInt(tokenizer.nextToken());
        int divide = Integer.parseInt(tokenizer.nextToken());

        for (int i=0; i<plus; i++) {
            answerOperation.add("+");
        }

        for (int i=0; i<minus; i++) {
            answerOperation.add("-");
        }

        for (int i=0; i<divide; i++) {
            answerOperation.add("/");
        }

        for (int i=0; i<multiply; i++) {
            answerOperation.add("*");
        }

    }

    static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(MAX + "\n");
        bw.write(String.valueOf(MIN));
        bw.flush();
    }

    static int calculateNumber(int a, int b, String operation) {

        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            case "*":
                return a * b;
        }

        return 0;
    }


}
