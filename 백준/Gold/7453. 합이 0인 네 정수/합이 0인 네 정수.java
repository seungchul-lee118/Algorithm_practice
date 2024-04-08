

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		int[] C = new int[n];
		int[] D = new int[n];
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		int[] AB = new int[n*n];
		for(int i = 0 ;i<n; i++) {
			for(int j = 0; j<n; j++) {
				AB[i*n+j] = A[i]+B[j];
			}
		}
		
		int[] CD = new int[n*n];
		for(int i = 0 ;i<n; i++) {
			for(int j = 0; j<n; j++) {
				CD[i*n+j] = C[i]+D[j];
			}
		}
		
        //투 포인터를 위해 AB CD sort
		Arrays.sort(AB);
		Arrays.sort(CD);
		
        
		long cnt = 0;
		int left = 0;
		int right = CD.length-1;
        
        //투 포인터 알고리즘이 되는 이유
        //AB[left] + CD[right]가 0보다 크다면 -> CD에서 right보다 오른쪽에 있는 녀석들은 볼필요가 없으므로 right를 줄이기
        //AB[left] + CD[right]가 0보다 작다면 -> AB에서 left보다 왼쪽에 있는 녀석들은 볼필요가 없으므로 left--
		while(left < AB.length && right >=0) {
            
			if(AB[left] +CD[right] > 0) {
				right--;
			}
			else if(AB[left] + CD[right] < 0) {
				left++;
			}
            
            //같다면 종전의 binarySearch를 이용한 동수 처리 알고리즘을 재활용하여
			else {
                // 끝과 끝을 구하여 동수처리하기
				int tmpL = binarySearchRight(left, AB[left], AB);
				int tmpR = binarySearchLeft(right, CD[right], CD);
				cnt += (long)(tmpL - left+1) * (long)(right - tmpR+1);
                
                // 동수 처리 후 포인터 둘다 움직여도 되는 이유
                // left만 움직이면 어차피 AB[left]+CD[right] > 0이고
                // 반대로도 마찬가지이기 때문이다.
				left = tmpL+1;
				right = tmpR-1;
			}
		}
		
		System.out.println(cnt);
	}
	
//	private static int binarySearch(int key, int[] CD) throws InterruptedException {
//		int left = 0;
//		int right = CD.length-1;
//		while(left <= right) {
////			Thread.sleep(50);
//			int mid = (left+right)/2;
////			System.out.println(CD[left]+" "+CD[mid]+" "+CD[right]);
//			if(CD[mid] < key) {
//				left = mid + 1;
//			}
//			else if(CD[mid] > key) {
//				right = mid - 1;
//			}
//			else {
//				left = binarySearchLeft(mid, key, CD);
//				right = binarySearchRight(mid, key, CD);
//				
//				return right - left + 1;
//			}
//		}
//		return 0;
//	}
//	
	private static int binarySearchLeft(int _mid, int key, int[] CD) {
		int left = 0;
		int right = _mid;
		while(left <= right) {
			int mid = (left + right)/2;
//			System.out.println(CD[left]+" "+CD[mid]+" "+CD[right]);
			if(CD[mid] == key) {
				if(mid == 0 || CD[mid-1] != key)
					return mid;
				else
					right = mid -1;
			}
			else {
				left = mid + 1;
			}
		}
		return left;
	}
	
	private static int binarySearchRight(int _mid, int key, int[] CD) {
		int left = _mid;
		int right = CD.length-1;
		while(left <= right) {
			int mid = (left + right)/2;
			if(CD[mid] == key) {
				if(mid == CD.length-1 || CD[mid+1] != key)
					return mid;
				else
					left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return left;
	}
}
