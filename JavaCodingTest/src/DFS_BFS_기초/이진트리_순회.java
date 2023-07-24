package DFS_BFS_기초;

public class 이진트리_순회 {

    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);
    }

    static void DFS(Node root) {
        if(root == null) return;
        // 전위순회
//        System.out.print(root.data + " ");

        DFS(root.lt);

        // 중위순회
//        System.out.print(root.data + " ");

        DFS(root.rt);

        // 후위순회
        System.out.print(root.data + " ");
    }


}

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
    }
}
