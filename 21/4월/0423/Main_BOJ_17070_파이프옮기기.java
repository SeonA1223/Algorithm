package Day210423;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_17070_파이프옮기기 {
	static int N, cases;
	static int arr[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 가로 = 0 세로 = 1 대각선 = 2
		cases = 0;
		dfs(0, 1, 0);
		System.out.println(cases);

	}

	private static void dfs(int i, int j, int dir) {
		if (dir == 2) {
			if (i - 1 >= 0 && i - 1 < N && j - 1 >= 0 && j - 1 < N) {
				if (arr[i - 1][j] == 1 || arr[i][j - 1] == 1)
					return;
			}
		}
		if (arr[i][j] == 1)
			return;
		if (i == N - 1 && j == N - 1) {
			cases++;
			return;
		}
		if (0 > i || i >= N || 0 > j || j >= N)
			return;

		if (dir == 0) { // 가로
			// 가로로 갈 경우
			dfs(i, j + 1, 0);
			// 대각선으로 갈 경우
			dfs(i + 1, j + 1, 2);
		} else if (dir == 1) {// 세로
			// 세로로 갈 경우
			dfs(i + 1, j, 1);
			// 대각선으로 갈 경우
			dfs(i + 1, j + 1, 2);
		} else if (dir == 2) { // 대각선
			// 가로로 갈 경우
			dfs(i, j + 1, 0);
			// 세로로 갈 경우
			dfs(i + 1, j, 1);
			// 대각선으로 갈 경우
			dfs(i + 1, j + 1, 2);
		}

	}

}
