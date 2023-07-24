package onlineJudge.backjun;

import java.io.*;
import java.util.Stack;

public class 탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");

        bw.write(solution(numbers));
        bw.flush();
        bw.close();
        br.close();

    }

    static String solution(String[] numbers) {
        Stack<Top> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        // 첫 번째 탑은 레이저를 받아줄 탑이 없기 때문에 먼저 스택에 넣고 시작한다.
        stack.push(new Top(Integer.parseInt(numbers[0]), 1));
        answer.append(0).append(" ");

        for (int i=1; i<numbers.length; i++) {
            Top top = new Top(Integer.parseInt(numbers[i]), (i+1));

            // 레이저를 쏜 탑의 높이보다 바로 앞의 탑의 높이가 크거나 같아야 레이저를 받을 수 있다.
            if (stack.peek().height >= top.height) {
                answer.append(stack.peek().order).append(" ");
            } else {
                // stack이 모두 비기 전까지 레이저를 쏜 탑보다 낮은 탑은 전부 제거한다.
                while (!stack.isEmpty()) {
                    if (stack.peek().height >= top.height) {
                        answer.append(stack.peek().order).append(" ");
                        break;
                    }

                    stack.pop();
                }

                // stack이 비어있다면 레이저를 받아 줄 탑이 없다는 뜻이므로 0을 추가해준다.
                if (stack.isEmpty()) answer.append(0).append(" ");
            }

            // 마지막에 stack에 Top 객체를 push 해준다.
            stack.push(top);
        }

        return answer.toString();
    }

}

class Top {
    int height;
    int order;

    // 몇번째 탑인지 알아야 하기 때문에, order 변수로 몇번째 탑인지 확인한다.
    Top(int height, int order) {
        this.height = height;
        this.order = order;
    }
}


