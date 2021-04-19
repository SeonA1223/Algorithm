package Day210419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 크루스칼 {
	static int[] parent;
	static List<Node> nodes;

	static class Node implements Comparable<Node> {
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
			return Integer.compare(this.weight, o.weight);
		}

	}

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
		parent[px] = py; // Rank적용 전
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점 수
		int M = Integer.parseInt(st.nextToken()); // 정점 수
		parent = new int[N + 1];
		nodes = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()); // 정점 수
			int end = Integer.parseInt(st.nextToken()); // 정점 수
			int weight = Integer.parseInt(st.nextToken()); // 정점 수
			nodes.add(new Node(start, end, weight));

		}
		
		Collections.sort(nodes);
		Arrays.fill(parent, -1);
		
		int res = 0, cnt =0;
		
		for (Node node : nodes) {
			if(union(node.start, node.end)) {
				res += node.weight;
				if(++cnt == N-1) break;
			}
		}
		System.out.println(res);
	}

}
