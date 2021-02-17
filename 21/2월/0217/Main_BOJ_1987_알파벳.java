package problem210217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1987_알파벳 {
	static char board[][];
	static boolean visit[][], capital[];
	static int R, C;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int maxCount = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열

		board = new char[R][C];
		visit = new boolean[R][C];
		capital = new boolean[26];

		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		dfs(0, 0, 1);
		System.out.println(maxCount);

	}

	private static void dfs(int x, int y, int count) {
		int alphabet = board[x][y] - 'A';
		capital[alphabet] = true;
		visit[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (0 <= nx && nx < R && 0 <= ny && ny < C) {
				if (!visit[nx][ny]) {
					int a = board[nx][ny] - 'A';
					if (!capital[a]) {
						dfs(nx, ny, count+1);
						capital[a] = false;
						visit[nx][ny] = false;
					}
				}
			}
		}
		maxCount = Math.max(maxCount, count);

	}

}
