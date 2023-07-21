package bootcamp.example.lv3;

import java.util.*;

public class FindRoute {
    public static void main(String[] args) {
        int[][] nodeInfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5},
            {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        for (int[] ints : solution(nodeInfo)) {
            System.out.println(Arrays.toString(ints));
        }
    }

    // 프로그래머스 Lv.3 길 찾기 게임

    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null));
        }
        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {
            insertNode(list.get(0), list.get(i));
        }

        preorder(preList, list.get(0));
        postorder(postList, list.get(0));

        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }

        return answer;
    }

    public static void preorder(List<Integer> preList, Node root) {
        if (root != null) {
            preList.add(root.num);
            preorder(preList, root.left);
            preorder(preList, root.right);
        }
    }

    public static void postorder(List<Integer> postList, Node root) {
        if (root != null) {
            postorder(postList, root.left);
            postorder(postList, root.right);
            postList.add(root.num);
        }
    }

    public static void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }

    public static class Node implements Comparable<Node>{
        int num;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int num, int x, int y, Node left, Node right) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }
            return o.y - this.y;
        }
    }
}