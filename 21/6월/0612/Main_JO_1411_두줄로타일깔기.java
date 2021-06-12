package problem210612;

import java.util.Scanner;
//40분
public class Main_JO_1411_두줄로타일깔기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = 20100529;

		long[] dp = new long[n + 1];

		int n1 = 1;
		int n2 = 2;
		dp[1] = n1;
		dp[2] = n1 + n2;

		for (int i = 3; i <= n; i++) {
			dp[i] = ((n1 * dp[i-1]) % num )+ ((n2 * dp[i-2] % num));
		}

		System.out.println(dp[n] % num);
	}
}
