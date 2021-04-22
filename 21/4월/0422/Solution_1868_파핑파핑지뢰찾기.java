package Day210422;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1868_파핑파핑지뢰찾기 {
	static int N, landNum, ans;
	static char map[][];
	static boolean visited[][];
	static int dx[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int dy[] = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			landNum = 0;
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.')
						landNum++;
				}
			}

			ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						if (notAroundBomb(i, j) == 0) {
							bfs(i, j, visited, map);
							landNum++;
						}
					}
				}
			}

//			ans += findLand(map);

			sb.append(landNum).append("\n");

		}
		System.out.println(sb.toString());
	}

//	private static int findLand(char[][] newMap) {
//		int count = 0;
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (newMap[i][j] == '.') {
//					count++;
//				}
//			}
//		}
//		return count;
//	}

	private static int notAroundBomb(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });
		int bombC = 0;

		int[] temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			int xx = temp[0];
			int yy = temp[1];
			for (int i = 0; i < 8; i++) {
				int nx = xx + dx[i];
				int ny = yy + dy[i];

				if (0 > nx || nx >= N || 0 > ny || ny >= N)
					continue;

				if (map[nx][ny] == '*')
					bombC++;

			}
		}
		return bombC;
	}

	private static void bfs(int x, int y, boolean[][] visited, char[][] newMap) {
		visited[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { x, y });

		int[] temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			int xx = temp[0];
			int yy = temp[1];
			int bombC = notAroundBomb(xx, yy);
			landNum--;
			
			

			newMap[xx][yy] = (char) (bombC + '0');
			if (bombC == 0) {
				for (int i = 0; i < 8; i++) {
					int nx = xx + dx[i];
					int ny = yy + dy[i];
					if (0 > nx || nx >= N || 0 > ny || ny >= N)
						continue;
					if (visited[nx][ny]) 
						continue;
					if( newMap[nx][ny] != '.') continue;
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
			}

		}

	}
}
