import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int sliceNum = sc.nextInt();
        int maxArea = 0;
        
        row.add(0);
        row.add(M);
        col.add(0);
        col.add(N);
        for (int i = 0; i < sliceNum; i++) {
        	int direction = sc.nextInt();
        	int num = sc.nextInt();
        	if (direction == 0) {
        		row.add(num);
        	} else {
        		col.add(num);
        	}
        }
        Collections.sort(row);
        Collections.sort(col);
        
        for (int i = 0; i < row.size() - 1; i++) {
        	for (int j = 0; j < col.size() - 1; j++) {
        		int height = row.get(i + 1) - row.get(i);
        		int width = col.get(j + 1) - col.get(j);
        		maxArea = Math.max(maxArea, height * width);
        	}
        }
        System.out.println(maxArea);
    }
}