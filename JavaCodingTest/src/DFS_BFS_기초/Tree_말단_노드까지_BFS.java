package DFS_BFS_기초;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_말단_노드까지_BFS {

    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(BFS(root));
        System.out.println(BFS2(root));
    }


    // 내 풀이
    static int BFS(Node root) {

        Queue<Node> Q = new LinkedList<>();
        int L = 0;
        Q.offer(root);

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i=0; i<len; i++) {
                Node node = Q.poll();
                if (node.rt == null && node.lt == null) return L;
                if (node.lt != null) Q.offer(node.lt);
                if (node.rt != null) Q.offer(node.rt);
            }

            L++;
        }

        return 0;
    }

    // 해설
    static int BFS2(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);

        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();

            for (int i=0; i<len; i++) {
                Node curNode = Q.poll();
                if (curNode.lt == null && curNode.rt == null) return L;
                if (curNode.lt != null) Q.offer(curNode.lt);
                if (curNode.rt != null) Q.offer(curNode.rt);
            }

            L++;
        }

        return 0;
    }


}
