package problem210322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1753_최단경로2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine());
		final int INFINITY = Integer.MAX_VALUE;

		int[][] matrix = new int[V + 1][V + 1];
		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			Arrays.fill(matrix[i], INFINITY);
		}

		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			matrix[u][v] = w;
		}

		for (int i = 1; i <= V; i++) {
			matrix[i][i] = 0;
		}

		Arrays.fill(distance, INFINITY);
		distance[start] = 0;

		int min = 0, current = 0;
		for (int i = 0; i < V; ++i) {
			// a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			min = INFINITY;
			for (int j = 0; j < V; ++j) {
				if (!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true; // 선택 정점 방문 처리

			// b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for (int c = 0; c < V; ++c) {
				if (!visited[c] && matrix[current][c] != 0 && distance[c] > min + matrix[current][c]) {
					distance[c] = min + matrix[current][c];
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INFINITY) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}

	}
}
