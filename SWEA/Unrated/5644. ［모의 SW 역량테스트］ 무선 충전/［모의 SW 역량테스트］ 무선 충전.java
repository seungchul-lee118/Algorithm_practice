import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static int[] dr = {0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};
    static int[] routeA;
    static int[] routeB;
    static int[][] chargers;
    static int M;
    static int A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            M = sc.nextInt();
            A = sc.nextInt();
            routeA = new int[M + 1];
            routeB = new int[M + 1];
            chargers = new int[A][4];

            for (int i = 1; i <= M; i++) {
                routeA[i] = sc.nextInt();
            }
            for (int i = 1; i <= M; i++) {
                routeB[i] = sc.nextInt();
            }
            for (int i = 0; i < A; i++) {
                for (int j = 0; j < 4; j++) {
                    chargers[i][j] = j < 2 ? sc.nextInt() - 1 : sc.nextInt();
                }
            }

            int rowA = 0;
            int colA = 0;
            int rowB = 9;
            int colB = 9;
            int result = 0;

            for (int i = 0; i <= M; i++) {
                rowA += dr[routeA[i]];
                colA += dc[routeA[i]];
                rowB += dr[routeB[i]];
                colB += dc[routeB[i]];

                result += maxCharge(rowA, colA, rowB, colB);
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    static int maxCharge(int rowA, int colA, int rowB, int colB) {
        int maxValue = 0;
        List<Integer> chargeA = new ArrayList<>();
        List<Integer> chargeB = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            if (distance(rowA, colA, chargers[i][1], chargers[i][0]) <= chargers[i][2]) {
                chargeA.add(i);
            }
            if (distance(rowB, colB, chargers[i][1], chargers[i][0]) <= chargers[i][2]) {
                chargeB.add(i);
            }
        }

        if (!chargeA.isEmpty() && !chargeB.isEmpty()) {
            for (int i = 0; i < chargeA.size(); i++) {
                for (int j = 0; j < chargeB.size(); j++) {
                    int a = chargeA.get(i);
                    int b = chargeB.get(j);
                    int value = a == b ? chargers[a][3] : chargers[a][3] + chargers[b][3];
                    maxValue = Math.max(maxValue, value);
                }
            }
        } else if (!chargeA.isEmpty()) {
            for (Integer integer : chargeA) {
                maxValue = Math.max(maxValue, chargers[integer][3]);
            }
        } else if (!chargeB.isEmpty()) {
            for (Integer integer : chargeB) {
                maxValue = Math.max(maxValue, chargers[integer][3]);
            }
        }
        return maxValue;
    }

    static int distance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}