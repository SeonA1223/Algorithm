import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_14938_서강그라운드 {
	static int n, m, r;
	static int[] itemNum;
	static List<Node>[] nodes;
	static int maxNum;

	static class Node implements Comparable<Node> {
		int node;
		int d;

		public Node(int e, int d) {
			this.node = e;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			return this.d - o.d;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		itemNum = new int[n + 1];
		maxNum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			itemNum[i] = Integer.parseInt(st.nextToken());
		}

		nodes = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			nodes[a].add(new Node(b, c));
			nodes[b].add(new Node(a, c));
		}

		for (int i = 1; i <= n; i++) {
			bfs(i);
		}

		System.out.println(maxNum);

	}

	private static void bfs(int i) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
//		int[] distance = new int[n + 1];
//		Arrays.fill(distance, Integer.MAX_VALUE);

		q.add(new Node(i, 0));
//		distance[i] = 0;

		Node temp;
		int item = 0;
		while (!q.isEmpty()) {
			temp = q.poll();
			int index = temp.node;
			int d = temp.d;

			if (visited[index])
				continue;
			visited[index] = true;
			item += itemNum[index];

			for (Node node : nodes[index]) {
				if (!visited[node.node] && node.d + d <= m) {
					q.add(new Node(node.node, node.d + d));
				}

			}
		}
		maxNum = Math.max(maxNum, item);
	}
}
