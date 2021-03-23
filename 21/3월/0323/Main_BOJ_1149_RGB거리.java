package problem210323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] table = new int[N][2];
		int res = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (min > arr[0][i]) {
				min = arr[0][i];
				table[0][0] = min;
				table[0][1] = i;
			}
		}
		res = min;

		for (int i = 1; i < N; i++) {
			int select = table[i - 1][1];
			int value = arr[i][select];

			int find = Integer.MAX_VALUE;
			int index = 0;
			for (int j = 0; j < 3; j++) {
				if (j == select)
					continue;
				if (find > arr[i][j]) {
					find = arr[i][j];
					index = j;
				}
			}

			if (table[i - 1][0] > value) {
				int next = Integer.MAX_VALUE;
				for (int j = 0; j < 3; j++) {
					if (j == select)
						continue;
					if (next > arr[i - 1][j]) {
						next = arr[i - 1][j];
					}
				}
				res = Math.min(next + value, table[i - 1][0] + find);
				table[i][0] = value;
				table[i][1] = select;
			} else {
				res += find;
				table[i][0] = find;
				table[i][1] = index;
			}

		}
		System.out.println(res);
	}
}
