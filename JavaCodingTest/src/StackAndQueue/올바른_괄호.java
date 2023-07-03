package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class 올바른_괄호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(solution(s));
    }

    static String solution(String s) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        return answer;
    }
}
