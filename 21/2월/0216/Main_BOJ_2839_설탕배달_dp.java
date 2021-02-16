package problem210216;

import java.util.Scanner;

public class Main_BOJ_2839_설탕배달_dp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int dp[] = new int[N + 1]; // "N"값일때를 알고 싶기 때문에

		for (int i = 1; i <= N; i++) {
			if (i % 3 == 0) {
				dp[i] = i / 3;
			} else {
				dp[i] = Integer.MAX_VALUE;
			}
		}
		for (int i = 5; i <= N; i++) {
			if (dp[i - 5] != Integer.MAX_VALUE && dp[i] > dp[i - 5] + 1) {
				dp[i] = dp[i - 5] + 1;
			}
		}
		
		System.out.println(dp[N] == Integer.MAX_VALUE ? "-1" : dp[N]);
	}

}
