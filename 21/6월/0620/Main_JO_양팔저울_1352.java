package problem210620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_JO_양팔저울_1352 {
	static int N, M,maxGusel;
	static boolean[][] dp;
	static int[] chu, guseul;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		chu = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			chu[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());

		guseul = new int[M];
		maxGusel = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			guseul[i] = Integer.parseInt(st.nextToken());
			maxGusel = Math.max(maxGusel, guseul[i]);
		}

		dp = new boolean[N + 1][40000];

		dfs(0, 0);
		
		for (int i=0; i<M; i++) {
			if(dp[N][guseul[i]]) {
				System.out.print("Y ");
			}else {
				System.out.print("N ");
			}
		}

	}

	private static void dfs(int cnt, int weight) {
		// 이미 판단가능하면 더 이상 가지 않기
		if (dp[cnt][weight])
			return;
		dp[cnt][weight] = true;
		if (cnt >= N)
			return;

		// 현재무게에서 더하는 경우
		dfs(cnt + 1, weight + chu[cnt]);
		// 그냥 넘어가는 경우
		dfs(cnt + 1, weight);
		// 빼는 경우
		dfs(cnt + 1, Math.abs(weight - chu[cnt]));
	}
}
