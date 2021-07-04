package problem210704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_16954_움직이는미로탈출 {
	static int dx[] = { 0, 0, 1, -1, 1, 1, -1, -1 };
	static int dy[] = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] game = new char[8][8];
		for (int i = 0; i < 8; i++) {
			game[i] = br.readLine().toCharArray();
		}

		boolean[][] visited = new boolean[8][8];
		int sx = 7;
		int sy = 0;
		int ex = 0;
		int ey = 7;

		if (startGame(sx, sy, ex, sy, game, visited)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static char[][] moveWall(char[][] game) {
		char[][] temp = new char[8][8];

		for (int j = 0; j < 8; j++) {
			for (int i = 6; i >= 0; i--) {
				if (game[i][j] == '#') {
					temp[i + 1][j] = '#';
					temp[i][j] = '.';
				}
			}
		}
		return temp;
	}

	private static boolean startGame(int x, int y, int ex, int ey, char[][] game, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
//		visited[x][y] = true;

		int[] temp;
		while (!q.isEmpty()) {
			int size = q.size();

			while (--size >= 0) {
				temp = q.poll();

				if (game[temp[0]][temp[1]] == '#')
					continue;
				for (int i = 0; i < 8; i++) {
					int nx = temp[0] + dx[i];
					int ny = temp[1] + dy[i];

					if(nx == ex && ny == ey) return true;
					if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8)
						continue;
					if (visited[nx][ny] || game[nx][ny] == '#')
						continue;

//					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });

				}
				q.offer(new int[] { temp[0], temp[1] });
			}
			game = moveWall(game);

		}
		return false;

	}
}
