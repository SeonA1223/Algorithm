package Day210418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim_인접리스트_PQ {
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
		int current = 0;
		distance[current] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(current, distance[current]));
		
		Node temp;
		int res = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			if(visited[temp.vertex]) continue;
			
			visited[temp.vertex] = true;
			res += distance[temp.vertex];
			cnt++;
			
			if(cnt == N) break;
			
			for (Node node : adjList[temp.vertex]) {
				if(!visited[node.vertex] && distance[node.vertex] > node.weight) {
					distance[node.vertex] = node.weight;
					pq.offer(new Node(node.vertex, distance[node.vertex]));
				}
			}
			
			
		}
		
		

	}
}
