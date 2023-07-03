package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자_제거 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution(s));
    }

    static String solution(String s) {
        StringBuilder answer = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (char x : s.toCharArray()) {

            stack.push(x);

            if (x == ')') {
                while (true) {
                    char ch = stack.pop();
                    if (ch == '(') break;
                }
            }
        }

        for (int i=0; i<stack.size(); i++) {
            answer.append(stack.get(i));
        }

        return answer.toString();
    }
}
