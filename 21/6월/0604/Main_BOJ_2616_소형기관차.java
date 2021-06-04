package Day210604;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BOJ_2616_소형기관차 {
	static int N, M, res;
	static int train[];
	static int dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		train = new int[N + 1];
		dp = new int[N + 1];// 1부터 시작할거임
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			train[i] = Integer.parseInt(st.nextToken());
			dp[i] = dp[i-1] + train[i];
		}
		M = Integer.parseInt(br.readLine());
		res = 0;

		for (int i = 0; i <= N-(3*M); i++) {
			dfs(i, 0, 0);
		}
		
		System.out.println(res);
		
	}

	private static void dfs(int order, int add, int depth) {
		if(depth == 3) {
			res = Math.max(res, add);
			return;
		}
		
		for (int i = order; i <= N-M; i++) {
			dfs(i+M, add + dp[i+M] - dp[i], depth+1);
		}
		
	}
}
