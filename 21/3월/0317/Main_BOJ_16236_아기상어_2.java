package problem210317;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16236_아기상어_2 {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static int[][] bfs(int[][] space, int sx, int sy, int ssize) {
		Queue<int[]> q = new LinkedList<>();
		int N = space.length;
		int dis[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dis[i], -1);
		}
		q.offer(new int[] { sx, sy });
		dis[sx][sy] = 0;

		while (!q.isEmpty()) {
			int[] xy = q.poll();
			int x = xy[0];
			int y = xy[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if (space[nx][ny] <= ssize && dis[nx][ny] == -1) {
						dis[nx][ny] = dis[x][y] + 1;
						q.offer(new int[] { nx, ny });
					}

				}
			}
		}

		return dis;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int space[][] = new int[N][N];
		int sharkX = 0, sharkY = 0, sharkSize = 2;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 9) {
					sharkX = i;
					sharkY = j;
					space[i][j] = 0;
				} else {
					space[i][j] = input;
				}
			}
		}

		int result = 0;
		int ate = 0;
		while (true) {
			int[][] dis = bfs(space, sharkX, sharkY, sharkSize);
			int smallFishX = 0, smallFishY = 0;
			int minValue = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dis[i][j] != -1 && 0 < space[i][j] && space[i][j] < sharkSize) {
						if (minValue > dis[i][j]) {
							minValue = dis[i][j];
							smallFishX = i;
							smallFishY = j;
						}
					}
				}
			}
			if (minValue == Integer.MAX_VALUE) {
				System.out.println(result);
				break;
			} else {
				sharkX = smallFishX;
				sharkY = smallFishY;
				result += minValue;
				space[smallFishX][smallFishY] = 0;
				ate += 1;
				if (ate >= sharkSize) {
					sharkSize++;
					ate = 0;
				}
			}

		}

	}

}
