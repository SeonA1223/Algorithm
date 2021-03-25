package problem210325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7737_LIS {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());

			int[] seq = new int[N];
			int[] LIS = new int[N];
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}

			int max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if (seq[i] > seq[j] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				max = Math.max(max, LIS[i]);
			}

			sb.append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
