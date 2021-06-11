package problem210611;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_15881_ppap {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char arr[] = new char[n];
		char ppap[] = { 'p', 'P', 'A', 'p' };
		int dp[] = new int[n];
		arr = br.readLine().toCharArray();

		for (int i = 0; i < n; i++) {
			if (i > 0 && arr[i] != ppap[0]) {
				dp[i] = dp[i - 1];
			}
			if (arr[i] == ppap[0] && dp[i] == 0) {
				boolean flag = true;
				for (int j = 1; j < ppap.length; j++) {
					if (i + j >= n || arr[i + j] != ppap[j]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					int cnt = 0;
					if (i == 0)
						cnt = 1;
					else
						cnt = dp[i - 1] + 1;
					for (int j = i; j < i + 4; j++) {
						dp[j] = cnt;
					}
					i += 3;
				} else {
					if (i > 0)
						dp[i] = dp[i - 1];
				}
			}
		}

		System.out.println(dp[n - 1]);

	}
}
