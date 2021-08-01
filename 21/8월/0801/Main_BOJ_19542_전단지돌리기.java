package Day210801;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BOJ_19542_전단지돌리기 {
	static int N, S, D;
	static List<Integer>[] nodes;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		nodes = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodes[a].add(b);
			nodes[b].add(a);
		}
		
		visited = new boolean[N+1];
		dfs(S, 0, 0);
	}

	private static void dfs(int start, int depth, int total) {
		if(depth > D) return;
		visited[start] = true;
		
		for(int node : nodes[start]) {
			if(!visited[node]) {
				if(depth <= D && nodes[node].size() == 1) {
					for(int temp : nodes[node]) {
						visited[temp] = true;
					}
					continue;
				}
				dfs(node, depth+1, total+1);
			}
		}
		
	}
}
