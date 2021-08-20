package problem210820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14863_서울에서경산까지 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] info = new int[N][4];
		int[][] dp = new int[N][K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int walkT = Integer.parseInt(st.nextToken());
			int walkM = Integer.parseInt(st.nextToken());
			int rideT = Integer.parseInt(st.nextToken());
			int rideM = Integer.parseInt(st.nextToken());

			info[i][0] = walkT;
			info[i][1] = walkM;
			info[i][2] = rideT;
			info[i][3] = rideM;
		}

//		info 0, 2는 시간 1, 3은 돈
		if (info[0][0] <= K)
			dp[0][info[0][0]] = info[0][1];
		if (info[0][2] <= K)
			dp[0][info[0][2]] = Math.max(dp[0][info[0][2]], info[0][3]);

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < K; j++) {
				if (dp[i - 1][j] == 0)
					continue;

				if (j + info[i][0] <= K)
					dp[i][j + info[i][0]] = Math.max(dp[i][j + info[i][0]], dp[i - 1][j] + info[i][1]);

				if (j + info[i][2] <= K)
					dp[i][j + info[i][2]] = Math.max(dp[i][j + info[i][2]], dp[i - 1][j] + info[i][3]);

			}
		}

		int res = 0;
		for (int i = 0; i <= K; i++) {
			res = Math.max(res, dp[N - 1][i]);
		}

		System.out.println(res);

	}
}
