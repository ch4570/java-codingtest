package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자_제거_해설 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == ')') {
                // while 조건문 안에서 pop()를 호출하여 내부 처리가 따로 필요하지 않다.
                while (stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }

        for (int i=0; i<stack.size(); i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}
