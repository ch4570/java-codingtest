package DFS_BFS_기초;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 송아지_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int s = Integer.parseInt(arr[0]);
        int e = Integer.parseInt(arr[1]);

        bw.write(String.valueOf(solution(s, e)));
        bw.flush();
        bw.close();
        br.close();
    }

    static int solution(int s, int e) {
        int[] dis = {1, -1, 5};
        int[] ch = new int[10001];
        ch[s] = 1;

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);

        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i=0; i<len; i++) {
                int x = Q.poll();
                for (int j : dis) {
                    int nx = x + j;
                    if (nx == e) return L + 1;
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }


        return 0;
    }


}
