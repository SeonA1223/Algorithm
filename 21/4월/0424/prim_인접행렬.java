package Day210424;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prim_인접행렬 {
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
		distance[start] = 0;
		
		int min_index = 0;
		int min = 0;
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			min = Integer.MAX_VALUE;
			for(int j=0; j<N; j++) {
				if(!visited[j] && min > distance[j]) {
					min_index = j;
					min = distance[j];
				}
			}
			
			visited[min_index] = true;
			sum += min;
			
			
			for(int j=0; j<N; j++) {
				if(!visited[j] && adjMatrix[min_index][j] != 0 
						&& distance[j] > adjMatrix[min_index][j] ) {
					distance[j] = adjMatrix[min_index][j];
				}
			}
		}
		
		System.out.println(sum);
	}
}
