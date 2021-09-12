package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14391_종이조각 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int res = 0;

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		int allCase = 1 << (N * M);

		for (int i = 0; i < allCase; i++) {
			// 0은 가로
			// 1은 세로
			int temp;
			int sum = 0;

			for (int j = 0; j < N; j++) {
				temp = 0;
				for (int k = 0; k < M; k++) {
					int loc = j * M + k;
					if ((i & 1 << loc) == 0) {
						temp = temp * 10 + arr[j][k];
					} else {
						sum += temp;
						temp = 0;
					}
				}
				sum += temp;
			}

			for (int k = 0; k < M; k++) {
				temp = 0;
				for (int j = 0; j < N; j++) {
					int loc = j * M + k;
					if ((i & 1 << loc) > 0) {
						temp = temp * 10 + arr[j][k];
					} else {
						sum += temp;
						temp = 0;
					}
				}
				sum += temp;
			}
			res = Math.max(res, sum);
		}
		System.out.println(res);
	}
}
