package problem210704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_16954_움직이는미로탈출2 {
	static int dx[] = { 0, 0, 1, -1, 1, 1, -1, -1, 0 };
	static int dy[] = { 1, -1, 0, 0, 1, -1, 1, -1, 0 };
	static int MOVE = 9;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] game = new char[8][8];
		boolean[][][] visited = new boolean[9][8][8];

		for (int i = 0; i < 8; i++) {
			game[i] = br.readLine().toCharArray();
		}

		boolean check = startGame(game, visited);
		System.out.println(check ? 1 : 0);
	}

	private static boolean startGame(char[][] game, boolean[][][] visited) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 7, 0, 0 });
		visited[0][7][0] = true;

		while (!q.isEmpty()) {
			int size = q.size();

			int[] temp = null;
			while (--size >= 0) {
				temp = q.poll();
				int x = temp[0];
				int y = temp[1];
				int t = temp[2];

				for (int i = 0; i < MOVE; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					int nt = Math.min(t + 1, 8);

					if (nx == 0 && ny == 7)
						return true;

					if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8)
						continue;
					// 현재벽에 부딪힐 경우
					if (nx - t >= 0 && game[nx - t][ny] == '#')
						continue;
					if (nx - t - 1 >= 0 && game[nx - t - 1][ny] == '#')
						continue;

					if (visited[nt][nx][ny])
						continue;
					visited[nt][nx][ny] = true;
					q.offer(new int[] { nx, ny, nt });

				}
			}
		}
		return false;
	}
}
