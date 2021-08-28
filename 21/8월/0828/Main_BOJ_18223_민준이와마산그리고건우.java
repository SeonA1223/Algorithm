import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_18223_민준이와마산그리고건우 {
	static int V, E, P;

	static List<Node>[] nodes;

	static class Node implements Comparable<Node> {
		int end;
		int weight;

		public Node(int b, int c) {
			this.end = b;
			this.weight = c;
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
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		nodes = new ArrayList[V + 1];

		for (int i = 0; i <= V; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			nodes[a].add(new Node(b, c));
			nodes[b].add(new Node(a, c));
		}

		int minDis = dikstra(1, V);
		int gunwoo = dikstra(1, P) + dikstra(P, V);

		if (minDis >= gunwoo) {
			System.out.println("SAVE HIM");
		} else {
			System.out.println("GOOD BYE");
		}

	}

	public static int dikstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];

		int[] distance = new int[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[start] = 0;
		pq.offer(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node v = pq.poll();

			if (visited[v.end])
				continue;
			visited[v.end] = true;

			if (v.end == end) {
				return distance[end];
			}

			for (Node next : nodes[v.end]) {
				if (distance[next.end] > distance[v.end] + next.weight) {
					distance[next.end] = distance[v.end] + next.weight;
					pq.offer(new Node(next.end, distance[next.end]));
				}
			}

		}
		return Integer.MAX_VALUE;
	}

}
