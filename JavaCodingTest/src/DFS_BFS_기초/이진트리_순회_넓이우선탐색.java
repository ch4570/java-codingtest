package DFS_BFS_기초;

import java.util.LinkedList;
import java.util.Queue;

public class 이진트리_순회_넓이우선탐색 {

    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        BFS(root);
    }

    static void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : " );
            for (int i=0; i<len; i++) {
                Node curNode = Q.poll();
                System.out.print(curNode.data + " ");
                if (curNode.lt != null) Q.offer(curNode.lt);
                if (curNode.rt != null) Q.offer(curNode.rt);
            }
            L++;
            System.out.println();
        }
    }

}

