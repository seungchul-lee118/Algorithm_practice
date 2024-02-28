import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] synergy;
	static int N;
	static int gap;
	static List<Integer> ingredientsA;
	static List<Integer> ingredientsB;
    
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        gap = 20000 * N;

        synergy = new int[N][N];
        ingredientsA = new ArrayList<>();

        // 숫자 N개 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                synergy[i][j] = sc.nextInt();
            }
        }

        combination(0, 0);

        System.out.println(gap);
	}
	
	//부분집합 구하기 위한 메서드
	public static void combination(int idx, int idxA) {
		// N/2개를 조합했을 때 
		if (idxA == (N/2)) {
			ingredientsB = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (ingredientsA.contains(i)) continue;
				ingredientsB.add(i);
			}
			gap = Math.min(gap, getGap());
			return;
		}
		// 마지막까지 순회했을 때
		if (idx >= N) {
			return;
		}
		
		ingredientsA.add(idx);
		// idx번째 수를 포함했을 때
		combination(idx + 1, idxA + 1);
		ingredientsA.remove(Integer.valueOf(idx));
		// idx번째 수를 포함하지 않았을 때
		combination(idx + 1, idxA);
	}
	
	static int getGap() {
		int sumA =0;
		int sumB = 0;
		
		for (int i = 0; i < ingredientsA.size(); i++) {
			int ingredient1 = ingredientsA.get(i);
			for (int j = 0; j < ingredientsA.size(); j++) {
				int ingredient2 = ingredientsA.get(j);
				sumA += synergy[ingredient1][ingredient2];
			}
		}
		for (int i = 0; i < ingredientsB.size(); i++) {
			int ingredient1 = ingredientsB.get(i);
			for (int j = 0; j < ingredientsB.size(); j++) {
				int ingredient2 = ingredientsB.get(j);
				sumB += synergy[ingredient1][ingredient2];
			}
		}
		
		return Math.abs(sumA - sumB);
	}
}