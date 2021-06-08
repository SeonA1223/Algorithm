package Day210608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1256_사전 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		final int MAX_NUM = 1000000000;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 'a'의 갯수
		int M = Integer.parseInt(st.nextToken()); // 'z'의 갯수
		int K = Integer.parseInt(st.nextToken()); // 'k'번째 문자열(코드에서는 0번째부터 시작인데, 문제에서는 1부터 시작)

		// 첫번째로 (N+M)C(M)의 경우의 수를 구해야한다.
		// 구하기 위해서는 조합의 공식을 dp를 이용해서 구한다.
		// N, M 각각 100개 이하로 주어짐
		// 파스칼의 삼각형
		int[][] dp = new int[201][101];
		dp[0][0] = 1;
		for (int i = 1; i <= N + M; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < i && j <= M; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i-1][j];
				if (dp[i][j] >= MAX_NUM)
					dp[i][j] = MAX_NUM;

			}
			if(i<=M) dp[i][i] = 1;
		} // 모든 경우의 수를 다 구함

		
		K--;
		if (dp[N + M][M] <= K)
			System.out.println(-1);
		else {
			for (int i = N + M - 1; i >= 0; i--) {
				if (i >= M && dp[i][M] > K)
					sb.append("a");
				else {
					sb.append("z");
					K -= dp[i][M];
					M--;
				}
			}
		}
		System.out.println(sb.toString());

	}
}
