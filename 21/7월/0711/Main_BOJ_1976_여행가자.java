package Day210711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1976_여행가자 {
	static int N, M;
	static int[][] cities;
	static int[] path;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		cities = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				cities[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		path = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			path[i] = Integer.parseInt(st.nextToken());
		}

		boolean flag = true;
		for (int i = 0; i < M - 1; i++) {
			if (!isConnect(path[i], path[i + 1])) {
				flag = false;
				break;
			}
		}

		System.out.println(flag ? "YES" : "NO");

	}

	private static boolean isConnect(int start, int end) {
		boolean visited[] = new boolean[N + 1];
		boolean flag = dfs(start, end, visited);
		return flag;
	}

	private static boolean dfs(int node, int end, boolean[] visited) {
		if (visited[node])
			return false;
		visited[node] = true;
		if (node == end)
			return true;

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && cities[node][i] == 1) {
				if(dfs(i, end, visited)) return true;
			}
		}
		return false;
	}
}
