package bootcamp.example.lv2;

public class CardDivide {
    public static void main(String[] args) {
        int[] arrayA1 = {10, 17};
        int[] arrayB1 = {5, 20};

        int[] arrayA2 = {10, 20};
        int[] arrayB2 = {5, 17};

        int[] arrayA3 = {14, 35, 119};
        int[] arrayB3 = {18, 30, 102};

        System.out.println(solution(arrayA1, arrayB1));
        System.out.println(solution(arrayA2, arrayB2));
        System.out.println(solution(arrayA3, arrayB3));
    }

    // 프로그래머스 lv.2 숫자 카드 나누기

    public static int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        boolean isDividedBbyA = false;
        boolean isDividedAbyB = false;

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] % gcdB == 0) {
                isDividedAbyB = true;
                break;
            }
        }
        for (int i = 0; i < arrayB.length; i++) {
            if (arrayB[i] % gcdA == 0) {
                isDividedBbyA = true;
                break;
            }
        }

        gcdA = isDividedBbyA ? 0 : gcdA;
        gcdB = isDividedAbyB ? 0 : gcdB;

        return Math.max(gcdA, gcdB);
    }

    public static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
