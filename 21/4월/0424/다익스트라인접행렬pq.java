package Day210424;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라인접행렬pq {
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
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
		int start = 0;
		int end = N-1;
		distance[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, distance[start]));
		
		Node temp;
		while(pq.isEmpty()) {
			temp = pq.poll();
			if(visited[temp.vertex]) continue;
			
			visited[temp.vertex] = true;
			if(temp.vertex == end) break;
			
			for(int j=0; j<N; j++) {
				if(!visited[j] && adjMatrix[temp.vertex][j] != 0 
						&& distance[j] > temp.weight + adjMatrix[temp.vertex][j] ) {
					distance[j] = temp.weight + adjMatrix[temp.vertex][j];
					pq.offer(new Node(temp.vertex, distance[temp.vertex]));
				}
			}
		}
		
		System.out.println(distance[end]);
	}
}
