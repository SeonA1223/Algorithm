package Day210419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라 {
	static class Node implements Comparable<Node> {
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
		int N = Integer.parseInt(st.nextToken()); //정점 수
		int C = Integer.parseInt(st.nextToken()); //연결 수
		
		List<Node> adjList[] = new ArrayList[N];
		int[] distance = new int[N];
		boolean[] visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[start].add(new Node(end, weight)); //무향이니까 두 방향에 다 해줘야한다. 
			adjList[end].add(new Node(start, weight));
		}
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		int start = 0;
		int end = N-1;
//		해당 인덱스에 올 때까지의 최소 거리를 저장해놓는 배열
		distance[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, distance[start]));
		
		Node temp;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			if(visited[temp.vertex]) continue;
			
			visited[temp.vertex] = true;
			if(temp.vertex == end) break;

			
			for (Node node : adjList[temp.vertex]) {
				if(!visited[node.vertex] && distance[node.vertex] > temp.weight + node.weight) {
					distance[node.vertex] = temp.weight + node.weight;
					pq.offer(new Node(node.vertex, distance[node.vertex]));
				}
			}
			
			
		}
		
		

	}
}
