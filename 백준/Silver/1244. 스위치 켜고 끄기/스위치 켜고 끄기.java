import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] switches = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            switches[i] = sc.nextInt();
        }
        
        int studentNum = sc.nextInt();
        
        for (int i = 0; i < studentNum; i++) {
        	int gender = sc.nextInt();
        	int num = sc.nextInt();
        	if (gender == 1) {
        		for (int j = 1; j <= N; j++) {
        			if (j % num == 0) {
        				switches[j] = (switches[j] == 1) ? 0 : 1;
        			}
        		}
        	} else {
        		switches[num] = (switches[num] == 1) ? 0 : 1;
        		int left = num - 1;
        		int right = num + 1;
        		while (1 <= left && right <= N) {
        			if (switches[left] == switches[right]) {
        				switches[left] = (switches[left] == 1) ? 0 : 1;
        				switches[right] = (switches[right] == 1) ? 0 : 1;
        				left--;
        				right++;
        			} else {
        				break;
        			}
        		}
        	}
        }
        
        for (int i = 1; i <= N; i++) {
        	System.out.print(switches[i] + " ");
        	if (i % 20 == 0) {
        		System.out.println();
        	}
        }
    }
}