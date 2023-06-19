package bootcamp.example.lv2;

import java.util.*;

public class IslandTrip {
    public static void main(String[] args) {
        String[] maps1 = {"X591X", "X1X5X", "X231X", "1XXX1"};
        String[] maps2 = {"XXX","XXX","XXX"};

        System.out.println(Arrays.toString(solution(maps1)));
//        System.out.println(Arrays.toString(solution(maps2)));
    }

    // 프로그래머스 lv.2 무인도 여행

    public static int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        int[][] mapArray = new int[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') {
                    mapArray[i][j] = 0;
                    visited[i][j] = true;
                } else {
                    mapArray[i][j] = c - '0';
                }
            }
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (visited[i][j] || mapArray[i][j] == 0) continue;
                queue.add(new Node(i, j));
                int sum = 0;
                sum += mapArray[i][j];
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    int row = node.row;
                    int col = node.col;

                    if (row + 1 < maps.length && !visited[row+1][col]) {
                        sum += mapArray[row + 1][col];
                        visited[row + 1][col] = true;
                        queue.add(new Node(row + 1, col));
                    }
                    if (row - 1 >= 0 && !visited[row -1][col]) {
                        sum += mapArray[row - 1][col];
                        visited[row - 1][col] = true;
                        queue.add(new Node(row - 1, col));
                    }
                    if (col + 1 < maps[0].length() && !visited[row][col+1]) {
                        sum += mapArray[row][col + 1];
                        visited[row][col + 1] = true;
                        queue.add(new Node(row, col + 1));
                    }
                    if (col - 1 >= 0 && !visited[row][col-1]) {
                        sum += mapArray[row][col - 1];
                        visited[row][col - 1] = true;
                        queue.add(new Node(row, col - 1));
                    }
                }
                list.add(sum);
            }
        }

        if (list.isEmpty()) list.add(-1);

        return list.stream().mapToInt(n -> n).sorted().toArray();
    }

    private static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // 다른 사람들 풀이 (DFS 풀이 참고용)
    public static int[] solution1(String[] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();

        for(int i=0 ; i<maps.length ; i++) {
            int sum = 0;
            for(int j=0 ; j<maps[i].length() ; j++) {
                sum = getTerritory(i, j, visit, maps);
                if(sum>0) {
                    list.add(sum);
                }
            }
        }
        return list.isEmpty()?new int[]{-1}:list.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public static int getTerritory(int i, int j, boolean[][] visit, String[] maps) {
        if(i<0 || j<0 || i>=visit.length || j>=visit[0].length || visit[i][j] || maps[i].charAt(j)=='X') {
            return 0;
        }
        visit[i][j] = true;
        return (maps[i].charAt(j)-'0')
            + getTerritory(i-1,j,visit,maps)
            + getTerritory(i+1,j,visit,maps)
            + getTerritory(i,j-1,visit,maps)
            + getTerritory(i,j+1,visit,maps);
    }

}
