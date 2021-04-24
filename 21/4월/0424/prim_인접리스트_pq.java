package Day210424;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class prim_인접리스트_pq {
	static List<Node>[] adjlist;

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

		adjlist = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjlist[i] = new ArrayList<>();
		}

		int[] distance = new int[N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjlist[start].add(new Node(end, weight)); // 무향이니까 두 방향에 다 해줘야한다.
			adjlist[end].add(new Node(start, weight));
		}

		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int current = 0;
		distance[current] = 0;
		pq.offer(new Node(current, distance[current]));
		
		int res=0;
		int cnt=0;
		Node temp;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			if(visited[temp.vertex]) continue;
			
			visited[temp.vertex]= true;
			res += distance[temp.vertex];
			if(++cnt == N) break;
			
			for(Node node : adjlist[temp.vertex]) {
				if(!visited[node.vertex] && distance[node.vertex] > node.weight) {
					distance[node.vertex] = node.weight;
					pq.offer(new Node(node.vertex, distance[node.vertex]));
				}
			};
			
		}
		System.out.println(res);
	}
}
