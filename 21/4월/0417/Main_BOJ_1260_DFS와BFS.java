package Day210417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1260_DFS와BFS {
	static List<Integer>[] list;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(list[i]);			
		}
		
		
		bfs(S, N);
		System.out.println(sb.toString());

	}

	private static void bfs(int s, int N) {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[N+1];
		
		//방문체크를 큐에 들어갈 때 해주기
		visited[s] = true;
		q.offer(s);
		
		int temp;
		while(!q.isEmpty()) {
			temp = q.poll();
			sb.append(temp).append(" ");
			
			for(int i: list[temp]) {
				if(!visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		
	}

	private static void dfs(int s, boolean visited[]) {
		if(visited[s]) return;
		
		visited[s] = true;
		sb.append(s).append(" ");
		
		for (int i : list[s]) {
			if(!visited[i])
				dfs(i, visited);
			
		}
		
	}

}
