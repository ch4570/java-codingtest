package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }

    static int solution(String str) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (str.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer++;
                }
            }
        }

        return answer;
    }
}
