package Day210419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 프림_인접리스트 {
	static class Node {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점 수
		int C = Integer.parseInt(st.nextToken()); // 연결 수

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
			adjList[start].add(new Node(end, weight)); // 무향이니까 두 방향에 다 해줘야한다.
			adjList[end].add(new Node(start, weight));
		}

		Arrays.fill(distance, Integer.MAX_VALUE);
		int minVertex = 0;
		int min = 0;
		int res = 0;
		int cnt = 0;

		// 시작인덱스 0
		distance[0] = 0;

		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;

			for (int j = 0; j < N; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					minVertex = j;
				}
			}

			visited[minVertex] = true;
			res += min;
			if(++cnt == N) break;

			for (Node node : adjList[minVertex]) {
				if (!visited[node.vertex] && distance[node.vertex] > node.weight)
					distance[node.vertex] = node.weight;
			}
		}
	}
}
