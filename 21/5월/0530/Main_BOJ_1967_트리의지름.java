package Day210530;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//35m
public class Main_BOJ_1967_트리의지름 {
	static class Node {
		int child;
		int weight;

		public Node(int child, int weight) {
			super();
			this.child = child;
			this.weight = weight;
		}

	}

	static int N, res;
	static List<Node>[] list;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		dp = new int[N + 1];
		res = 0;

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[p].add(new Node(c, w));
			list[c].add(new Node(p, w));
		}

		findLeafNode(1, 0, new boolean[N + 1]);
		int farNode = getFarNode();
		getFarDistance(farNode, 0, new boolean[N + 1]);
		System.out.println(res);

	}

	private static void getFarDistance(int farNode, int dis, boolean visited[]) {
		visited[farNode] = true;
		if (dis > res)
			res = dis;

		for (Node n : list[farNode]) {
			if (!visited[n.child]) {
				getFarDistance(n.child, dis + n.weight, visited);
				visited[n.child] = false;
			}
		}
	}

	private static int getFarNode() {
		int n = 0;
		int res = 0;
		for (int i = 1; i <= N; i++) {
			if (res < dp[i]) {
				n = i;
				res = dp[i];
			}
		}
		return n;
	}

	private static void findLeafNode(int node, int weight, boolean[] visited) {
		visited[node] = true;
		dp[node] = weight;

		for (Node n : list[node]) {
			if (!visited[n.child]) {
				findLeafNode(n.child, weight + n.weight, visited);
			}
		}
	}
}
