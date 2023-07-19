package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 교육과정_설계_해설 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));
    }

    static String solution(String s1, String s2) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();

        for (char x : s1.toCharArray()) {
            Q.offer(x);
        }

        for (char x : s2.toCharArray()) {
            if (Q.contains(x)) {
                if (x != Q.poll()) return "NO";
            }
        }

        if (!Q.isEmpty()) return "NO";

        return answer;
    }
}
