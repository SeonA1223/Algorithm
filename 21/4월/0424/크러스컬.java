package Day210424;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import Day210418.Krusckal복습_RANK사용O.Node;

public class 크러스컬 {
	static Node[] list;
	static int[] parent, rank;

	static int find(int x) {
		if (parent[x] == -1)
			return x;
		return parent[x] = find(parent[x]);
	}

	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if (px == py)
			return false;
		parent[py] = px;
		return true;
	}

	static public class Node implements Comparable<Node> {
		int start;
		int end;
		int weight;

		public Node(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점 수
		int M = Integer.parseInt(st.nextToken()); // 간선 수
		list = new Node[M];
		parent = new int[N + 1]; // 1부터 시작하므로
		rank = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[i] = new Node(start, end, weight);

		}

		Arrays.fill(parent, -1);
		//Arrays.sort(list); // 간선수 작은 것부터 시작해야한다.
//		Arrays.sort(list, new Comparator<Node>() {
//
//			@Override
//			public int compare(Node o1, Node o2) {
//				
//				return o1.weight - o2.weight;
//			}
//			
//		});
		
		Arrays.sort(list, (o1, o2) -> o1.weight-o2.weight);
		

		int connection = 0;
		int res = 0;
		for (Node node : list) {
			if (union(node.start, node.end)) {
				res += node.weight;
				if (connection == N - 1)
					break;
			}
		}
		System.out.println(res);
	}
}
