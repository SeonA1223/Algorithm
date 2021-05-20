package Day210520;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1647_도시분할계획 {
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
		nodes = new ArrayList[N+1];

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
//		subset(1, new int[N+1]);
		System.out.println(ans);

	}

//	private static void subset(int n, int[] visited) {
//		if (n == N+1) {
//			// 연결이 됐는지 체크
//			if (isConnect(visited, 0) && isConnect(visited, 1)) {
//				int a = getMinDistance(visited, 0);
//				int b = getMinDistance(visited, 1);
//				
//				ans = Math.min(ans, a+b);
//			}
//			return;
//		}
//		visited[n] = 0;
//		subset(n + 1, visited);
//		visited[n] = 1;
//		subset(n + 1, visited);
//	}

	private static int getMinDistance(int[] divided, int d) {
		int distance[] = new int[N+1];
		boolean visited[] = new boolean[N+1];
		int cnt = 0;
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (divided[i] == d) {
				if (cnt == 0) {
					distance[i] = 0;
					pq.offer(new Node(i, distance[i]));
					cnt++;
				}
				cnt++;
			}
		}
		
		Node temp;
		int res = 0;
		int num = 0;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			if(visited[temp.vertex]) continue;
			
			visited[temp.vertex] = true;
			res += temp.weight;
			num++;
			if(num == cnt) break;
			
			for (Node node : nodes[temp.vertex]) {
				if(!visited[node.vertex] && divided[node.vertex] == d && distance[node.vertex] > node.weight) {
					distance[node.vertex] = node.weight;
					pq.offer(new Node(node.vertex, distance[node.vertex]));
				}
			}
		}
		return res;
			
	}
//	private static int getMinDistance(int[] divided, int d) {
//		int distance[] = new int[N+1];
//		boolean visited[] = new boolean[N+1];
//		int cnt = 0;
//		Arrays.fill(distance, Integer.MAX_VALUE);
//		for (int i = 1; i <= N; i++) {
//			if (divided[i] == d) {
//				if (cnt == 0) {
//					distance[i] = 0;
//					cnt++;
//				}
//				cnt++;
//			}
//		}
//
//		int cur = 0;
//		int res = 0;
//		int min = 0;
//		int num = 0;
//		for (int i = 1; i <= N; i++) {
//			min = Integer.MAX_VALUE;
//			for (int j = 1; j <= N; j++) {
//				if (divided[j] == d && !visited[j] && min > distance[j]) {
//					min = distance[j];
//					cur = j;
//				}
//			}
//			if(min == Integer.MAX_VALUE) continue;
//			visited[cur] = true;
//			res += min;
//			if(++num == cnt) break;
//
//			for (Node node : nodes[cur]) {
//				if (!visited[node.vertex] && divided[node.vertex] == d && distance[node.vertex] > node.weight) {
//					distance[node.vertex] = node.weight;
//				}
//			}
//
//		}
//		return res;

//	}

	private static boolean isConnect(int[] divided, int d) {
		Queue<Integer> q = new LinkedList<>();
		// 0번 체크
		boolean isConnect[] = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if (divided[i] == d) {
				q.offer(i);
				isConnect[i] = true;
				break;
			}
		}

		if (q.isEmpty())
			return false;

		int num;
		while (!q.isEmpty()) {
			num = q.poll();

			for (int i = 0; i < nodes[num].size(); i++) {
				int value = nodes[num].get(i).vertex;
				if (!isConnect[value] && divided[value] == d ) {
					isConnect[value] = true;
					q.offer(value);

				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (divided[i] != d)
				continue;
			if (divided[i] == d && isConnect[i] == false)
				return false;
		}
		return true;

	}
}
