package problem210619;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1077_배낭채우기1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[][] jewerly = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			jewerly[i][0] = weight;
			jewerly[i][1] = price;
		}

		int dp[] = new int[W + 1];

		for (int i = 1; i <= W; i++) {
			for (int j = 1; j <= N; j++) {
				int weight = jewerly[j][0];
				int price = jewerly[j][1];
				if (i < weight)
					continue;
				dp[i] = Math.max(dp[i], dp[i - weight] + price);
			}
		}
		
		System.out.println(dp[W]);
	}
}
