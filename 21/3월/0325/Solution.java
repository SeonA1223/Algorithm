package problem210325;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int res = 0;
	static int x1, y1, x2, y2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			x1 = sc.nextInt() + 100;
			y1 = sc.nextInt() + 100;
			x2 = sc.nextInt() + 100;
			y2 = sc.nextInt() + 100;

			bfs();
			System.out.println("#" + t + " " + res);
		}

	}

	static int[] dx = { 0, 0, -1, 1 }; // 상하,좌우
	static int[] dy = { -1, 1, 0, 0 };

	static void bfs() {
		Queue<Data> q = new LinkedList<>();
		boolean[][][] v = new boolean[201][201][2];
		q.offer(new Data(x1, y1, 0, 0)); // 0 가로, 1 : 세로
		q.offer(new Data(x1, y1, 0, 1)); // 0 가로, 1 : 세로
		v[y1][x1][0] = true;
		v[y1][x1][1] = true;

		Data cur = null;
		int nx, ny;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur.x == x2 && cur.y == y2) {
				res = cur.cnt;
				return;
			}
			if (cur.dir == 0) {// 가로
				for (int d = 0; d < 2; d++) {
					nx = cur.x + dx[d];
					ny = cur.y + dy[d];
//                    범위체크
					if (nx < 0 || nx >= 201 || ny < 0 || ny >= 201) {
						continue;
					}
//                    방문체크
					if (v[ny][nx][1]) {
						continue;
					}
//                    재방문위해서 큐에 삽입
					v[ny][nx][1] = true;
					q.offer(new Data(nx, ny, cur.cnt + 1, 1));
				}
			} else { // 세로
				for (int d = 2; d < 4; d++) {
					nx = cur.x + dx[d];
					ny = cur.y + dy[d];
//                    범위체크
					if (nx < 0 || nx >= 201 || ny < 0 || ny >= 201) {
						continue;
					}
//                    방문체크
					if (v[ny][nx][0]) {
						continue;
					}
//                    재방문위해서 큐에 삽입
					v[ny][nx][0] = true;
					q.offer(new Data(nx, ny, cur.cnt + 1, 0));
				}
			}

		}

	}

	static class Data {
		int x, y;
		int cnt;
		int dir;

		public Data(int x, int y, int cnt, int dir) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}

	}
}
