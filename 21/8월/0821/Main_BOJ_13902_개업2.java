import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_13902_개업2 {
	static int N, M;
	static int[] dp, wok;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dp = new int[N + 1];
		wok = new int[M];
		flag = false;
		Arrays.fill(dp, Integer.MAX_VALUE);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int index = Integer.parseInt(st.nextToken());
			if (index == N) {
				System.out.println(1);
				return;
			}
			wok[i] = index;
			if (index > N)
				continue;
			dp[index] = Math.min(dp[index], 1);
		}

		// mC2
		comb(0, 0, 0);

		if (flag) {
			System.out.println(1);
			return;
		}

//		for (int i = 0; i < M; i++) {
//			for (int j = i+1; j < M; j++) {
//				int sum = wok[i] + wok[j];
//				if (sum == N) {
//					System.out.println(1);
//					return;
//				}
//				if(sum > N) continue;
//				dp[sum] = 1;
//			}
//		}

		for (int i = 1; i <= N; i++) {
			if (dp[i] != Integer.MAX_VALUE) {
				for (int j = 1; j <= N; j++) {
					if (dp[j] == Integer.MAX_VALUE)
						continue;
					if (i + j > N)
						continue;
					dp[i + j] = Math.min(dp[i + j], dp[i] + dp[j]);
				}
			}
		}

		if (dp[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}

	}

	private static void comb(int index, int cnt, int sum) {
		if (flag)
			return;

		if (cnt == 2) {
			if (sum == N)
				flag = true;
			if (sum <= N)
				dp[sum] = Math.min(dp[sum], 1);
			return;
		}

		if (index >= M)
			return;

		comb(index + 1, cnt + 1, sum + wok[index]);
		comb(index + 1, cnt, sum);

	}

//	시작 인덱스 : index, 

}
