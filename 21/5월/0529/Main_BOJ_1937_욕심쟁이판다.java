package Day210529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1937_욕심쟁이판다 {
	static int N, res;
	static int bamboo[][];
	static int dp[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		bamboo = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				bamboo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dp[i][j] == 0) {
					int v = dfs(i, j);
					res = Math.max(res, v);
				}
			}
		}

		System.out.println(res);
	}

	/*
	 * private static int findLonglive() { int maxLive = 0;
	 * 
	 * for (int i = 0; i < N; i++) { for (int j = 0; j < N; j++) { maxLive =
	 * Math.max(maxLive, dp[i][j]); } } return maxLive; }
	 */

	private static int dfs(int x, int y) {

		dp[x][y] = 1;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (bamboo[x][y] >= bamboo[nx][ny])
				continue;
			if (dp[nx][ny] != 0 && dp[nx][ny] + 1 > dp[x][y]) {
				dp[x][y] = dp[nx][ny] + 1;

			} else if (dp[nx][ny] == 0) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
			}
		}

		return dp[x][y];

	}
}
