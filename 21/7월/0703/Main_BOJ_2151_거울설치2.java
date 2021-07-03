package Day210703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_BOJ_2151_거울설치2 {
	static int res;
	static int direct[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 동 서 남 북 12 34

	static class Node implements Comparable<Node> {
		int x, y;
		int mCnt;
		int dir;

		public Node(int x, int y, int dir, int mCnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.mCnt = mCnt;
		}

		@Override
		public int compareTo(Node o) {
			return this.mCnt - o.mCnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] house = new char[N][N];
//      int[][] house = new int[N][N];
		int[][] door = new int[2][2];
		int mirrorCnt = 0;
		int dCnt = 0;
		for (int i = 0; i < N; i++) {
			house[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (house[i][j] == '#') {
					door[dCnt][0] = i;
					door[dCnt++][1] = j;
				}
			}
		}

		bfs(N, house, door, mirrorCnt);
	}

	private static void bfs(int n, char[][] house, int[][] door, int mirrorCnt) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[][][] visited = new boolean[n][n][4];
		int sx = door[0][0];
		int sy = door[0][1];

		q.offer(new Node(sx, sy, -1, 0));
		house[sx][sy] = '.';

		Node temp = null;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int mCnt = temp.mCnt;
			int dir = temp.dir;

			if (dir != -1) {
				if (visited[x][y][dir])
					continue;
				visited[x][y][dir] = true;
			}

			if (x == door[1][0] && y == door[1][1]) {
				System.out.println(mCnt);
				return;
			}

			if (dir == -1) {
				for (int i = 0; i < 4; i++) {
					int dx = x + direct[i][0];
					int dy = y + direct[i][1];

					if (dx < 0 || dx >= n || dy < 0 || dy >= n)
						continue;
					if (house[dx][dy] == '*')
						continue;

//					visited[dx][dy][i] = true;
					q.offer(new Node(dx, dy, i, mCnt));

				}
			} else {

				if (house[x][y] == '!') {
					if (dir == 0 || dir == 1) {
						for (int i = 2; i < 4; i++) {
							int dx = x + direct[i][0];
							int dy = y + direct[i][1];

							if (dx < 0 || dx >= n || dy < 0 || dy >= n)
								continue;
							if (house[dx][dy] == '*')
								continue;
							if (visited[dx][dy][i])
								continue;
							q.offer(new Node(dx, dy, i, mCnt + 1));
						}
					}
					if (dir == 2 || dir == 3) {
						for (int i = 0; i < 2; i++) {
							int dx = x + direct[i][0];
							int dy = y + direct[i][1];

							if (dx < 0 || dx >= n || dy < 0 || dy >= n)
								continue;
							if (house[dx][dy] == '*')
								continue;
							if (visited[dx][dy][i])
								continue;

							q.offer(new Node(dx, dy, i, mCnt + 1));
						}
					}
				}
				int dx = x + direct[dir][0];
				int dy = y + direct[dir][1];

				if (dx < 0 || dx >= n || dy < 0 || dy >= n)
					continue;
				if (house[dx][dy] == '*')
					continue;
				if (visited[dx][dy][dir])
					continue;

				q.offer(new Node(dx, dy, dir, mCnt));
			}
		}
	}
}
