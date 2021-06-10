package Day210610;

import java.util.Scanner;

public class Main_BOJ_2579_계단오르기 {
	static int dp[][], stairs[], stairsNum;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		stairsNum = sc.nextInt();
		stairs = new int[stairsNum + 1];

		for (int i = 1; i <= stairsNum; i++) {
			stairs[i] = sc.nextInt();
		}

		dp = new int[3][stairsNum + 1];

		func(1, 1, 0, 1);
		func(2, 2, 0, 2);

		System.out.println(Math.max(dp[1][stairsNum], dp[2][stairsNum]));
	}

	private static void func(int cur, int jump, int cnt, int before) {
		if (cnt == 2)
			return;
		if (cur > stairsNum)
			return;

		if (dp[jump][cur] < dp[before][cur - jump] + stairs[cur]) {
			dp[jump][cur] = dp[before][cur - jump] + stairs[cur];
			func(cur + 1, 1, cnt + 1, jump);
			func(cur + 2, 2, 1, jump);
		}
	}

}
