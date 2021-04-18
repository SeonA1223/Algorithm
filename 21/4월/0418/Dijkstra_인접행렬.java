package Day210418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra_인접행렬 {
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
		
		int minVertex;
		int min;
		
		for (int c = 0; c < N; c++) {
			min = Integer.MAX_VALUE;
			minVertex = 0;
			
			for (int i = 0; i < N; i++) {
				if(!visited[i] && min > distance[i]) {
					min = distance[i];
					minVertex = i;
				}
			}
			
			visited[minVertex] = true;
			if(minVertex == end) break;
			
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && distance[i] > min + adjMatrix[minVertex][i]) {
					distance[i] = min + adjMatrix[minVertex][i];
				}
			}
			
		}
		
		System.out.println(distance[end]);
	}
}
