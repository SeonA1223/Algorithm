package Day210418;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16236_아기상어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int sharkX = 0, sharkY = 0;
		int sharkSize = 2;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 9) {
					sharkX = i;
					sharkY = j;
					map[i][j] = 0;
				} else {
					map[i][j] = value;
				}
			}
		}

		int res = 0;
		int ate = 0;
		while (true) {
			// 레벨에대한 배열을 가져오기
			int[][] dis = bfs(map, sharkX, sharkY, sharkSize);
			int minDis = Integer.MAX_VALUE;
			int nx = 0, ny = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dis[i][j] != -1 && 0 < map[i][j] && map[i][j] < sharkSize) {
						if (minDis > dis[i][j]) {
							minDis = dis[i][j];
							nx = i;
							ny = j;
						}
					}
				}
			}

			if (minDis == Integer.MAX_VALUE) {
				System.out.println(res);
				break;
			} else {
				map[nx][ny] = 0;
				sharkX = nx;
				sharkY = ny;
				res += minDis;
				ate += 1;
				if (ate >= sharkSize) {
					sharkSize++;
					ate = 0;
				}
			}
		}
	}

	private static int[][] bfs(int[][] map, int sharkX, int sharkY, int sharkSize) {
		int N = map.length;
		int dis[][] = new int[N][N];

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { sharkX, sharkY });

		for (int i = 0; i < N; i++) {
			Arrays.fill(dis[i], -1);
		}
		dis[sharkX][sharkY] = 0;

		int[] temp;
		while (!q.isEmpty()) {
			temp = q.poll();
			int x = temp[0];
			int y = temp[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 > nx || nx >= N || 0 > ny || ny >= N)
					continue;
				if (dis[nx][ny] != -1)
					continue;

				if (map[nx][ny] <= sharkSize) {
					dis[nx][ny] = dis[x][y] + 1;
					q.offer(new int[] { nx, ny });

				}

			}

		}
		return dis;
	}

}
