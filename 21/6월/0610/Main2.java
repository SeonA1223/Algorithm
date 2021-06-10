package Day210610;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int T, W;
	static int[] fallPlumLoc;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		fallPlumLoc = new int[T + 1];
		int[][] dp = new int[T + 1][3];

		for (int i = 1; i <= T; i++) {
			fallPlumLoc[i] = Integer.parseInt(br.readLine());
		}

		int a = W;
		int b = W;
		for (int i = 1; i <= T; i++) {
			int loc = fallPlumLoc[i];
			if (loc == 1) {
				dp[i][1] = dp[i - 1][1] + 1;
				if (b > 0) {
					if (dp[i - 1][1] + 1 > dp[i - 1][2]) {
						dp[i][2] = dp[i - 1][1] + 1;
						b--;
						continue;
					}
				}
				dp[i][2] = dp[i-1][2];
				
			} else {
				dp[i][2] = dp[i - 1][2] + 1;
				if (a > 0) {
					if (dp[i - 1][2] + 1 > dp[i - 1][1]) {
						dp[i][1] = dp[i - 1][2] + 1;
						a--;
						continue;
					}
				}
				dp[i][1] = dp[i-1][1];
			}
		}
		
		System.out.println(Math.max(dp[T][1], dp[T][2]));
	}

}