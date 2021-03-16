package problem210316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1260_DFS와BFS {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int start, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		for (int i = 1; i < N + 1; i++) {
			Collections.sort(list[i]);
		}

		visited = new boolean[N + 1];
		dfs(start);
		System.out.println();
		bfs();
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visit[] = new boolean[N+1];

		int current = start;
		queue.offer(current);
		visit[current] = true;

		while (!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " ");
			for (int y : list[x]) {
				if (!visit[y]) {
					visit[y] = true;
					queue.add(y);
				}
			}
		}

	}

	private static void dfs(int start) {
		if (visited[start]) {
			return;
		}

		visited[start] = true;
		System.out.print(start + " ");
		for (int y : list[start]) {
			if (!visited[y])
				dfs(y);
		}

	}

//	static class Node {
//		int vertex;
//		Node next;
//
//		public Node(int vertex, Node next) {
//			this.vertex = vertex;
//			this.next = next;
//		}
//
//		public Node(int vertex) {
//			this.vertex = vertex;
//		}
//	}

}
