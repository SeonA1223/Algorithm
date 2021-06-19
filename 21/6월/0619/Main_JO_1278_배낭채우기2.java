package problem210619;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_JO_1278_배낭채우기2 {
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

		Arrays.sort(jewerly, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});

		int dp[][] = new int[N + 1][W + 1];

		for (int i = 1; i <= N; i++) { // 보석
			for (int j = 1; j <= W; j++) { // 무게
				int weight = jewerly[i][0];
				int price = jewerly[i][1];

				if (j < weight) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + price);
				}
			}
		}

		System.out.println(dp[N][W]);

	}
}
