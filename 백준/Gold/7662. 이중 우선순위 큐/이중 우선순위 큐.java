import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	PriorityQueue<Integer> pqMax;
    	PriorityQueue<Integer> pqMin;
    	
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
        	Map<Integer, Integer> map = new HashMap<>();
        	pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        	pqMin = new PriorityQueue<>();
        	int N = Integer.parseInt(br.readLine());;
        	
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		String str = st.nextToken();
        		int n = Integer.parseInt(st.nextToken());
        		
        		if (str.equals("I")) {
        			pqMax.offer(n);
        			pqMin.offer(n);
        			map.put(n, map.getOrDefault(n, 0) +1);
        		} else if (str.equals("D")) {
        			if (map.isEmpty()) {
        				continue;
        			}
        			if (n == 1) {
        				while (!map.containsKey(pqMax.peek())) {
        					pqMax.poll();
        				}
        				int max = pqMax.poll();
        				int count = map.getOrDefault(max, 0);
        				if (count == 1) {
        					map.remove(max);
        				} else if (count > 1){
        					map.put(max, count - 1);
        				}
        			} else {
        				while (!map.containsKey(pqMin.peek())) {
        					pqMin.poll();
        				}
        				int min = pqMin.poll();
        				int count = map.getOrDefault(min, 0);
        				if (count == 1) {
        					map.remove(min);
        				} else if (count > 1){
        					map.put(min, count - 1);
        				}
        			}
        		}
        	}
        	
        	if (map.isEmpty()) {
        		System.out.println("EMPTY");
        	} else {
        		while (!map.containsKey(pqMax.peek())) {
        			pqMax.poll();
        		}
        		while (!map.containsKey(pqMin.peek())) {
        			pqMin.poll();
        		}
        		System.out.println(pqMax.poll() + " " + pqMin.poll());
        	}
        }
    }
}