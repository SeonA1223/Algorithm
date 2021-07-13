package Day210711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1956_운동2 {
	static int V, E;
	static int dp[][];
	static final int MAX = 1000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		dp = new int[V + 1][V + 1];

		for (int i = 0; i <= V; i++) {
			Arrays.fill(dp[i], MAX);
			dp[i][i] = 0;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			dp[a][b] = c;
		}

		// 플로이샬 워드 알고리즘 사용
		for (int k = 1; k <= V; k++) { // 경유지
			for (int i = 1; i <= V; i++) { // 출발
				for (int j = 1; j <= V; j++) { // 도착
					if (i == j)
						continue;
					if (dp[i][k] + dp[k][j] < dp[i][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
					}
				}
			}
		}

		int ans = MAX;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j)
					continue;
				if (dp[i][j] != MAX && dp[j][i] != MAX) {
					ans = Math.min(ans, dp[i][j] + dp[j][i]);
				}
			}
		}

		System.out.println(ans == MAX ? -1 : ans);
	}
}
