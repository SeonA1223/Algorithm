package problem210616;

import java.util.Scanner;

public class Main_BOj_2008_짚신벌레2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); // 부화, 새 개체 생성
		int b = sc.nextInt(); // 새 객체 생성 불가
		int d = sc.nextInt(); // death
		int N = sc.nextInt();

		int dp[] = new int[N + 1];
		// 태어난 날
		dp[0] = 1;

		for (int i = 1; i <= N; i++) {
			if (i < a)
				dp[i] = (dp[i - 1]) % 1000;
			else if (i < b)
				dp[i] = (dp[i - 1] + dp[i - a]) % 1000;
			else 
				dp[i] = (1000 + dp[i - 1] + dp[i - a] - dp[i - b]) % 1000;

		}

		if (N >= d)
			System.out.println((1000 +dp[N] - dp[N - d]) % 1000);
		else 
			System.out.println(dp[N]);


	}
}
