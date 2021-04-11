package Day210411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_17103_골드바흐파티션 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 소수는 true
		final int MAX = 1000000;
		boolean prime[] = new boolean[MAX + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;

		for (int i = 2; i * i <= MAX; i++) {
			if (prime[i]) {
				for (int j = i + i; j <= MAX; j += i) {
					prime[j] = false;
				}
			}
		}

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(br.readLine());
			int count = 0;

			for (int j = 1; j <= n/2; j++) {
				if (prime[j] && prime[n - j])
					count++;
			}
			sb.append(count + " ");
		}
		System.out.println(sb.toString());

	}

}
