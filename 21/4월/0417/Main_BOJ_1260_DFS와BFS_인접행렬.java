package Day210417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1260_DFS와BFS_인접행렬 {
	static int[][] adjMatrix;
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		adjMatrix = new int[N+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
			
		}
		
		dfs(S, new boolean[N+1]);
		sb.append("\n");
		bfs(S, N);
		System.out.println(sb.toString());

	}

	private static void bfs(int s, int N) {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[N+1];
		
		q.offer(s);
		visited[s] = true;
		
		int temp;
		while(!q.isEmpty()) {
			temp = q.poll();
			sb.append(temp).append(" ");
			
			for(int i=1; i<=N; i++) {
				if(adjMatrix[temp][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}

	private static void dfs(int s, boolean visited[]) {
		if(visited[s]) return;
		
		visited[s] = true;
		sb.append(s).append(" ");
		
		for (int i = 1; i <= N; i++) {
			if(adjMatrix[s][i] == 1 && !visited[i]) {
				dfs(i, visited);
				}
			}
		
	}

}
