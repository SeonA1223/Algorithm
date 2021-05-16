package Day210516;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14391_종이조각 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int arr[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		int res = 0; // 정답 판단
		// 모든 경우의 수 판단
		// 가로는 0 세로는 1
		for (int c = 0; c < (1 << N * M); c++) {
			int sum = 0;
			// 가로 판단
			for (int row = 0; row < N; row++) {
				int cur = 0;
				for (int col = 0; col < M; col++) {
					int index = row * M + col;
					if ((c & (1 << index)) == 0) {
						cur = cur * 10 + arr[row][col];
					} else {
						sum += cur;
						cur = 0;
					}
				}
				sum += cur;
			}
			// 세로 판단
			for (int col = 0; col < M; col++) {
				int cur = 0;
				for (int row = 0; row < N; row++) {
					int index = row * M + col;
					if ((c & (1 << index)) != 0) {
						cur = cur * 10 + arr[row][col];
					} else {
						sum += cur;
						cur = 0;
					}
				}
				sum += cur;
			}

			res = Math.max(res, sum);
		}
		
		System.out.println(res);

	}
}
