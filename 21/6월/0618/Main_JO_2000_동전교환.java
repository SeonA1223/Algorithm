package problem210618;

import java.util.Arrays;
import java.util.Scanner;

public class Main_JO_2000_동전교환 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int coin[] = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}
		Arrays.sort(coin);
		int W = sc.nextInt();
		int dp[] = new int[W + 1];
		
		for (int i = 0; i < N; i++) {
			dp[coin[i]] = 1;
		}

		for (int i = 1; i <= W; i++) {
			for (int j = 0; j < N; j++) {
				if (coin[j] <= i) {
					if (dp[i] == 0) {
						if(dp[i-coin[j]] > 0)
						dp[i] = dp[i - coin[j]] + dp[coin[j]];
					} else {
						if( dp[i - coin[j]] > 0)
						dp[i] = Math.min(dp[i], dp[i - coin[j]] + dp[coin[j]]);
					}
				}
			}
		}
		
		if(dp[W] == 0) {
			System.out.println("impossible");
		}else {
			System.out.println(dp[W]);
		}

	}

}
