package Day210520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1647_도시분할계획2 {
	static int N, M, ans;
	static List<Node>[] nodes;

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
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nodes = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int h3 = Integer.parseInt(st.nextToken());
			nodes[h1].add(new Node(h2, h3));
			nodes[h2].add(new Node(h1, h3));
		}

		// 부분집합
		ans = Integer.MAX_VALUE;
		System.out.println(getMinDistance());
		
		

	}
	
	private static int getMinDistance() {
		int distance[] = new int[N+1];
		boolean visited[] = new boolean[N+1];
		int cnt = 0;
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int start = 1;
		distance[start] = 0;
		pq.offer(new Node(start, distance[start]));
		
		Node temp;
		int res = 0;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			if(visited[temp.vertex]) continue;
			
			visited[temp.vertex] = true;
			res += temp.weight;
			cnt++;
			if(cnt == N) break;
			
			for (Node node : nodes[temp.vertex]) {
				if(!visited[node.vertex] &&  distance[node.vertex] > node.weight) {
					distance[node.vertex] = node.weight;
					pq.offer(new Node(node.vertex, distance[node.vertex]));
				}
			}
		}
		
		Arrays.sort(distance);
		res -= distance[N-1];
		return res;
			
	}
}
