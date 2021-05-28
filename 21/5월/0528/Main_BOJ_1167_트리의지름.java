package Day210528;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_1167_트리의지름 {
	static class Node {
		int n;
		int dis;

		public Node(int n, int dis) {
			super();
			this.n = n;
			this.dis = dis;
		}

	}

	static int N, res, node;
	static List<Node> nodes[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		nodes = new ArrayList[N + 1];
		res = 0;
		node = 0;

		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int vNum = Integer.parseInt(st.nextToken());
			int s;
			while ((s = Integer.parseInt(st.nextToken())) != -1) {
				int dis = Integer.parseInt(st.nextToken());
				nodes[vNum].add(new Node(s, dis));
			}
		}

		boolean visited[] = new boolean[N + 1];
		dfs(1, visited, 0);
		Arrays.fill(visited, false);
		dfs(node, visited, 0);

		System.out.println(res);

	}

	private static void dfs(int nodeNum, boolean[] visited, int dis) {
		visited[nodeNum] = true;

		for (int i = 0; i < nodes[nodeNum].size(); i++) {
			int n = nodes[nodeNum].get(i).n;
			if (!visited[n]) {
				int distance = nodes[nodeNum].get(i).dis;
				dfs(n, visited, dis + distance);
			}
		}

		if(res<dis) {
			res = dis;
			node = nodeNum;
		}

	}
}
