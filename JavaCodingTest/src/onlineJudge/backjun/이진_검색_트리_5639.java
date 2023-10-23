package onlineJudge.backjun;

import java.io.*;

public class 이진_검색_트리_5639 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static Node rootNode;

    public static void main(String[] args) throws IOException {
        input();
        DFS(rootNode);
        output();
    }

    static void input() throws IOException {
        String input;
        int count = 0;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int value = Integer.parseInt(input);
            Node node = new Node();
            node.setValue(value);
            if (count == 0) {
                rootNode = node;
            } else {
                insertNode(node);
            }

            count++;
        }
    }

    static void insertNode(Node node) {
        Node searchNode = rootNode;

        while (true) {
            if (searchNode.value > node.value && searchNode.left == null) {
                searchNode.left = node;
                break;
            } else if (searchNode.value > node.value) {
                searchNode = searchNode.left;
            } else if (searchNode.value < node.value && searchNode.right == null) {
                searchNode.right = node;
                break;
            } else {
                searchNode = searchNode.right;
            }
        }
    }

    static void DFS(Node node) {
        if (node.left != null) DFS(node.left);
        if (node.right != null) DFS(node.right);

        sb.append(node.value);
        sb.append("\n");
    }

    static void output() throws IOException {
        bw.write(sb.toString());
        bw.flush();

        bw.close();
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
