package problem210319;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_수영장 {
	static int fee[];
	static int monthly[];
	static int minCost;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			fee = new int[4];
			monthly = new int[13];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= 12; i++) {
				monthly[i] = Integer.parseInt(st.nextToken());
			}
			minCost = 987654321;
			dfs(1, 0);
			sb.append(minCost).append("\n");

		}
		System.out.println(sb.toString());

	}

	private static void dfs(int month, int sum) {
		if (month > 12) {
			if(minCost > sum) {
				minCost = sum;
			}
			int e = fee[3];
			minCost = Math.min(e, minCost);
			return;
		}

		int a = fee[0] * monthly[month];
		int b = fee[1];

		dfs(month + 1, sum + Math.min(a, b));
		dfs(month+3, sum + fee[2]);

	}

}
