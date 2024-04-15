import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	static boolean isTree;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int c = 1;
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0)
				break;

			cnt = 0;
			isTree = true;
			Node[] treeNodes = new Node[N + 1];
			for (int i = 1; i <= N; i++)
				treeNodes[i] = new Node(i);
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				treeNodes[n1].childs.add(n2);
				treeNodes[n2].childs.add(n1);
			}

			boolean[] visited = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
//				System.out.println(Arrays.toString(visited));
//				System.out.println(cnt);
				if (!visited[i]) {
					HashSet<Integer> route = new HashSet<>();
					DFS(0,i, treeNodes, visited, route);
					if (isTree) {
						cnt++;						
					}
					isTree = true;
				}
			}
			sb.append("Case ").append(c).append(": ");
			if (cnt > 1) {
				sb.append("A forest of ").append(cnt).append(" trees.").append("\n");
			} else if (cnt == 1) {
				sb.append("There is one tree.").append("\n");
			} else {
				sb.append("No trees.").append("\n");
			}
			c++;
		}
		System.out.println(sb);
	}

	public static void DFS(int prev, int nowPos, Node[] treeNodes, boolean[] visited, HashSet<Integer> route) {
//		System.out.println(nowPos);
		visited[nowPos] = true;
		route.add(nowPos);

		Node nowNode = treeNodes[nowPos];
		List<Integer> childList = nowNode.childs;
		for (int n : childList) {
			if (n != prev) {
				if (route.contains(n)) {
					isTree = false;
				} else {
					DFS(nowPos, n, treeNodes, visited, route);
				}
			}
		}
	}
}

class Node {
	int data;
	List<Integer> childs;

	Node(int data) {
		this.data = data;
		childs = new ArrayList<>();
	}
}
