package problem210325;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int INF = 987654321;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int value = Integer.parseInt(st.nextToken());
					if (i != j && value == 0) {
						arr[i][j] = INF;
					} else {
						arr[i][j] = value;
					}
				}
			}

			for (int k = 1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					if (i == k)
						continue;
					for (int j = 1; j <= N; j++) {
						if (i == j && j == k)
							continue;
						if (arr[i][j] > arr[i][k] + arr[k][j]) {
							arr[i][j] = arr[i][k] + arr[k][j];
						}
					}
				}
			}

			int[] res = new int[N + 1];
			int min = INF;
			int index = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					res[i] += arr[i][j];
				}
				if (min > res[i]) {
					min = res[i];
				}

			}

			sb.append(min).append("\n");

		}
		System.out.println(sb.toString());
	}
}
