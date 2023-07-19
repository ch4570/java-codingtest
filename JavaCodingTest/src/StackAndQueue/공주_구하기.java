package StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 공주_구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int countPrince = Integer.parseInt(arr[0]);
        int number = Integer.parseInt(arr[1]);

        System.out.println(solution(countPrince, number));
    }

    static int solution(int countPrince, int number) {
        Queue<Integer> prince = new LinkedList<>();
        int answer = 0;

        for (int i=1; i<=countPrince; i++) {
            prince.offer(i);
        }

        while (prince.size() != 1) {
            for (int i=0; i< number - 1; i++) {
                int p = prince.poll();
                prince.offer(p);
            }
            prince.poll();
        }

        answer = prince.poll();

        return answer;
    }
}
