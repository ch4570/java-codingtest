package DFS_BFS_기초;

public class Tree_말단_노드까지_DFS {

    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(DFS(0, root));
    }

    /*
    *   최단 경로 알고리즘은 BFS(넓이 우선 탐색)를 사용하는 것이 효율적이다.
    *   DFS를 사용하게 되면, 왼쪽과 오른쪽 노드 하나라도 자식 노드가 존재하면 문제를 풀 수 없다(에러 발생)
    * */
    static int DFS(int L, Node root) {
        if (root.lt == null && root.rt == null) return L;

        return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
    }


}
