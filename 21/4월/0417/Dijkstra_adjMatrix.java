package Day210417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dijkstra_adjMatrix {
	static int[] distance;
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int map[][] = new int[N][N];
		distance = new int[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			distance[i] = Integer.MAX_VALUE;
		}
		
		//시작은 0부터
		distance[0] = 0;
		
		int end = N-1;
		
		int min,  minDistance;
		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
			minDistance = 0;
			
			for (int j = 0; j < N; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					minDistance = j;
				}				
			}
			
			visited[minDistance] = true;
			if(minDistance == end) break;
			
			for (int j = 0; j < N; j++) {
				if(!visited[j] && map[minDistance][j] != 0 && distance[j] > min + map[minDistance][j])
					distance[j] = min + map[minDistance][j];
			}
			
		}
		
		System.out.println(distance[end]);
	}

}
