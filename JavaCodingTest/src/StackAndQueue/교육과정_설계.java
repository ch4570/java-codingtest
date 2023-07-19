package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정_설계 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(solution(s1, s2));
    }

    static String solution(String s1, String s2) {
        Queue<Character> Q = new LinkedList<>();
        int lt = 0;
        int rt = 0;
        while (lt < s1.length() && rt < s2.length()) {
            char char1 = s1.charAt(lt);
            char char2 = s2.charAt(rt);

            if (char1 == char2) {
                lt++;
                rt++;
                Q.offer(char1);
            } else {
                rt++;
            }
        }

        StringBuilder word = new StringBuilder();

        while (!Q.isEmpty()) {
            word.append(Q.poll());
        }

        return word.toString().equals(s1) ? "YES" : "NO";
    }
}
