package onlineJudge.backjun;

import java.util.*;

public class 작업_21937 {

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visit;
    static int X, ANSWER = 0;

    public static void main(String[] args) {
        input();
        solution();

        System.out.println(ANSWER);
    }

    static void solution() {
        DFS(X);
    }

    static void DFS(int x) {
       List<Integer> pointerList = list.get(x);
       visit[x] = true;
       if (pointerList.isEmpty()) return;


       for (int i=0; i<pointerList.size(); i++) {
           if (!visit[pointerList.get(i)]) {
               visit[pointerList.get(i)] = true;
               ANSWER++;
               DFS(pointerList.get(i));
           }
       }

    }


    static void input() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        visit = new boolean[N + 1];

        // 빈 리스트를 넣어준다.
        for (int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            int prevNum = sc.nextInt();
            int workNum = sc.nextInt();

            list.get(workNum).add(prevNum);
        }


        X = sc.nextInt();
    }
}

