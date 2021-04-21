package Day210421;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine()); // 학생 수
			M = Integer.parseInt(br.readLine()); // 학생들 사이의 키를 비교한 횟수

			arr = new int[N + 1][N + 1]; // 1부터 시작하기 때문에
			visited = new boolean[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				arr[from][to] = 1;
			}

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				taller(i, i);
				smaller(i, i);
				if (check(i))
					ans++;
			}

			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean check(int index) {
		boolean flag = true;
		for (int i = 1; i <= N; i++) {
			if (!visited[index][i]) {
				flag = false;
				break;
			}
		}

		return flag;

	}

	private static void smaller(int i, int j) {
		visited[i][j] = true;
		for (int k = 1; k <= N; k++) {
			if (arr[k][j] == 1 && !visited[i][k]) {
				smaller(i, k);
			}
		}

	}

	private static void taller(int i, int j) { // i가 몇번째 수check j가 판단
		visited[i][j] = true;
		for (int k = 1; k <= N; k++) {
			if (arr[j][k] == 1 && !visited[i][k]) {
				taller(i, k);
			}
		}

	}

}
