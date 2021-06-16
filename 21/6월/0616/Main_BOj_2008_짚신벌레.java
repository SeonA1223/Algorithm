package problem210616;

import java.util.Scanner;

public class Main_BOj_2008_짚신벌레 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int d = sc.nextInt();
		int N = sc.nextInt();

		int dp[][] = new int[N + 1][d + 1];
		// 태어난 날
		dp[0][0] = 1;

		for (int i = 1; i <= N; i++) {
			int newWorm = 0;
			for (int j = d; j >= 1; j--) {
				if (dp[i - 1][j - 1] > 0) {
					dp[i][j] += (dp[i - 1][j - 1] % 1000);
					if (a <= j && j < b) {
						newWorm += dp[i][j];
						newWorm = newWorm % 1000;
					}
				}
			}
			dp[i][0] = newWorm;
		}

		long res = 0;
		for (int j = 0; j <= N; j++) {
			int sum = 0;
			for (int i = 0; i < d; i++) {
				res += (dp[N][i]);
				res %= 1000;
				sum += dp[j][i];
			}
			System.out.println(sum);
		}
		System.out.println(res % 1000);

	}
}
