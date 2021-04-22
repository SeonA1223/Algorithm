package Day210422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N : 노드 갯수
// N*N
public class 다익스트라인접행렬 {
	static int N;
	static int adjMatrix[][];
	static int distance[];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		adjMatrix = new int[N + 1][N + 1];
		distance = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1에서 시작해서 N로도착하는 제일 짧은 거리
		Arrays.fill(distance, Integer.MAX_VALUE);
		int start = 1;
		int end = N;

		distance[start] = 0;
		int min;
		int minVertex = 0;

		for (int i = 1; i <= N; i++) {
			min = Integer.MAX_VALUE;

			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					minVertex = j;
				}
			}

			visited[minVertex] = true;
			if (minVertex == end)
				break;

			for (int j = 1; j <= N; j++) {
				if (!visited[j] && adjMatrix[minVertex][j] != 0
						&& distance[j] > min + adjMatrix[minVertex][j]) {
					distance[j] = min + adjMatrix[minVertex][j];
				}
			}
		}
		System.out.println(distance[end]);

	}
}
