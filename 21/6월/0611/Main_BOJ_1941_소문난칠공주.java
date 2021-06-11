package problem210611;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1941_소문난칠공주 {
	static char[][] girlClass;
	static final int NUM = 5;
	static int res;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		girlClass = new char[NUM][NUM];
		res = 0;
		visited = new boolean[NUM][NUM];

		for (int i = 0; i < NUM; i++) {
			girlClass[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < NUM; i++) {
			for (int j = 0; j < NUM; j++) {
				char c = girlClass[i][j];
				int S = 0;
				int Y = 0;
				if (c == 'Y') {
					Y++;
				} else {
					S++;
				}
				visited[i][j] = true;
				dfs(i, j, S, Y);
				visited[i][j] = false;

			}
		}
		System.out.println(res);
	}

	private static void dfs(int x, int y, int S, int Y) {
		if (Y >= 4)
			return;
		if (S + Y == 7 && S >= 4) {
			res++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= NUM || ny < 0 || ny >= NUM)
				continue;
			if (visited[nx][ny])
				continue;

			visited[nx][ny] = true;
			if (girlClass[nx][ny] == 'S')
				S++;
			else
				Y++;
			dfs(nx, ny, S, Y);	
			visited[nx][ny] = false;
			if (girlClass[nx][ny] == 'S')
				S--;
			else
				Y--;
		}

		return;
	}
}
