package Day210424;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prim_인접행렬_pq {
	public static class Node implements Comparable<Node> {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
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

		int[][] adjMatrix = new int[N][N];
		int[] distance = new int[N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(distance, Integer.MAX_VALUE);
		int current = 0;
		distance[current] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(current, distance[current]));
		
		int cnt = 0;
		int res = 0;
		Node temp;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			if(visited[temp.vertex]) continue;
			
			visited[temp.vertex] = true;
			res += temp.weight;
			if(++cnt == N) break;
			
			for(int i=0; i<N; i++) {
				if(!visited[i] && adjMatrix[temp.vertex][i] != 0 
						&& distance[i] > adjMatrix[temp.vertex][i]) {
					distance[i] = adjMatrix[temp.vertex][i];
					pq.offer(new Node(i, distance[i]));
				}
			}
		}
		System.out.println(res);
		
	}
}
