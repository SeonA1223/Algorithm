package problem210702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_BOJ_2151_거울설치 {
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
//		int[][] house = new int[N][N];
		int startX = 0;
		int startY = 0;
		int mirrorCnt = 0;
		int dCnt = 0;
		for (int i = 0; i < N; i++) {
			house[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (house[i][j] == '#') {
					startX= i;
					startY= j;
				} 
			}
		}
		
		bfs(N, house, startX, startY, mirrorCnt);
	}

	private static void bfs(int n, char[][] house, int sx, int sy, int mirrorCnt) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[][][] visited = new boolean[n][n][4];
		q.offer(new Node(sx, sy, -1, 0));
		for (int i = 0; i < 4; i++) {
			visited[sx][sy][i] = true;
		}
		house[sx][sy] = '.';

		Node temp = null;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int mCnt = temp.mCnt;
			int dir = temp.dir;

			if (house[x][y] == '#') {
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

					visited[dx][dy][i] = true;
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

							visited[dx][dy][i] = true;
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

							visited[dx][dy][i] = true;
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

				visited[dx][dy][dir] = true;

				q.offer(new Node(dx, dy, dir, mCnt));
			}
		}

	}
}


