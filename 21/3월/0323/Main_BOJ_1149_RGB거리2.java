package problem210323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1149_RGB거리2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] table = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		table[0][0] = arr[0][0];
		table[0][1] = arr[0][1];
		table[0][2] = arr[0][2];

		for (int i = 1; i < N; i++) {
			table[i][0] = Math.min(arr[i][0] + table[i - 1][1], arr[i][0] + table[i - 1][2]);
			table[i][1] = Math.min(arr[i][1] + table[i - 1][0], arr[i][1] + table[i - 1][2]);
			table[i][2] = Math.min(arr[i][2] + table[i - 1][0], arr[i][2] + table[i - 1][1]);
		}
		
		System.out.println(Math.min(Math.min(table[N-1][0], table[N-1][1]), table[N-1][2]));
	}
}