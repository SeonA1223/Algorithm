package Day210718;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1800_인터넷설치 {

	static int N, P, K;
	static List<Node>[] coms;

	static class Node {
		int next;
		int value;

		public Node(int n, int v) {
			this.next = n;
			this.value = v;
		}

	}

	static int ans;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		coms = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			coms[i] = new ArrayList<>();
		}

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			coms[a].add(new Node(b, c));
			coms[b].add(new Node(a, c));
		}

		pq = new PriorityQueue<>(Collections.reverseOrder());
		for (Node node : coms[1]) {
			pq.clear();
			boolean visited[] = new boolean[N + 1];
			visited[1] = true;
			visited[node.next] = true;
			dfs(node, visited, pq);

		}

		System.out.println(ans);

	}

	private static void dfs(Node node, boolean[] visited, PriorityQueue<Integer> pq) {
		pq.offer(node.value);
		if (node.next == N) {
			for (int i = 0; i < K; i++) {
				pq.poll();
			}
			ans = Math.min(ans, pq.poll());
			return;
		}
		for (Node n : coms[node.next]) {
			if (visited[n.next])
				continue;
			visited[n.next] = true;
			dfs(n, visited, pq);
			visited[n.next] = false;
		}

	}

}
