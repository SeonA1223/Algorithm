package problem210614;

import java.util.Scanner;

public class Main_JO_1407_숫자카드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int dp[] = new int[s.length() + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= s.length(); i++) {
			String temp = s.substring(i - 2, i);
			int num = Integer.parseInt(temp);
			if (s.charAt(i - 1) == '0') {
				if (num > 34)
					break;
				else {
					dp[i] = dp[i - 1];
				}
			} else {
				if (10 <= num && num <= 34) {
					dp[i] = dp[i - 1] + dp[i - 2];
				} else {
					dp[i] = dp[i - 1];
				}
			}
		}

		System.out.println(dp[s.length()]);
	}
}
