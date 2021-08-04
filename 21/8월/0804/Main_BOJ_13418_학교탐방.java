package problem210804;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_13418_학교탐방 {

	static int N, M, K1, K2;
	static int[] parent;
	static Node[] nodes;

	static void init() {
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int find(int num) {
		if (parent[num] == num)
			return num;
		return parent[num] = find(parent[num]);
	}

	static boolean union(int numA, int numB) {
		int aParent = find(numA);
		int bParent = find(numB);

		if (aParent == bParent)
			return false;
//		bParent에 부모가 aParent가 되는 것
		parent[bParent] = aParent;
		return true;
	}

	static class Node {
		int start;
		int end;
		int updown;

		public Node(int start, int end, int updown) {
			super();
			this.start = start;
			this.end = end;
			this.updown = updown;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K1 = 0;
		K2 = 0;
		nodes = new Node[M + 1];
		int entrance = 0;
		int next = 0;
		int enupdown = 0;

		parent = new int[N + 1];

		for (int i = 0; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int ud = Integer.parseInt(st.nextToken());

			if (s == 0 || e == 0) {
				entrance = s;
				next = e;
				enupdown = ud;
			}

			nodes[i] = new Node(s, e, ud);

		}
//		오르막길 계산
		Arrays.sort(nodes, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.updown - o2.updown;
			}

		});
		K1 = krusckal(entrance, next, enupdown);
//		내리막길 계산
		Arrays.sort(nodes, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.updown - o1.updown;
			}

		});
		K2 = krusckal(entrance, next, enupdown);

		System.out.println(K1 * K1 - K2 * K2);

	}

	private static int krusckal(int e, int n, int ud) {
		init();
		int cnt = 0;
		int up = 0;
		if (ud == 0)
			up++;
		union(e, n);
		for (Node node : nodes) {
			if (union(node.start, node.end)) {
				if (node.updown == 0)
					up++;
				if (++cnt == N - 1)
					break;
			}
		}
		return up;
	}
}
