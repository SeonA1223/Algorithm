package problem210619;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOj_1939_중량제한 {
	static int N, M;
	static int parent[];
	static List<Node> list;

	static class Node implements Comparable<Node> {
		int a;
		int b;
		int wLimit;

		public Node(int a, int b, int wLimit) {
			super();
			this.a = a;
			this.b = b;
			this.wLimit = wLimit;
		}

		@Override
		public int compareTo(Node o) {
			return o.wLimit - this.wLimit;
		}

	}

	static int find(int num) {
		if (parent[num] == -1)
			return num;
		return parent[num] = find(parent[num]);
	}

	static void union(int numA, int numB) {
		int pa = find(numA);
		int pb = find(numB);

		if (pa == pb)
			return;
		parent[pa] = pb;
		return;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		list = new ArrayList<>();
		Arrays.fill(parent, -1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int wLimit = Integer.parseInt(st.nextToken());
			list.add(new Node(a, b, wLimit));
		}
		Collections.sort(list);

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int res = 0;
		for (Node node : list) {
			int a = node.a;
			int b = node.b;

			union(a, b);
			if (find(A) != find(B))
				continue;
			else {
				res = node.wLimit;
				break;
			}
			
		}
		
		System.out.println(res);
	}
}
