package Day210413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_활주로건설 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			int land[][] = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					land[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 경우의 수
			int count = 0;
			boolean check;
			// 행판단
			int before;
			int size;
			for (int i = 0; i < N; i++) {
				check = true;
				before = land[i][0];
				size = 0;

				for (int j = 0; j < N; j++) {

					if (Math.abs(before - land[i][j]) > 1) {
						check = false;
						break;
					}

					if (before == land[i][j]) {
						size++;
						continue;
					} else if (land[i][j] - before == 1) {
						if (size < x) {
							check = false;
							break;
						} else {
							before = land[i][j];
							size = 1;
						}
					} else if (land[i][j] - before == -1) {
						int num = land[i][j];

						if (j + x - 1 >= N) {
							check = false;
							break;
						} else {

							for (int k = j; k < j + x; k++) {
								if (num != land[i][k]) {
									check = false;
									break;
								}
							}
							if (check) {
								before = land[i][j];
								size = 0;
								j += x - 1;
							}
						}
					}

				}
				if (check)
					count++;
			}
			// 열판단
			for (int j = 0; j < N; j++) {
				check = true;
				before = land[0][j];
				size = 0;

				for (int i = 0; i < N; i++) {

					if (Math.abs(before - land[i][j]) > 1) {
						check = false;
						break;
					}

					if (before == land[i][j]) {
						size++;
						continue;
					} else if (land[i][j] - before == 1) {
						if (size < x) {
							check = false;
							break;
						} else {
							before = land[i][j];
							size = 1;
						}
					} else if (land[i][j] - before == -1) {
						int num = land[i][j];

						if (i + x - 1 >= N) {
							check = false;
							break;
						} else {

							for (int k = i; k < i + x; k++) {
								if (num != land[k][j]) {
									check = false;
									break;
								}
							}
							if (check) {
								before = land[i][j];
								size = 0;
								i += x - 1;
							}
						}
					}

				}
				if (check)
					count++;
			}

			sb.append(count).append("\n");
		}
		System.out.println(sb.toString());
	}
}
